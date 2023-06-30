package com.portiaxe.accounting.dao.repo;

import com.portiaxe.accounting.dao.entity.AccountDeposit;
import com.portiaxe.accounting.dao.entity.AccountWithdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WithdrawalRepository extends JpaRepository<AccountWithdrawal, Long> {
    List<AccountDeposit> findByAccountNumber(String accountNumber);
}
