package com.portiaxe.accounting.dao.repo;

import com.portiaxe.accounting.dao.entity.AccountDeposit;
import com.portiaxe.accounting.dao.entity.AccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository extends JpaRepository<AccountTransfer, Long> {
    List<AccountDeposit> findByAccountNumber(String accountNumber);
}
