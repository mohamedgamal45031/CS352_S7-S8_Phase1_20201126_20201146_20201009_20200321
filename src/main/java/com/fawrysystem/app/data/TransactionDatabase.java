package com.fawrysystem.app.data;

import com.fawrysystem.app.User.UserModel;

import java.util.ArrayList;
import java.util.List;

public class TransactionDatabase {
    private List<TransactionModel> transactions = new ArrayList<>();

    private static final TransactionDatabase instance = new TransactionDatabase();

    public TransactionDatabase() {
        transactions.add( new TransactionModel(
                new UserModel("Abdelaziz", "zoz.gmail.com", "132")
                , "Credit Card", "1001",
                100.0));
    }

    public List<TransactionModel> getAllTransactions(){
        return transactions;
    }

    public void addTransaction(TransactionModel transaction){
        System.out.println("added");
        transactions.add(transaction);
    }

    public static TransactionDatabase getInstance() {
        return instance;
    }
}
