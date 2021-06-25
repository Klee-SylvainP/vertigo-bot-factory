package io.vertigo.chatbot.designer.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.io.IOUtils;

import io.vertigo.chatbot.commons.multilingual.utils.UtilsMultilingualResources;
import io.vertigo.core.lang.VSystemException;
import io.vertigo.core.locale.MessageText;

public final class HttpRequestUtils {

	private HttpRequestUtils() {
		//Utils class
	}

	public static HttpRequest createPostRequest(final String url, final BodyPublisher publisher) {
		return createPostRequest(url, Map.of(), publisher);
	}

	public static HttpRequest createPostRequest(final String url, final Map<String, String> headers, final BodyPublisher publisher) {
		return createRequestBuilder(url, headers).POST(publisher).build();
	}

	public static HttpRequest createPutRequest(final String url, final Map<String, String> headers, final BodyPublisher publisher) {
		return createRequestBuilder(url, headers).PUT(publisher).build();
	}

	public static <T extends Object> HttpResponse<T> sendRequest(HttpClient client, final HttpRequest request, final BodyHandler<T> handler, final int successStatutCode) {
		HttpResponse<T> response;
		client = client != null ? client : getBasicHttpClient();
		try {
			response = client.send(request, handler);
			if (response.statusCode() != successStatutCode) {
				throw new VSystemException(MessageText.of(UtilsMultilingualResources.SEND_REQUEST_ERROR).getDisplay() + request.uri().toString());
			}
		} catch (IOException | InterruptedException e) {
			throw new VSystemException(e.getMessage(), MessageText.of(UtilsMultilingualResources.SEND_REQUEST_ERROR).getDisplay());
		}
		return response;
	}

	public static <T extends Object> CompletableFuture<HttpResponse<T>> sendAsyncRequest(HttpClient client, final HttpRequest request, final BodyHandler<T> handler) {
		client = client != null ? client : getBasicHttpClient();
		return client.sendAsync(request, handler);
	}

	private static HttpClient getBasicHttpClient() {
		return HttpClient.newBuilder().version(Version.HTTP_1_1).build();
	}

	private static Builder createRequestBuilder(final String url, final Map<String, String> headers) {
		final URI uri = URI.create(url);
		final Builder builder = HttpRequest.newBuilder().uri(uri);
		if (!headers.isEmpty()) {
			for (final Entry<String, String> entry : headers.entrySet()) {
				builder.setHeader(entry.getKey(), entry.getValue());
			}
		}
		return builder;
	}

	public static String postToUrl(final String url, final byte[] data) {
		final HttpURLConnection urlConnection;
		try {
			urlConnection = (HttpURLConnection) new URL(url).openConnection();

			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			try (final OutputStream os = urlConnection.getOutputStream()) {
				os.write(data);
				os.flush();
			}

			final int responseCode = urlConnection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				try (final InputStream is = urlConnection.getInputStream()) {
					return IOUtils.toString(is, StandardCharsets.UTF_8);
				}
			}

			throw new VSystemException(MessageText.of(UtilsMultilingualResources.SEND_REQUEST_ERROR_WITH_PARAMS).getDisplay(), responseCode);
		} catch (final IOException e) {
			throw new VSystemException(e, MessageText.of(UtilsMultilingualResources.SEND_REQUEST_ERROR).getDisplay());
		}
	}

}
