package com.fawrysystem.app.Service;

public interface IServiceStrategy {
    public void ExecuteService();
    public  double getPrice();
    public String getName();
    public void setPrice(double x) ;

    public void setAcceptCash(boolean acceptCash);

    public boolean isAcceptCash() ;
}
