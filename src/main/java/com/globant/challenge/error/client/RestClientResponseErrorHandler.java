package com.globant.challenge.error.client;

import com.globant.challenge.error.InvalidItemReferenceException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * Error handler to be injected to the {@link org.springframework.web.client.RestTemplate}
 *
 * @author gervasio.amy.
 */
@Component
public class RestClientResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError() ;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getRawStatusCode() == 404) {
            throw new InvalidItemReferenceException();
        }
    }
}
