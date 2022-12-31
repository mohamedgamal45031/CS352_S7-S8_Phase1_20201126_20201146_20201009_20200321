package com.fawrysystem.app.Admin;

import java.util.ArrayList;
public class AdminModel {
    private String email;
    private String password;
    private ArrayList<Refund> refunds = new ArrayList<Refund>();

    public AdminModel() {
    }

    public AdminModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AdminModel(String email, String password, ArrayList<Refund> refunds) {
        this.email = email;
        this.password = password;
        this.refunds = refunds;
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

    public ArrayList<Refund> getRefunds() {
        return refunds;
    }

    public void setRefunds(ArrayList<Refund> refunds) {
        this.refunds = refunds;
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
