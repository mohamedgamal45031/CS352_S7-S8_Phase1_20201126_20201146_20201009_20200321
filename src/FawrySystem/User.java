package FawrySystem;

public class User {
    /*
    * - s: IServiceStrategy
- userName: string
- email: string
- password: string
- creditCardNumber:string
- walletBalance:double
* */
    private IServiceStrategy s;
    private String email;
    private String password;
    private String creditCardNumber;
    private double walletBalance;
    private double overAllDicount;


    public User() {
        overAllDicount=0;
    }

    public void PayForService(){

    s=new Discount(overAllDicount,s);
s.ExecuteService();

}
    public void setService(String s){
    Search search = Search.getInstance();
    this.s=search.getService(s);

    }
    public void setOverAllDicount(double overAllDicount){
    this.overAllDicount=overAllDicount;

    }



}
