package FawrySystem;

public interface IServiceStrategy {
   public void ExecuteService();
   public  double getPrice();
   public String getName();


   public void setAcceptCash(boolean acceptCash);

   public boolean isAcceptCash() ;
}
