package com.server.api.app.errors;

import java.util.function.Function;
import java.util.function.Supplier;

public class ApplicationExceptions {

    public static Function<? super Throwable, RuntimeException> invalidRequest() {
        return thr -> new com.server.api.app.errors.InvalidRequestException(400, thr.getMessage());
    }

    public static Supplier<RuntimeException> methodNotAllowed(String message) {
        return () -> new com.server.api.app.errors.MethodNotAllowedException(405, message);
    }

    public static Supplier<RuntimeException> notFound(String message) {
        return () -> new com.server.api.app.errors.ResourceNotFoundException(404, message);
    }
}
