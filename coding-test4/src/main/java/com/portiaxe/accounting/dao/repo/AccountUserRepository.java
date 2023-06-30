package com.portiaxe.accounting.dao.repo;

import com.portiaxe.accounting.dao.entity.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {
    AccountUser findByUsername(String username);
}
