package com.fawrysystem.app.User;

public class Transaction {
    private String transactionName;
    private double amount;
    private boolean refundRequested = false;
    private String transactionType;
    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public void setRefundRequested(boolean refundRequested) {
        this.refundRequested = refundRequested;
    }

    public boolean isRefundRequested() {
        return refundRequested;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public double getAmount() {
        return amount;
    }
    public Transaction() {
    }
    public Transaction(String transactionName, double amount) {
        this.transactionName = transactionName;
        this.amount = amount;
    }

    public Transaction(String transactionName, double amount, boolean refundRequested) {
        this.transactionName = transactionName;
        this.amount = amount;
        this.refundRequested = refundRequested;
    }

    public Transaction(String transactionName, double amount, boolean refundRequested, String transactionType) {
        this.transactionName = transactionName;
        this.amount = amount;
        this.refundRequested = refundRequested;
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
