package org.sid.bankaccountservice.mappers;


import org.sid.bankaccountservice.dto.BankAccountResponseDto;
import org.sid.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public BankAccountResponseDto fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDto bankAccountResponseDto = new BankAccountResponseDto();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDto);
        return bankAccountResponseDto;


    }

}
