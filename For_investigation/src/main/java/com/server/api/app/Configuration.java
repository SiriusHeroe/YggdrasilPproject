package com.server.api.app;

import com.server.api.app.errors.GlobalExceptionHandler;
import com.server.api.data.user.InMemoryUserRepository;
import com.server.api.domain.user.UserRepository;
import com.server.api.domain.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

class Configuration {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final UserRepository USER_REPOSITORY = new InMemoryUserRepository();
    private static final UserService USER_SERVICE = new UserService(USER_REPOSITORY);
    private static final GlobalExceptionHandler GLOBAL_ERROR_HANDLER = new GlobalExceptionHandler(OBJECT_MAPPER);

    static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    static UserService getUserService() {
        return USER_SERVICE;
    }

    static UserRepository getUserRepository() {
        return USER_REPOSITORY;
    }

    public static GlobalExceptionHandler getErrorHandler() {
        return GLOBAL_ERROR_HANDLER;
    }
}