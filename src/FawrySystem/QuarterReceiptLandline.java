package FawrySystem;

public class QuarterReceiptLandline implements IServiceStrategy{

    private double price;

    public QuarterReceiptLandline() {
        this.price = 100.0;
    }


    @Override
    public void ExecuteService() {
        System.out.println("QuarterReceiptLandline cost is "+getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }
}
