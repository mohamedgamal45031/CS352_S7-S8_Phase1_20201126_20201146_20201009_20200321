package com.fawrysystem.app.User;


import com.fawrysystem.app.Service.IServiceStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

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
    public void addTransactions( Transaction tr) {
        this.transactions.add(tr);
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
                '}';
    }
}
