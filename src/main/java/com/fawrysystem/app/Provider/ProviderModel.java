package com.fawrysystem.app.Provider;

import com.fawrysystem.app.User.UserModel;
import com.fawrysystem.app.User.UserServices;
import com.fawrysystem.app.data.TransactionDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ProviderModel implements IServiceProvider {
    private String providerName;
    private static int orderNumber = 1000;
    private List<Component> providerForm = List.of();
    private TransactionDatabase database = TransactionDatabase.getInstance();

    private UserModel user;
    private UserServices service = UserServices.getInstance();

    public ProviderModel(String providerName) {
        this.providerName = providerName;
    }

    public ProviderModel(String providerName, Component... providerForm) {
        this.providerName = providerName;
    }
    @Override
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public List<Component> getProviderForm() {
        return providerForm;
    }

    @Override
    public void handler(UserModel user, double price) {
        this.user = user;

        showPaymentForm(price);

        if (service.payService(user, this, price)) System.out.println(providerName + " Paying.....");
        else System.out.println("Failed to pay using " + providerName);
    }

    @Override
    public void showPaymentForm(double price) {
        System.out.println("### ------------- " + providerName + " Provider Form ------------- ###");
        List<ValuedComponent> values = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (Component component: providerForm) {
            if (component.getType() == ProviderService.TEXT_FIELD_CODE) {
                if (Objects.equals(component.getLabel(), "Amount")) {
                    values.add(new ValuedComponent(component.type, component.label, String.valueOf(price)));
                }else{
                    System.out.println("Enter your " + component.getLabel() + ": ");
                    values.add(new ValuedComponent(component.type, component.label, sc.nextLine()));
                }
            }
        }
        System.out.println("### --------------- --------------------------- --------------- ### ");
    }

    @Override
    public String toString() {
        return "ProviderModel{" +
                "providerName='" + providerName + '\'' +
                ", providerForm=" + providerForm +
                '}';
    }
}
