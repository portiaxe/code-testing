package com.portiaxe.accounting.controller;

import com.portiaxe.accounting.dao.entity.TransactionView;
import com.portiaxe.accounting.dto.AccountInfoDto;
import com.portiaxe.accounting.dto.param.DepositParam;
import com.portiaxe.accounting.dto.param.TransferParam;
import com.portiaxe.accounting.dto.param.WithdrawParam;
import com.portiaxe.accounting.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountingController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/user-accounts")
    public ResponseEntity<List<AccountInfoDto>> getUserAccount(){
        return ResponseEntity.ok(accountService.getAccountInfoList());
    }

    @GetMapping("/history")
    public ResponseEntity<List<TransactionView>> getTransactionHistory(@RequestParam("accountNumber") String accountNumber){
        return ResponseEntity.ok(accountService.getTransactionHistory(accountNumber));
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody DepositParam depositParam){
        return ResponseEntity.ok(accountService.deposit(depositParam));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody WithdrawParam withdrawParam){
        return ResponseEntity.ok(accountService.withdraw(withdrawParam));
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransferParam transferParam){
        return ResponseEntity.ok(accountService.transfer(transferParam));
    }
}
