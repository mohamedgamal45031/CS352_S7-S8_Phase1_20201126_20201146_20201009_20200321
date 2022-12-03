package FawrySystem;

public class OrangeRechrage implements IServiceStrategy{

    private String name = "OrangeRechrage";

    private double price;

    public OrangeRechrage() {
        this.price = 100.0;
    }


    @Override
    public void ExecuteService() {
        System.out.println("OrangeRechrage cost is "+getPrice());
    }
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        return price;
    }
}
