package com.fawrysystem.app.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminModel {
    private String email;
    private String password;

    private List<Refund> refunds = List.of();
    public AdminModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void addRefund(Refund r) {
        refunds.add(r);
    }

    public List<Refund> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<Refund> refunds) {
        this.refunds = refunds;
    }
}
