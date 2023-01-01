package com.fawrysystem.app.Admin;

import com.fawrysystem.app.*;
import com.fawrysystem.app.User.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Refund {
    private String description;
    private double amount;
    private boolean isRefunded = false;
    private boolean isAccepted;
    private UserModel user;
    public Refund(String description, double amount,UserModel user) {
        this.description = description;
        this.amount = amount;
        this.user  = user;
    }
    @Override
    public String toString() {
        return "Refund{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", isRefunded=" + isRefunded +
                ", isAccepted=" + isAccepted +
                ", user=" + user +
                '}';
    }


}
