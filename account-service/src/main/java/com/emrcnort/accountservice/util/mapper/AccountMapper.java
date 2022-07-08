package com.emrcnort.accountservice.util.mapper;

import com.emrcnort.accountservice.dto.AccountDto;
import com.emrcnort.accountservice.entity.Account;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto convertAccountToAccountDto(Account account);

    List<AccountDto> convertListOfAccountToListOfAccountDto(List<Account> accountList);

    Account convertAccountDtoToAccount(AccountDto accountDto);

}
