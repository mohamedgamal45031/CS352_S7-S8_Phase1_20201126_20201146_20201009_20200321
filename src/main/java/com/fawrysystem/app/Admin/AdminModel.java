package com.fawrysystem.app.Admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminModel {
    private String email;
    private String password;
    private ArrayList<Refund> refunds = new ArrayList<Refund>();

    public AdminModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void addRefund(Refund r) {
        refunds.add(r);
    }

    @Override
    public String toString() {
        return "AdminModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", refunds=" + refunds +
                '}';
    }
}
