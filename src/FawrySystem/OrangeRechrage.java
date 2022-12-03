package FawrySystem;

public class OrangeRechrage implements IServiceStrategy{


    private double price;

    public OrangeRechrage() {
        this.price = 100.0;
    }


    @Override
    public void ExecuteService() {
        System.out.println("OrangeRechrage cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
