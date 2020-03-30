package com.server.api.app.api;

import com.sun.net.httpserver.Headers;

import lombok.Value;

@Value
public class ResponseEntity<T> {

    private final T body;
    private final Headers headers;
    private final com.server.api.app.api.StatusCode statusCode;
}