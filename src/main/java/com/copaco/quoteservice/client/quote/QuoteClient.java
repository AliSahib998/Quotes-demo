package com.copaco.quoteservice.client.quote;

import com.copaco.quoteservice.client.quote.model.QuoteDto;
import com.copaco.quoteservice.client.quote.model.QuotesResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class QuoteClient {

    private final RestClient restClient;


    public QuoteClient(@Qualifier("quoteRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public QuotesResponse getAllQuotes() {
        return restClient.get().uri("/quotes")
            .retrieve()
            .body(QuotesResponse.class);
    }

    public QuoteDto getRandomQuote() {
        return restClient.get().uri("/quotes/random")
            .retrieve()
            .body(QuoteDto.class);
    }

    public QuoteDto getQuoteById(Long id) {
        return restClient.get()
            .uri("/quotes/{id}", id).retrieve()
            .body(QuoteDto.class);
    }

}
