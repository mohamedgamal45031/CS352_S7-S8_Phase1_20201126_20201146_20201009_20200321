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

public void PayForService(){}
    public void setService(String s){
    Search search = Search.getInstance();
    this.s=search.getService(s);

    }

}
