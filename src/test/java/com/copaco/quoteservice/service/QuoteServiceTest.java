package com.copaco.quoteservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.copaco.quoteservice.client.quote.QuoteClient;
import com.copaco.quoteservice.client.quote.model.QuoteDto;
import com.copaco.quoteservice.client.quote.model.QuotesResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QuoteServiceTest {

    @InjectMocks
    private QuoteService quoteService;

    @Mock
    private QuoteClient quoteClient;

    @Test
    void getAllQuotes_returnQuotes() {
        List<QuoteDto> quotes = List.of(new QuoteDto(1L, "test", "test"));
        QuotesResponse quotesResponse = new QuotesResponse(quotes);
        when(quoteClient.getAllQuotes()).thenReturn(quotesResponse);

        QuotesResponse actual = quoteService.getAllQuotes();

        assertNotNull(actual.quotes());
    }

}
