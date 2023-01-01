package com.fawrysystem.app.User;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String userName;
    private String email;
    private String password;
    private String creditCardNumber;
    private double walletBalance = 0.0;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    public void addTransactions(Transaction tr) {
        transactions.add(tr);
    }
    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }
    public UserModel(String userName, String email, String password, ArrayList<Transaction> transactions) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.transactions = transactions;
    }

    public UserModel(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", transactions=" + transactions +
                '}';
    }

}
