package com.portiaxe.accounting.dao.repo;

import com.portiaxe.accounting.dao.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<BankAccount, String> {
}
