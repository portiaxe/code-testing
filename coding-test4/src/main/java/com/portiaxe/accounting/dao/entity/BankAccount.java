package com.portiaxe.accounting.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    private String accountNumber;

    @Column
    private BigDecimal accountBalance;

    @Column
    private BigDecimal maxDeposit;

    @Column
    private BigDecimal maxWithdrawal;

    @Column
    private BigDecimal maxTransfer;

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

    public BigDecimal getMaxWithdrawal() {
        return maxWithdrawal;
    }

    public void setMaxWithdrawal(BigDecimal maxWithdrawal) {
        this.maxWithdrawal = maxWithdrawal;
    }

    public BigDecimal getMaxTransfer() {
        return maxTransfer;
    }

    public void setMaxTransfer(BigDecimal maxTransfer) {
        this.maxTransfer = maxTransfer;
    }
}
