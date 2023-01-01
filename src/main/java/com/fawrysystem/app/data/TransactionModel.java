package com.fawrysystem.app.data;

import com.fawrysystem.app.User.UserModel;
public class TransactionModel {
    private String userName;
    private String email;
    private String password;
    private String providerName;
    private String transactionName;
    private double amount;
    private boolean refundRequested = false;

    public TransactionModel(UserModel user, String providerName, String transactionName, double amount) {
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.providerName = providerName;
        this.transactionName = transactionName;
        this.amount = amount;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isRefundRequested() {
        return refundRequested;
    }

    public void setRefundRequested(boolean refundRequested) {
        this.refundRequested = refundRequested;
    }
}
