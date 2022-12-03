package FawrySystem;

public class SchoolDonation implements IServiceStrategy{

    private double price;

    public SchoolDonation() {
        this.price = 100.0;
    }


    @Override
    public void ExecuteService() {
        System.out.println("SchoolDonation cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
