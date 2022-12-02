package FawrySystem;

public class MonthlyReceiptLandline implements IServiceStrategy{
    private double price;

    public MonthlyReceiptLandline() {
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
