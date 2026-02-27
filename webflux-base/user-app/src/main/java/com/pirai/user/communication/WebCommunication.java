package com.pirai.user.communication;

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

    public Mono<String> getString() {
        return webClient.get().uri("/apis/string").retrieve()
                .onStatus(HttpStatusCode::isError,
                        response -> response.bodyToMono(String.class).flatMap(
                                error -> Mono.error(new RuntimeException()))).bodyToMono(String.class);
    }

}