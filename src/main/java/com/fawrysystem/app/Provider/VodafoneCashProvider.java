package com.fawrysystem.app.Provider;

import java.util.Scanner;

public class VodafoneCashProvider implements ServiceProvider {

    private String name  = "Vodafone Cash";

    @Override
    public void handler() {
        showPaymentForm();
        System.out.println("Vodafone Cash Paying.....");
    }

    @Override
    public void showPaymentForm() {
        System.out.println("### --------------- Vodafone Cash Provider form --------------- ### ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int Num=sc.nextInt();
        System.out.println("Enter Amount: ");
        float amount=sc.nextInt();
        System.out.println("### --------------- --------------------------- --------------- ### ");

    }
    @Override
    public String getName(){
        return name;
    }
}
