package com.fawrysystem.app.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private String transactionName;
    private double amount;
    private boolean refundRequested = false;
    private String transactionType;

    public Transaction(String transactionName, double amount) {
        this.transactionName = transactionName;
        this.amount = amount;
    }

    public Transaction(String transactionName, double amount, boolean refundRequested) {
        this.transactionName = transactionName;
        this.amount = amount;
        this.refundRequested = refundRequested;
    }


}
