package FawrySystem;

public class OrangeInternet implements IServiceStrategy{
    private String name = "OrangeInternet";

    private double price;
    private boolean acceptCash = false;


    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }
    public OrangeInternet() {
        this.price = 100.0;
    }
    public String getName() {
        return name;
    }
    @Override
    public void ExecuteService() {
        System.out.println("OrangeInternet cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
