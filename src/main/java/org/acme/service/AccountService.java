package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dto.AccountDTO;
import org.acme.entity.Account;
import org.acme.exception.AccountNotFoundException;
import org.acme.mapper.AccountMapper;

import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class AccountService {

    @Inject
    AccountMapper accountMapper;

    @Transactional
    public void debit(String accountNumber, BigDecimal amount) {
        var account = getAndValidateAccount(accountNumber);
        validateBalance(account.balance);
        if (account.balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Account balance is less than the amount");
        }
        account.balance = account.balance.subtract(amount);
    }

    @Transactional
    public void credit(String accountNumber, BigDecimal amount) {
        var account = getAndValidateAccount(accountNumber);
        account.balance = account.balance.add(amount);
    }

    public AccountDTO getByAccountNumber(String accountNumber) {
        Account account = getAndValidateAccount(accountNumber);
        validateBalance(account.balance);
        return accountMapper.toDTO(account);
    }

    public List<AccountDTO> getByCustomerId(Long customerId) {
        List<Account> accounts = Account.list("customerId", customerId);
        return accountMapper.toDTOList(accounts);
    }

    private Account getAndValidateAccount(String accountNumber){
        Account account = Account.find("accountNumber", accountNumber).firstResult();
        if (account == null) {
            throw new AccountNotFoundException(accountNumber);
        }

        return account;
    }

    private void validateBalance(BigDecimal balance){
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("Account balance is negative");
        }
    }
}
