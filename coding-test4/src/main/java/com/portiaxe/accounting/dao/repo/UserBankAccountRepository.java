package com.portiaxe.accounting.dao.repo;

import com.portiaxe.accounting.dao.entity.UserBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBankAccountRepository extends JpaRepository<UserBankAccount, Long> {
}
