package FawrySystem;

public class EtisalatRechrage implements IServiceStrategy{

    private double price;
    private String name = "EtisalatRechrage";

    public String getName() {
        return name;
    }
    public EtisalatRechrage() {
        this.price = 100.0;
    }

    @Override
    public void ExecuteService() {
        System.out.println("EtisalatRechrage cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
