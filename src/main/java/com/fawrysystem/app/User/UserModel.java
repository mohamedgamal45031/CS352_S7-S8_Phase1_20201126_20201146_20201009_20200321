package com.fawrysystem.app.User;


import com.fawrysystem.app.Service.IServiceStrategy;

import java.util.*;

public class UserModel {
    private long id;
    private String userName;
    private String email;
    private String password;
    private String creditCardNumber;
    private double walletBalance = 0.0;
    private double overallDiscount = 0.0;
    private IServiceStrategy service;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Transaction getTransaction(int ind) {
        return transactions.get(ind);
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransactions( Transaction tr) {
        this.transactions.add(tr);
    }
    public UserModel() {
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

    public UserModel(long id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setOverallDiscount(double overallDiscount) {
        this.overallDiscount = overallDiscount;
    }

    public IServiceStrategy getService() {
        return service;
    }

    public void setService(IServiceStrategy service) {
        this.service = service;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

}
