package org.sid.bankaccountservice.services;

import org.sid.bankaccountservice.dto.BankAccountRequestDto;
import org.sid.bankaccountservice.dto.BankAccountResponseDto;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.enums.AccountType;
import org.sid.bankaccountservice.mappers.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountDto.getType())
                .balance(bankAccountDto.getBalance())
                .createdAt(new Date())
                .currency(bankAccountDto.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDto bankAccountResponseDto = accountMapper.fromBankAccount(savedBankAccount);



        return bankAccountResponseDto;
    }
}
