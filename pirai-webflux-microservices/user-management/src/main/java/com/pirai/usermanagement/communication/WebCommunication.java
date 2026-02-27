package com.pirai.usermanagement.communication;

import com.pirai.usermanagement.constants.MessageKeyConstants;
import com.pirai.usermanagement.dto.response.ApiResponse;
import com.pirai.usermanagement.exception.BadRequestException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebCommunication {

    private final WebClient webClient;

    public WebCommunication(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ApiResponse> getSampleValue() {
        return webClient.get().uri("/get").retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(ApiResponse.class)
                        .flatMap(object -> Mono.error(new BadRequestException(MessageKeyConstants.BAD_REQUEST))))
                .bodyToMono(ApiResponse.class);

    }
}

