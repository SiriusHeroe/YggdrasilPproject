package com.server.api.app.api.user;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.server.api.app.api.Constants;
import com.server.api.app.api.Handler;
import com.server.api.app.api.ResponseEntity;
import com.server.api.app.api.StatusCode;
import com.server.api.app.errors.ApplicationExceptions;
import com.server.api.app.errors.GlobalExceptionHandler;
import com.server.api.domain.user.NewUser;
import com.server.api.domain.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

public class RegistrationHandler extends Handler {

    private final UserService userService;

    public RegistrationHandler(UserService userService, ObjectMapper objectMapper,
                               GlobalExceptionHandler exceptionHandler) {
        super(objectMapper, exceptionHandler);
        this.userService = userService;
    }

    @Override
    protected void execute(HttpExchange exchange) throws IOException {
        byte[] response;
        if ("POST".equals(exchange.getRequestMethod())) {
            ResponseEntity e = doPost(exchange.getRequestBody());
            exchange.getResponseHeaders().putAll(e.getHeaders());
            exchange.sendResponseHeaders(e.getStatusCode().getCode(), 0);
            response = super.writeResponse(e.getBody());
        } else {
            throw ApplicationExceptions.methodNotAllowed(
                    "Method " + exchange.getRequestMethod() + " is not allowed for " + exchange.getRequestURI()).get();
        }

        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();
    }

    private ResponseEntity<com.server.api.app.api.user.RegistrationResponse> doPost(InputStream is) {
        com.server.api.app.api.user.RegistrationRequest registerRequest = super.readRequest(is, com.server.api.app.api.user.RegistrationRequest.class);

        NewUser user = NewUser.builder()
                .login(registerRequest.getLogin())
                .password(PasswordEncoder.encode(registerRequest.getPassword()))
                .build();

        String userId = userService.create(user);

        RegistrationResponse response = new RegistrationResponse(userId);

        return new ResponseEntity<>(response,
                getHeaders(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON), StatusCode.OK);
    }
}
