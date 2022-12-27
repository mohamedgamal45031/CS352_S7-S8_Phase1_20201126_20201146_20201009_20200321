package com.fawrysystem.app.User;


import com.fawrysystem.app.Service.IServiceStrategy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private String userName;
    private String email;
    private String password;
    private String creditCardNumber;
    private double walletBalance = 0.0;
    private double overallDiscount = 0.0;
    private IServiceStrategy service;
    private List<Transaction> transactions = new ArrayList<Transaction>();
    public UserModel() {
    }

    public UserModel(String userName, String email, String password, List<Transaction> transactions) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.transactions = transactions;
    }

    public UserModel(String userName, String email, String password, String creditCardNumber, double walletBalance, double overallDiscount) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.creditCardNumber = creditCardNumber;
        this.walletBalance = walletBalance;
        this.overallDiscount = overallDiscount;
    }

    public UserModel(String userName, String email, String password) {
        overallDiscount = 0;

        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public UserModel(String email, String password) {
        overallDiscount = 0;
        this.email = email;
        this.password = password;
    }

    public double getOverallDiscount() {
        return overallDiscount;

    }

    public void setWalletBalance(double x) {
        this.walletBalance = x;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setOverallDiscount(double overallDiscount) {
        this.overallDiscount = overallDiscount;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    public Transaction getTransaction( int ind) {
        return transactions.get(ind);
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransactions( Transaction tr) {
        this.transactions.add(tr);
    }
    public IServiceStrategy getService(){
        return service;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
