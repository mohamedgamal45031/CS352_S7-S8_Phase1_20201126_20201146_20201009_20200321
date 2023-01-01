package com.fawrysystem.app.Provider;

import java.util.ArrayList;
import java.util.Scanner;

public class CreditCardProvider implements ServiceProvider {
    private String name  = "Credit Card";
    private ArrayList<Component> providerForm = new ArrayList<Component>();

    @Override
    public void handler() {
        showPaymentForm();
        System.out.println("Credit Card Paying.....");
    }
    @Override
    public void showPaymentForm() {
        for (int i = 0; i < providerForm.size(); i++) {
            System.out.println("Enter "+providerForm.get(i).label);
        }
    }

    @Override
    public String getName(){
        return name;
    }
}
