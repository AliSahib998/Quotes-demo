package com.copaco.quoteservice.client.quote.model;

import java.util.List;

public record QuotesResponse(List<QuoteDto> quotes) {
}
