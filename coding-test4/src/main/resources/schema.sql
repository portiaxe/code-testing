
DROP TABLE IF EXISTS user_bank_acc;
DROP TABLE IF EXISTS acc_deposit;
DROP TABLE IF EXISTS acc_withdraw;
DROP TABLE IF EXISTS acc_transfer;
DROP TABLE IF EXISTS bank_account;
DROP TABLE IF EXISTS acc_user;

CREATE  TABLE acc_user (
   username varchar(255) PRIMARY KEY,
   password varchar(255) NOT NULL
 );
CREATE  TABLE bank_account (
  account_number varchar(50) PRIMARY KEY NOT NULL,
  account_balance DECIMAL(65,5) NOT NULL,
  max_deposit DECIMAL(65,5) NOT NULL,
  max_withdrawal DECIMAL(65,5) NOT NULL,
  max_transfer DECIMAL(65,5) NOT NULL
);

CREATE TABLE user_bank_acc(
  ub_id INT AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL UNIQUE,
  account_number VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY(ub_id)
);

INSERT INTO acc_user(username,password)
VALUES ('user','$2a$10$3f2Ze2/e.mS0tC/38QiUIOW2i8lccPS3OcWcqUpcRMb6JzVMwMg5W'), --admin01
       ('user2','$2a$10$3f2Ze2/e.mS0tC/38QiUIOW2i8lccPS3OcWcqUpcRMb6JzVMwMg5W'); --admin01

INSERT INTO bank_account(account_number, account_balance, max_deposit, max_withdrawal, max_transfer)
VALUES ("ABC001", 10000, 20000, 20000, 20000),
       ("ABC002", 10000, 20000, 20000, 20000);

INSERT INTO user_bank_acc(username, account_number)
VALUES ("user","ABC001"),("user2","ABC002");


