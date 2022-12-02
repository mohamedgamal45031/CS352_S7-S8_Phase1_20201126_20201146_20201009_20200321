package FawrySystem;

public class EtisalatInternet implements IServiceStrategy{

    private double price;

    public EtisalatInternet() {
        this.price = 100.0;
    }
    @Override
    public void ExecuteService() {

    }

    @Override
    public double getPrice() {
        return price;
    }
}
