package FawrySystem;

public class Discount implements IServiceStrategy{
    private double discount;
    private IServiceStrategy discountedservice;

    public Discount(double discount,IServiceStrategy discountedservice) {
        this.discount=discount;
        this.discountedservice=discountedservice;

    }

    @Override
    public void ExecuteService() {
        System.out.println("the cost of the service after discount is : "+getPrice());
    }

    @Override
    public double getPrice() {


        return this.discountedservice.getPrice()-(this.discountedservice.getPrice()*this.discount);
    }

    @Override
    public String getName() {
        return null;
    }
}
