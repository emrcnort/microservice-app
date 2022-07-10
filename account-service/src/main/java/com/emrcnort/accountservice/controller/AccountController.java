package com.emrcnort.accountservice.controller;

import com.emrcnort.accountservice.dto.AccountDto;
import com.emrcnort.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable String id){
       return ResponseEntity.ok(accountService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAll(){
        return ResponseEntity.ok(accountService.findAll());
    }


    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> update(@PathVariable String id, @RequestBody AccountDto account){
        return ResponseEntity.ok(accountService.update(id,account));
    }

    @DeleteMapping
    public void delete(String id){
        accountService.delete(id);
    }

}
