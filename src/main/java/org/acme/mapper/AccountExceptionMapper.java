package org.acme.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.exception.AccountNotFoundException;

import java.util.Map;

@Provider
public class AccountExceptionMapper implements ExceptionMapper<AccountNotFoundException> {

    @Override
    public Response toResponse(AccountNotFoundException ex) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(Map.of("message", ex.getMessage()))
                .build();
    }
}
