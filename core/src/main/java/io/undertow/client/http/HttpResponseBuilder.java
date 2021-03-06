package io.undertow.client.http;

import io.undertow.client.ClientResponse;
import io.undertow.util.HeaderMap;
import io.undertow.util.HttpString;

/**
 * A pending http request.
 *
 * @author Emanuel Muckenhuber
 */
final class HttpResponseBuilder {

    private final ResponseParseState parseState = new ResponseParseState();

    private int statusCode;
    private HttpString protocol;
    private String reasonPhrase;
    private final HeaderMap responseHeaders = new HeaderMap();

    public ResponseParseState getParseState() {
        return parseState;
    }

    HeaderMap getResponseHeaders() {
        return responseHeaders;
    }

    int getStatusCode() {
        return statusCode;
    }

    void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
    }

    String getReasonPhrase() {
        return reasonPhrase;
    }

    void setReasonPhrase(final String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    HttpString getProtocol() {
        return protocol;
    }

    @SuppressWarnings("unused")
    void setProtocol(final HttpString protocol) {
        this.protocol = protocol;
    }

    public ClientResponse build() {
      return new ClientResponse(statusCode, reasonPhrase, protocol, responseHeaders);
    }

}
