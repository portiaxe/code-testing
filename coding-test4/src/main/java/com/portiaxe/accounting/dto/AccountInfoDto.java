package com.portiaxe.accounting.dto;

import java.math.BigDecimal;

public class AccountInfoDto {
    private String name;
    private String accountNumber;
    private BigDecimal accountBalance;
    private BigDecimal maxDeposit;
    private BigDecimal maxWithdraw;
    private BigDecimal maxTransfer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getMaxDeposit() {
        return maxDeposit;
    }

    public void setMaxDeposit(BigDecimal maxDeposit) {
        this.maxDeposit = maxDeposit;
    }

    public BigDecimal getMaxWithdraw() {
        return maxWithdraw;
    }

    public void setMaxWithdraw(BigDecimal maxWithdraw) {
        this.maxWithdraw = maxWithdraw;
    }

    public BigDecimal getMaxTransfer() {
        return maxTransfer;
    }

    public void setMaxTransfer(BigDecimal maxTransfer) {
        this.maxTransfer = maxTransfer;
    }
}
