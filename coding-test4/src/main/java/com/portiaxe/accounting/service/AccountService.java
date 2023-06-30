package com.portiaxe.accounting.service;

import com.portiaxe.accounting.dao.entity.*;
import com.portiaxe.accounting.dao.repo.*;
import com.portiaxe.accounting.dto.AccountInfoDto;
import com.portiaxe.accounting.dto.TransactionHistoryDto;
import com.portiaxe.accounting.dto.param.DepositParam;
import com.portiaxe.accounting.dto.param.TransferParam;
import com.portiaxe.accounting.dto.param.WithdrawParam;
import com.portiaxe.accounting.exception.AccountNotFoundException;
import com.portiaxe.accounting.exception.InvalidTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    private UserBankAccountRepository userBankAccountRepository;

    public List<AccountInfoDto> getAccountInfoList(){

       return userBankAccountRepository.findAll()
                .stream()
                .map(userBankAccount -> {
                    BankAccount bankAccount= userBankAccount.getBankAccount();
                    AccountInfoDto accountInfoDto = new AccountInfoDto();
                    accountInfoDto.setName(userBankAccount.getAccountUser().getUsername());
                    accountInfoDto.setAccountNumber(bankAccount.getAccountNumber());
                    accountInfoDto.setAccountBalance(bankAccount.getAccountBalance());
                    accountInfoDto.setMaxDeposit(bankAccount.getMaxDeposit());
                    accountInfoDto.setMaxTransfer(bankAccount.getMaxTransfer());
                    accountInfoDto.setMaxWithdraw(bankAccount.getMaxWithdrawal());

                    return accountInfoDto;
                }).collect(Collectors.toList());
    }

    public List<TransactionView> getTransactionHistory(String accountNumber){
        return transactionHistoryRepository.findByAccountNumberOrderByTransactionDateDesc(accountNumber);
    }

    @Transactional
    public AccountDeposit deposit(DepositParam depositParam){
        BankAccount bankAccount = accountRepository.findById(depositParam.getAccountNumber())
                .orElseThrow(()-> new AccountNotFoundException("Account not found"));

        if(depositParam.getAmount().compareTo(bankAccount.getMaxDeposit()) == 1){
            throw new InvalidTransactionException("Deposit is beyond max amount");
        }


        UUID uuid = UUID.randomUUID();
        String referenceNumber = uuid.toString();

        AccountDeposit accountDeposit = new AccountDeposit();
        accountDeposit.setAccountNumber(bankAccount.getAccountNumber());
        accountDeposit.setAmount(depositParam.getAmount());
        accountDeposit.setTransactionDate(new Date());
        accountDeposit.setReferenceNumber(referenceNumber);

        bankAccount.setAccountBalance(bankAccount.getAccountBalance().add(depositParam.getAmount()));

        accountRepository.save(bankAccount);

       return depositRepository.save(accountDeposit);
    }

    @Transactional
    public AccountTransfer transfer(TransferParam transferParam){
        BankAccount bankAccount = accountRepository.findById(transferParam.getAccountNumber())
                .orElseThrow(()-> new AccountNotFoundException("Account not found"));

        BankAccount destinationAccount = accountRepository.findById(transferParam.getDestinationAccount())
                .orElseThrow(()-> new AccountNotFoundException("Destination account not found"));

        if(transferParam.getAmount().compareTo(bankAccount.getAccountBalance()) == 1){
            throw new InvalidTransactionException("Insufficient funds");
        }

        if(transferParam.getAmount().compareTo(bankAccount.getMaxTransfer()) == 1){
            throw new InvalidTransactionException("Transfer is beyond max amount");
        }

        UUID uuid = UUID.randomUUID();
        String referenceNumber = uuid.toString();

        AccountTransfer accountTransfer = new AccountTransfer();
        accountTransfer.setAccountNumber(transferParam.getAccountNumber());
        accountTransfer.setAccountDestination(destinationAccount.getAccountNumber());
        accountTransfer.setReferenceNumber(referenceNumber);
        accountTransfer.setTransactionDate(new Date());
        accountTransfer.setAmount(transferParam.getAmount());

        bankAccount.setAccountBalance(bankAccount.getAccountBalance().subtract(transferParam.getAmount()));
        destinationAccount.setAccountBalance(destinationAccount.getAccountBalance().add(transferParam.getAmount()));

        accountRepository.save(destinationAccount);
        accountRepository.save(bankAccount);

        return transferRepository.save(accountTransfer);
    }

    @Transactional
    public AccountWithdrawal withdraw(WithdrawParam withdrawParam){
        BankAccount bankAccount = accountRepository.findById(withdrawParam.getAccountNumber())
                .orElseThrow(()-> new AccountNotFoundException("Account not found"));

        if(withdrawParam.getAmount().compareTo(bankAccount.getAccountBalance()) == 1){
            throw new InvalidTransactionException("Insufficient funds");
        }

        if(withdrawParam.getAmount().compareTo(bankAccount.getMaxTransfer()) == 1){
            throw new InvalidTransactionException("Withdrawal is beyond max amount");
        }

        UUID uuid = UUID.randomUUID();
        String referenceNumber = uuid.toString();

        AccountWithdrawal accountWithdrawal = new AccountWithdrawal();
        accountWithdrawal.setAccountNumber(bankAccount.getAccountNumber());
        accountWithdrawal.setAmount(withdrawParam.getAmount());
        accountWithdrawal.setTransactionDate(new Date());
        accountWithdrawal.setReferenceNumber(referenceNumber);

        bankAccount.setAccountBalance(bankAccount.getAccountBalance().subtract(accountWithdrawal.getAmount()));
        accountRepository.save(bankAccount);

        return withdrawalRepository.save(accountWithdrawal);
    }
}
