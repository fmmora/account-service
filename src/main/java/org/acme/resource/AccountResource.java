package org.acme.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.AccountDTO;
import org.acme.service.AccountService;

import java.math.BigDecimal;
import java.util.List;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    AccountService accountService;

    @POST
    @Path("/{accountNumber}/debit")
    public void debit(@PathParam("accountNumber") String accountNumber,
                      BigDecimal amount) {
        accountService.debit(accountNumber, amount);
    }

    @POST
    @Path("/{accountNumber}/credit")
    public void credit(@PathParam("accountNumber") String accountNumber,
                       BigDecimal amount) {
        accountService.credit(accountNumber, amount);
    }

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
