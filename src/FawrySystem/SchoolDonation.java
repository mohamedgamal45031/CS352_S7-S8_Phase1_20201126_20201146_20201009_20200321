package FawrySystem;

public class SchoolDonation implements IServiceStrategy{

    private double price;

    public SchoolDonation() {
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
