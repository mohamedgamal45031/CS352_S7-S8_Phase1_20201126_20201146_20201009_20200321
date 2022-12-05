package FawrySystem;

public class VodafoneRechrage implements IServiceStrategy {
    private String name = "VodafoneRechrage";
    private boolean acceptCash = false;


    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }
    private double price;

    public VodafoneRechrage() {
        this.price = 100.0;
    }

    @Override
    public void ExecuteService() {
        System.out.println("Vodafone Rechrage cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
