package com.portiaxe.accounting.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "acc_user")
public class AccountUser {

    @Id
    private String username;

    @Column
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
