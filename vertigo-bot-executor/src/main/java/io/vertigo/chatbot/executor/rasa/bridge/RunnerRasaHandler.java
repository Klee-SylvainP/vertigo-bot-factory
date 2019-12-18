package io.vertigo.chatbot.executor.rasa.bridge;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;

import io.vertigo.chatbot.commons.JaxrsProvider;
import io.vertigo.chatbot.commons.domain.RunnerInfo;
import io.vertigo.core.component.Activeable;
import io.vertigo.core.component.Component;
import io.vertigo.dynamo.file.model.VFile;
import io.vertigo.lang.Assertion;
import io.vertigo.lang.VSystemException;

public class RunnerRasaHandler extends AbstractRasaHandler implements Component, Activeable {

	private static final String MODEL_DIR = "models/";

	@Inject
	private JaxrsProvider jaxrsProvider;

	private WebTarget rasaTarget;;

	private Process rasaProcess;

	@Override
	public void start() {
		super.start();

		rasaTarget = jaxrsProvider.getWebTarget("http://localhost:5005/");

		LOGGER.info("Lancement de Rasa");
		rasaProcess = execRasa("run", "--enable-api");
	}

	@Override
	public void stop() {
		// stop child process

		if (rasaProcess.isAlive()) {
			rasaProcess.destroyForcibly();
		}
	}


	public RunnerInfo getState() {
		final RunnerInfo retour = new RunnerInfo();

		retour.setName("Rasa node");
		retour.setState(doGetRasaStatus());
		retour.setLoadedModelVersion(getRasaLoadedModel());
		retour.setAgentVersion(getRasaVersion());

		return retour;
	}

	private String doGetRasaStatus() {
		if (!rasaProcess.isAlive()) {
			return "Service down";
		}

		final Response modelResponse = rasaTarget.path("/status")
				.request(MediaType.APPLICATION_JSON)
				.get();

		final int status = modelResponse.getStatus();

		return status == 200 ? "Ok" : "Invalid model";
	}

	private Long getRasaLoadedModel() {
		final File[] modelFiles = new File(getBotPath() + MODEL_DIR).listFiles();

		if (modelFiles.length != 1) {
			return -1L;
		}

		final String name = modelFiles[0].getName();
		return Long.parseLong(name.substring(0, name.length()-7));
	}

	private String getRasaVersion() {
		if (!rasaProcess.isAlive()) {
			return "";
		}

		@SuppressWarnings("unchecked")
		final Map<String, String> wsVersion = rasaTarget.path("/version")
		.request(MediaType.APPLICATION_JSON)
		.get(Map.class);

		return wsVersion.get("version");
	}

	public void loadModel(final VFile model) {
		Assertion.checkNotNull(model);

		// clean old model
		try {
			FileUtils.cleanDirectory(new File(getBotPath() + MODEL_DIR));
		} catch (final IOException e) {
			throw new VSystemException(e, "Impossible de charger le modèle");
		}

		// persist to disk
		final String relativeModelFilePath = MODEL_DIR + model.getFileName();

		final File targetFile = new File(getBotPath() + relativeModelFilePath);

		try {
			FileUtils.copyInputStreamToFile(model.createInputStream(), targetFile);
		} catch (final IOException e) {
			throw new VSystemException(e, "Impossible de charger le modèle");
		}

		// use http API to tell Rasa to load the file
		final Map<String, String> param = new HashMap<>();
		param.put("model_file", relativeModelFilePath);

		final Response response = rasaTarget.path("/model")
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.json(param));

		@SuppressWarnings("unchecked")
		final Map<String, String> wsResponse = response.readEntity(Map.class);

		if (response.getStatus() != 204) {
			throw new VSystemException("Impossible de charger le modèle. {}", wsResponse.get("message"));
		}
	}
}
