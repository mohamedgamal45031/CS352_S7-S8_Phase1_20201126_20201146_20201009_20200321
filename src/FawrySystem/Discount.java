package FawrySystem;

public class Discount implements IServiceStrategy{
    private double discount;
    private IServiceStrategy discountedservice;
    private String name;
    private boolean acceptCash = false;
    public void setAcceptCash(boolean acceptCash) {
        this.acceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
        return acceptCash;
    }
    public Discount(double discount,IServiceStrategy discountedservice) {
        this.discount=discount;
        this.discountedservice=discountedservice;
        this.name= discountedservice.getName();
        this.acceptCash = discountedservice.isAcceptCash();
    }
    public String getName(){
        return name;
    }

    @Override
    public void ExecuteService() {
        System.out.println("the cost of the service after discount is : "+getPrice());
    }

    @Override
    public double getPrice() {
        return this.discountedservice.getPrice()-(this.discountedservice.getPrice()*this.discount);
    }
}
