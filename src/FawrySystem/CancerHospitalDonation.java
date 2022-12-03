package FawrySystem;

public class CancerHospitalDonation implements IServiceStrategy{
    private double price;

    public CancerHospitalDonation() {
        this.price = 100.0;
    }

    @Override
    public void ExecuteService() {
        System.out.println("CancerHospitalDonation cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
