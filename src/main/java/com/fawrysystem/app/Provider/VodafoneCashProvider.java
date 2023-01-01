package com.fawrysystem.app.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class VodafoneCashProvider implements ServiceProvider {
    private String name  = "VodafoneCash";
    private ArrayList<Component> providerForm = new ArrayList<Component>();
    @Override
    public void handler() {
        showPaymentForm();
        System.out.println("Vodafone Cash Paying.....");
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
