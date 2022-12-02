package FawrySystem;

public class VodafoneRechrage implements IServiceStrategy{

    private double price;

    public VodafoneRechrage() {
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
