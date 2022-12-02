package FawrySystem;

public class WERechrage implements IServiceStrategy{

    private double price;

    public WERechrage() {
        this.price = 100.0;
    }




    @Override
    public void ExecuteService() {
        System.out.println("WERechrage cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
