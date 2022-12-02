package FawrySystem;

public class VodafoneInternet implements IServiceStrategy{

    private double price;

    public VodafoneInternet() {
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
