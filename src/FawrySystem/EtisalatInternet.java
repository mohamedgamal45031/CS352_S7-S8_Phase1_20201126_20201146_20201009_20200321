package FawrySystem;

public class EtisalatInternet implements IServiceStrategy{

    private double price;
    private String name = "EtisalatInternet";
    public String getName() {
        return name;
    }
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
