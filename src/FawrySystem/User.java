package FawrySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class User {

    private IServiceStrategy service;
    private String userName;
    private String email;
    private String password;
    private String creditCardNumber;
    private double walletBalance = 0.0;
    private double overAllDicount;

    private List<Transaction> transactions =new ArrayList<Transaction>();

    public User() {
        overAllDicount = 0;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public Transaction getTransaction(int ind) {
        return transactions.get(ind);
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void addTransactions(Transaction tr) {
        this.transactions.add(tr);
    }
    public void PayForService() {
        service.ExecuteService();
    }
    public void setWalletBalance(double x){
        this.walletBalance= x;
    }
    public double getWalletBalance(){
        return walletBalance;
    }
    public void setService(String ss) {
        Search search = Search.getInstance();
        Map<Integer,IServiceStrategy> map = search.getService(ss);

        for (Map.Entry<Integer, IServiceStrategy> set :
                map.entrySet()) {
            System.out.print(set.getKey()+" - ");
            System.out.println(set.getValue().getName());
        }
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Num of Service to Select");
        int serviceNum = myObj.nextInt();
        service = map.get(serviceNum);
        ///////////////////////////


    }
    public IServiceStrategy getService(){
        return service;
    }
    public void setOverAllDicount(double overAllDicount) {
        this.overAllDicount = overAllDicount;

    }
    public String getEmail() {
        return email;
    }
    public List<Transaction> getRefundableRequests(){
        List<Transaction>list = new ArrayList<>();
        for (Transaction t :transactions){
            if(!t.isRefundRequested()){
                list.add(t);
            }
        }
        return list;
    }
    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
