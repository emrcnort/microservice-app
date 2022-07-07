package com.emrcnort.accountservice.service;

import com.emrcnort.accountservice.entity.Account;
import com.emrcnort.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public Account get(String id){
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Account save(Account account){
        return repository.save(account);
    }

    public Account update(String id, Account account){
        Assert.isNull(id, "Id cannot be null");
        return repository.save(account);
    }

    public void delete(String id){
    }

    public List<Account> findAll() {
        return repository.findAll();
    }
}
