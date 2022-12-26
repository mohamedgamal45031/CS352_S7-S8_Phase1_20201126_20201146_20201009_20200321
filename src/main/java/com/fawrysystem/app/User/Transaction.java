package com.fawrysystem.app.User;

public class Transaction {
    private String transactionName;
    private double amount;
    private boolean refundRequested = false;
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
}
