package com.copaco.quoteservice.service;

import com.copaco.quoteservice.client.quote.QuoteClient;
import com.copaco.quoteservice.client.quote.QuoteClientFeign;
import com.copaco.quoteservice.client.quote.model.QuoteDto;
import com.copaco.quoteservice.client.quote.model.QuotesResponse;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    private final QuoteClient quoteClient;
    private final QuoteClientFeign quoteClientFeign;

    public QuoteService(QuoteClient quoteClient, QuoteClientFeign quoteClientFeign) {
        this.quoteClient = quoteClient;
        this.quoteClientFeign = quoteClientFeign;
    }

    public QuotesResponse getAllQuotes() {
        quoteClientFeign.getAllQuotes();
        return quoteClient.getAllQuotes();
    }

    public QuoteDto getRandomQuote() {
        return quoteClient.getRandomQuote();
    }

    public QuoteDto getQuoteById(Long id) {
        return quoteClient.getQuoteById(id);
    }

}
