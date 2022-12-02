package FawrySystem;

public class QuarterReceiptLandline implements IServiceStrategy{

    private double price;

    public QuarterReceiptLandline() {
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
