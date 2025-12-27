package org.acme.exception;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String accountNumber) {
        super("Account with number " + accountNumber + " not found");
    }

    public AccountNotFoundException(Long customerId) {
        super("No accounts found for customer with ID " + customerId);
    }
}
