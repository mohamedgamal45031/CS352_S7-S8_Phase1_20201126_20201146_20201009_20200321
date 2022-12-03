package FawrySystem;

public class VodafoneRechrage implements IServiceStrategy{

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
}
