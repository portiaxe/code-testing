package com.portiaxe.accounting.dao.repo;

import com.portiaxe.accounting.dao.entity.TransactionView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionHistoryRepository extends JpaRepository<TransactionView, String> {
    List<TransactionView> findByAccountNumberOrderByTransactionDateDesc(String accountNumber);
}
