package com.portiaxe.accounting.dao.repo;

import com.portiaxe.accounting.dao.entity.AccountDeposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositRepository extends JpaRepository<AccountDeposit, Long> {
    List<AccountDeposit> findByAccountNumber(String accountNumber);
}
