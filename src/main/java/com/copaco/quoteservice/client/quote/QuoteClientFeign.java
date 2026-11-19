package com.copaco.quoteservice.client.quote;

import com.copaco.quoteservice.client.quote.model.QuoteDto;
import com.copaco.quoteservice.client.quote.model.QuotesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "quote-client", url = "${client.quote.url}")
public interface QuoteClientFeign {

    @GetMapping("/quotes")
    QuotesResponse getAllQuotes();

    @GetMapping("/quotes/random")
    QuoteDto getRandomQuote();

    @GetMapping("/quotes/{id}")
    QuoteDto getQuoteById(@PathVariable  Long id);

}
