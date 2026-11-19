package com.copaco.quoteservice.model;

public record RestErrorResponse(int statusCode, String message) {
}
