package FawrySystem;

public class MonthlyReceiptLandline implements IServiceStrategy{
    private double price;
    private boolean acceptCash = false;


    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }
    private String name = "MonthlyReceiptLandline";
    public String getName() {
        return name;
    }

    public MonthlyReceiptLandline() {
        this.price = 100.0;
    }

    @Override
    public void ExecuteService() {
        System.out.println("MonthlyReceiptLandline cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
