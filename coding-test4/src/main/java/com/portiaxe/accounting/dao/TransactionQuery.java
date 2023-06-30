package com.portiaxe.accounting.dao;

public class TransactionQuery {

    public static final String TRANSACTION_HISTORY_QUERY =
            "SELECT trans_view.* FROM (" +
            "     SELECT account_number, 'DEPOSIT' as transaction_type, amount, reference_number, transaction_date " +
            "       FROM acc_deposit" +
            "  UNION ALL " +
            "     SELECT account_number, 'WITHDRAWAL' as transaction_type, amount, reference_number, transaction_date " +
            "       FROM acc_withdraw " +
            "  UNION ALL " +
            "     SELECT account_number, 'TRANSFER' as transaction_type, amount, reference_number, transaction_date" +
            "       FROM acc_transfer) as trans_view";


}
