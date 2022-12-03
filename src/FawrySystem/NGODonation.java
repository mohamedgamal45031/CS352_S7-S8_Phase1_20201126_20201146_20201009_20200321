package FawrySystem;

public class NGODonation implements IServiceStrategy{
    private double price;

    public NGODonation() {
        this.price = 100.0;
    }

    @Override
    public void ExecuteService() {
        System.out.println("NGODonation cost is "+getPrice());

    }

    @Override
    public double getPrice() {
        return price;
    }
}
