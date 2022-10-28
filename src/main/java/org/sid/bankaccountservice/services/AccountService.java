package org.sid.bankaccountservice.services;

import org.sid.bankaccountservice.dto.BankAccountRequestDto;
import org.sid.bankaccountservice.dto.BankAccountResponseDto;
import org.sid.bankaccountservice.entities.BankAccount;

public interface AccountService {
     BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto);
}
