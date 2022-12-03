package FawrySystem;

public class OrangeInternet implements IServiceStrategy{
    private String name = "OrangeInternet";

    private double price;

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
