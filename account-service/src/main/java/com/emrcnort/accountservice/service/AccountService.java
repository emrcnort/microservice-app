package com.emrcnort.accountservice.service;

import com.emrcnort.accountservice.dto.AccountDto;
import com.emrcnort.accountservice.entity.Account;
import com.emrcnort.accountservice.repository.AccountRepository;
import com.emrcnort.accountservice.util.mapper.AccountMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;

    public AccountDto get(String id){
        return mapper.convertAccountToAccountDto(repository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Transactional
    public AccountDto save(AccountDto accountDto){
        Account account = mapper.convertAccountDtoToAccount(accountDto);
        account = repository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Transactional
    public AccountDto update(@NonNull String id, AccountDto accountDto){
        Optional<Account> account = repository.findById(id);
        Account accountToUpdate = account.map(e-> {
            e.setBirthDate(accountDto.getBirthDate());
            e.setName(accountDto.getName());
            e.setSurname(accountDto.getSurname());
            return e;
        }).orElseThrow(IllegalArgumentException::new);
        return mapper.convertAccountToAccountDto(repository.save(accountToUpdate));
    }

    @Transactional
    public void delete(String id){
        Account account = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        repository.delete(account);
    }

    public List<AccountDto> findAll() {
        return  mapper.convertListOfAccountToListOfAccountDto(repository.findAll());
    }
}
