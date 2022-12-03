package FawrySystem;

public class OrangeInternet implements IServiceStrategy{
    private double price;

    public OrangeInternet() {
        this.price = 100.0;
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
