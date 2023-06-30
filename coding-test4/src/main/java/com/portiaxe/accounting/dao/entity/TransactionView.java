package com.portiaxe.accounting.dao.entity;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

import static com.portiaxe.accounting.dao.TransactionQuery.TRANSACTION_HISTORY_QUERY;

@Entity
@Immutable
@Subselect(TRANSACTION_HISTORY_QUERY)
public class TransactionView {

    @Id
    private String referenceNumber;

    @Column
    private String accountNumber;

    @Column
    private String transactionType;

    @Column
    private BigDecimal amount;

    @Column
    private Date transactionDate;

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
