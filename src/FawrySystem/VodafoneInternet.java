package FawrySystem;

public class VodafoneInternet implements IServiceStrategy {
    private String name = "VodafoneInternet";

    private double price = 100.0;

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
