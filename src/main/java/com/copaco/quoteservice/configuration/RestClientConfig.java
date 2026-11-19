package com.copaco.quoteservice.configuration;

import com.copaco.quoteservice.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;


@Configuration
@Slf4j
public class RestClientConfig {

    @Bean
    public RestClient quoteRestClient() {
        return RestClient.builder()
            .defaultStatusHandler(HttpStatusCode::isError, ((request, response) -> {
                log.error(response.getStatusText(), response.getBody());
                log.info("--------------------");
                throw new BaseException(response.getBody().toString(),
                    response.getStatusCode().value());
            }))
            .baseUrl("https://dummyjson.com")
            .build();
    }

}
