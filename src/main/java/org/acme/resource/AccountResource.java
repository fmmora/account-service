package org.acme.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.AccountDTO;
import org.acme.service.AccountService;

import java.util.List;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    AccountService accountService;

    @GET
    @Path("/{accountNumber}")
    public AccountDTO getByAccountNumber(@PathParam("accountNumber") String accountNumber) {
        return accountService.getByAccountNumber(accountNumber);
    }

    @GET
    @Path("/customer/{customerId}")
    public List<AccountDTO> getByCustomerId(@PathParam("customerId") Long customerId) {
        return accountService.getByCustomerId(customerId);
    }
}
