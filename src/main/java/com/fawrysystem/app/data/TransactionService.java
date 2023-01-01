package com.fawrysystem.app.data;


import com.fawrysystem.app.User.Transaction;

import java.util.List;

public class TransactionService {
    private final static TransactionService instance = new TransactionService();
    private final TransactionDatabase database = TransactionDatabase.getInstance();

    public List<TransactionModel> getAllTransactions(){
        return database.getAllTransactions();
    }

    public void addTransaction(TransactionModel transaction){
        database.addTransaction(transaction);
    }

    public static TransactionService getInstance() {
        return instance;
    }
}
