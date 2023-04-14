package com.jordan.hplus.controller;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class HPlusExceptionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        ErrorType type = null;
        if (ex instanceof DataIntegrityViolationException) {
            type = ErrorType.InvalidSyntax;
        } else {
            type = ErrorType.DataFetchingException;
        }
        return GraphqlErrorBuilder.newError(env)
                .message("Received Message: " + ex.getMessage())
                .errorType(type)
                .build();
    }
}
