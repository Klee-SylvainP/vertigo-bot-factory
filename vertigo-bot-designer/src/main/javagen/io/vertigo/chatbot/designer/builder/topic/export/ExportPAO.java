package io.vertigo.chatbot.designer.builder.topic.export;

import javax.inject.Inject;

import io.vertigo.core.node.Node;
import io.vertigo.core.lang.Assertion;
import io.vertigo.core.lang.Generated;
import io.vertigo.datamodel.task.TaskManager;
import io.vertigo.datamodel.task.definitions.TaskDefinition;
import io.vertigo.datamodel.task.model.Task;
import io.vertigo.datamodel.task.model.TaskBuilder;
import io.vertigo.datastore.impl.dao.StoreServices;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
 @Generated
public final class ExportPAO implements StoreServices {
	private final TaskManager taskManager;

	/**
	 * Constructeur.
	 * @param taskManager Manager des Task
	 */
	@Inject
	public ExportPAO(final TaskManager taskManager) {
		Assertion.check().isNotNull(taskManager);
		//-----
		this.taskManager = taskManager;
	}

	/**
	 * Creates a taskBuilder.
	 * @param name  the name of the task
	 * @return the builder 
	 */
	private static TaskBuilder createTaskBuilder(final String name) {
		final TaskDefinition taskDefinition = Node.getNode().getDefinitionSpace().resolve(name, TaskDefinition.class);
		return Task.builder(taskDefinition);
	}

	/**
	 * Execute la tache TkExportRelativeTrainingSentence.
	 * @param botId Long
	 * @return DtList de NluTrainingExport tpcs
	*/
	@io.vertigo.datamodel.task.proxy.TaskAnnotation(
			name = "TkExportRelativeTrainingSentence",
			request = "select   " + 
 "             	nts.nts_id,  " + 
 "             	nts.text,  " + 
 "             	top.top_id" + 
 " 			from nlu_training_sentence nts  " + 
 " 			join topic top on (top.top_id = nts.top_id)  " + 
 " 			where top.bot_id = #botId#  " + 
 " 			and top.is_enabled = true",
			taskEngineClass = io.vertigo.basics.task.TaskEngineSelect.class)
	@io.vertigo.datamodel.task.proxy.TaskOutput(smartType = "STyDtNluTrainingExport")
	public io.vertigo.datamodel.structure.model.DtList<io.vertigo.chatbot.commons.domain.topic.NluTrainingExport> exportRelativeTrainingSentence(@io.vertigo.datamodel.task.proxy.TaskInput(name = "botId", smartType = "STyId") final Long botId) {
		final Task task = createTaskBuilder("TkExportRelativeTrainingSentence")
				.addValue("botId", botId)
				.build();
		return getTaskManager()
				.execute(task)
				.getResult();
	}

	/**
	 * Execute la tache TkExportResponseButtonByBotId.
	 * @param botId Long
	 * @return DtList de ResponseButtonExport rbes
	*/
	@io.vertigo.datamodel.task.proxy.TaskAnnotation(
			name = "TkExportResponseButtonByBotId",
			request = "select   " + 
 "             	top.top_id," + 
 "             	top.code as top_code," + 
 "             	top_response.code as top_code_response,  " + 
 "             	rbu.text  " + 
 " 			from response_button rbu" + 
 " 			join small_talk smt on (smt.smt_id = rbu.smt_id)  " + 
 " 			join topic top on (top.top_id = smt.top_id)" + 
 " 			join topic top_response on (top_response.top_id = rbu.top_id_response)  " + 
 " 			where top.bot_id = #botId#  " + 
 " 			and top.is_enabled = true" + 
 " 			order by rbu.btn_id asc",
			taskEngineClass = io.vertigo.basics.task.TaskEngineSelect.class)
	@io.vertigo.datamodel.task.proxy.TaskOutput(smartType = "STyDtResponseButtonExport")
	public io.vertigo.datamodel.structure.model.DtList<io.vertigo.chatbot.designer.domain.topic.export.ResponseButtonExport> exportResponseButtonByBotId(@io.vertigo.datamodel.task.proxy.TaskInput(name = "botId", smartType = "STyId") final Long botId) {
		final Task task = createTaskBuilder("TkExportResponseButtonByBotId")
				.addValue("botId", botId)
				.build();
		return getTaskManager()
				.execute(task)
				.getResult();
	}

	/**
	 * Execute la tache TkExportResponseButtonUrlByBotId.
	 * @param botId Long
	 * @return DtList de ResponseButtonUrlExport rbes
	*/
	@io.vertigo.datamodel.task.proxy.TaskAnnotation(
			name = "TkExportResponseButtonUrlByBotId",
			request = "select" + 
 "             	top.top_id," + 
 "             	top.code as top_code," + 
 "             	rbu.text," + 
 "             	rbu.url," + 
 "             	rbu.new_tab" + 
 " 			from response_button_url rbu" + 
 " 			join small_talk smt on (smt.smt_id = rbu.smt_id)" + 
 " 			join topic top on (top.top_id = smt.top_id)" + 
 " 			where top.bot_id = #botId#" + 
 " 			and top.is_enabled = true" + 
 " 			order by rbu.btn_id asc",
			taskEngineClass = io.vertigo.basics.task.TaskEngineSelect.class)
	@io.vertigo.datamodel.task.proxy.TaskOutput(smartType = "STyDtResponseButtonUrlExport")
	public io.vertigo.datamodel.structure.model.DtList<io.vertigo.chatbot.designer.domain.topic.export.ResponseButtonUrlExport> exportResponseButtonUrlByBotId(@io.vertigo.datamodel.task.proxy.TaskInput(name = "botId", smartType = "STyId") final Long botId) {
		final Task task = createTaskBuilder("TkExportResponseButtonUrlByBotId")
				.addValue("botId", botId)
				.build();
		return getTaskManager()
				.execute(task)
				.getResult();
	}

	/**
	 * Execute la tache TkExportUtterTextByBotId.
	 * @param botId Long
	 * @return DtList de UtterTextExport rbes
	*/
	@io.vertigo.datamodel.task.proxy.TaskAnnotation(
			name = "TkExportUtterTextByBotId",
			request = "select   " + 
 "             	top.top_id,  " + 
 "             	STRING_AGG (ut.text, '|') as utter_texts,  " + 
 "             	rty.rty_id as response_type, " + 
 "             	coalesce (smt.is_end, false) as is_end," + 
 "             	top.kto_cd" + 
 " 			from utter_text ut" + 
 " 			join small_talk smt on (smt.smt_id = ut.smt_id)  " + 
 " 			join response_type rty on (rty.rty_id = smt.rty_id)" + 
 " 			join topic top on (top.top_id = smt.top_id)  " + 
 " 			where top.bot_id = #botId# " + 
 " 			and top.is_enabled = true" + 
 " 			group by top.top_id, rty.rty_id, smt.is_end",
			taskEngineClass = io.vertigo.basics.task.TaskEngineSelect.class)
	@io.vertigo.datamodel.task.proxy.TaskOutput(smartType = "STyDtUtterTextExport")
	public io.vertigo.datamodel.structure.model.DtList<io.vertigo.chatbot.designer.domain.topic.export.UtterTextExport> exportUtterTextByBotId(@io.vertigo.datamodel.task.proxy.TaskInput(name = "botId", smartType = "STyId") final Long botId) {
		final Task task = createTaskBuilder("TkExportUtterTextByBotId")
				.addValue("botId", botId)
				.build();
		return getTaskManager()
				.execute(task)
				.getResult();
	}

	/**
	 * Execute la tache TkGetScriptIntentionExportByBotId.
	 * @param botId Long
	 * @return DtList de ScriptIntentionExport rbes
	*/
	@io.vertigo.datamodel.task.proxy.TaskAnnotation(
			name = "TkGetScriptIntentionExportByBotId",
			request = "select   " + 
 "             	top.top_id,  " + 
 "             	sci.script as bt" + 
 " 			from topic top" + 
 " 			join script_intention sci on (sci.top_id = top.top_id)  " + 
 " 			where top.bot_id = #botId# " + 
 " 			and top.is_enabled = true",
			taskEngineClass = io.vertigo.basics.task.TaskEngineSelect.class)
	@io.vertigo.datamodel.task.proxy.TaskOutput(smartType = "STyDtScriptIntentionExport")
	public io.vertigo.datamodel.structure.model.DtList<io.vertigo.chatbot.designer.domain.topic.export.ScriptIntentionExport> getScriptIntentionExportByBotId(@io.vertigo.datamodel.task.proxy.TaskInput(name = "botId", smartType = "STyId") final Long botId) {
		final Task task = createTaskBuilder("TkGetScriptIntentionExportByBotId")
				.addValue("botId", botId)
				.build();
		return getTaskManager()
				.execute(task)
				.getResult();
	}

	private TaskManager getTaskManager() {
		return taskManager;
	}
}
