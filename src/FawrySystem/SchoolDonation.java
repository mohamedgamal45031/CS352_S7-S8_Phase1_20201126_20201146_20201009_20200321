package FawrySystem;

public class SchoolDonation implements IServiceStrategy{
    private String name = "SchoolDonation";

    private double price;

    public SchoolDonation() {
        this.price = 100.0;
    }


    @Override
    public void ExecuteService() {
        System.out.println("SchoolDonation cost is "+getPrice());
    }
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        return price;
    }
}
