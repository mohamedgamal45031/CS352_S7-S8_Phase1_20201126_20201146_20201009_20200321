package FawrySystem;

public class WEInternet implements IServiceStrategy{

    private double price;

    public WEInternet() {
        this.price = 100.0;
    }




    @Override
    public void ExecuteService() {
        System.out.println("WEInternet cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
