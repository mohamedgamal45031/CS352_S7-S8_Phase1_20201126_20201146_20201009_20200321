package FawrySystem;

public class EtisalatInternet implements IServiceStrategy{

    private double price;

    public EtisalatInternet() {
        this.price = 100.0;
    }
    @Override
    public void ExecuteService() {
        System.out.println("EtisalatInternet cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
