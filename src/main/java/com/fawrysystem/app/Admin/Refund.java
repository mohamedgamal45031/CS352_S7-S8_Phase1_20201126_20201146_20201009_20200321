package com.fawrysystem.app.Admin;

import com.fawrysystem.app.*;
import com.fawrysystem.app.User.UserModel;

public class Refund {
    private String description;
    private double amount;
    private boolean isRefunded = false;

    private UserModel user;

    public boolean isRefunded() {
        return isRefunded;
    }

    public void setRefunded(boolean refunded) {
        isRefunded = refunded;
    }

    public Refund(String description, double amount,UserModel user) {
        this.description = description;
        this.amount = amount;
        this.user  = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public UserModel getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }
}
