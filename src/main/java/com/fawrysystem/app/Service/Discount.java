package com.fawrysystem.app.Service;

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
        this.discountedservice.setPrice(discountedservice.getPrice()*discount/100);
        this.price = discountedservice.getPrice()*discount/100;
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
    public void ExecuteService() {
        System.out.println("the cost of the service after discount is : "+getPrice());
    }

    @Override
    public double getPrice() {
        return this.discountedservice.getPrice()-(this.discountedservice.getPrice()*this.discount);
    }
}
