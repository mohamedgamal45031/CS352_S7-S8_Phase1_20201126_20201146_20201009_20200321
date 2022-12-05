package FawrySystem;

public class VodafoneInternet implements IServiceStrategy {
    private String name = "VodafoneInternet";

    private double price = 100.0;
    private boolean acceptCash = false;


    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }
    public VodafoneInternet() {

    }

    @Override
    public void ExecuteService() {
        System.out.println("Vodafone Internet cost is " + getPrice());

    }

    @Override
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
