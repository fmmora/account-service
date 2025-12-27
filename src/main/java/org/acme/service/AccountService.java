package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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

    public AccountDTO getByAccountNumber(String accountNumber) {
        Account account = Account.find("accountNumber", accountNumber).firstResult();
        if (account == null) {
            throw new AccountNotFoundException(accountNumber);
        }

        if (account.balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("Account balance is negative");
        }
        return accountMapper.toDTO(account);
    }

    public List<AccountDTO> getByCustomerId(Long customerId) {
        List<Account> accounts = Account.list("customerId", customerId);
        return accountMapper.toDTOList(accounts);
    }
}
