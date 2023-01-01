package com.fawrysystem.app.Service;

import com.fawrysystem.app.Provider.ServiceProvider;
import com.fawrysystem.app.User.UserModel;

public class Discount implements IServiceStrategy{
    private double price;
    private double discount;
    private IServiceStrategy discountedservice;
    private String name;
    private boolean acceptCash = false;
    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }
    public Discount(double discount, IServiceStrategy discountedservice) {
        this.discount=discount;
        this.discountedservice=discountedservice;
        //to modify the whole service price

//        this.discountedservice.setPrice(discountedservice.getPrice()-((discount/100)*discountedservice.getPrice()));
        this.price = discountedservice.getPrice()-((discount/100)*discountedservice.getPrice());

        this.name= discountedservice.getName();
        this.acceptCash = discountedservice.isAcceptCash();
    }
    public String getName(){
        return name;
    }

    public double getDiscount() {
        return discount;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public void ExecuteService(UserModel user, ServiceProvider provider) {
        user.setWalletBalance(user.getWalletBalance()-getPrice());

        System.out.println("the cost of the service after discount is : "+getPrice());
    }
    public void ExecuteService(ServiceProvider provider){
        System.out.println("the cost of the service after discount is : "+getPrice());
        provider.handler();

    }
    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "price=" + price +
                ", discount=" + discount +
                ", discountedservice=" + discountedservice +
                ", name='" + name + '\'' +
                ", acceptCash=" + acceptCash +
                '}';
    }
}
