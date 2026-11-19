package com.copaco.quoteservice.controller;

import com.copaco.quoteservice.client.quote.model.QuoteDto;
import com.copaco.quoteservice.client.quote.model.QuotesResponse;
import com.copaco.quoteservice.service.QuoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    public ResponseEntity<QuotesResponse> getAllQuotes() {
        return ResponseEntity.ok(quoteService.getAllQuotes());
    }

    @GetMapping("/random")
    public ResponseEntity<QuoteDto> getRandomQuote() {
        return ResponseEntity.ok(quoteService.getRandomQuote());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteDto> getQuoteById(@PathVariable Long id) {
        return ResponseEntity.ok(quoteService.getQuoteById(id));
    }

}
