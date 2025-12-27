package org.acme.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.AccountDTO;
import org.acme.entity.Account;

import java.util.List;

@ApplicationScoped
public class AccountMapper {

    public AccountDTO toDTO(Account account) {
        if (account == null) return null;
        AccountDTO dto = new AccountDTO();
        dto.setAccountNumber(account.accountNumber);
        dto.setBalance(account.balance);
        dto.setCustomerId(account.customerId);
        dto.setStatus(account.status);
        dto.setType(account.type);
        return dto;
    }

    public List<AccountDTO> toDTOList(List<Account> accounts) {
        return accounts.stream()
                .map(this::toDTO)
                .toList();
    }
}
