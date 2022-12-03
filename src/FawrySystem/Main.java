package FawrySystem;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<User> users  = new ArrayList<User>();
        Admin gemy=new Admin();
        Scanner sc = new Scanner(System.in);
        boolean signedIn = false;
        User currentUser = new User();
        List<ServiceProvider>serviceProviders = new ArrayList<>();
        ServiceProvider vodafone = new VodafoneCashProvider();
        ServiceProvider creditCard = new CreditCardProvider();
        serviceProviders.add(vodafone);
        serviceProviders.add(creditCard);
        List<IServiceProviderFactory>serviceProviderFactories = new ArrayList<>();
        IServiceProviderFactory vodafoneFactory = new VodafoneCashFactory();
        IServiceProviderFactory creditCardFactory = new CreditCardFactory();
        serviceProviderFactories.add(vodafoneFactory);
        serviceProviderFactories.add(creditCardFactory);
        while(true){
            if(signedIn){
                System.out.println("1- Log Out");
                System.out.println("2- Search");
                int option = sc.nextInt();
                if(option ==1 ){
                    currentUser = null;
                    signedIn = false;
                }if(option ==2 ){
                    System.out.println("Search For The Service You Want!");
                    Scanner newScanner = new Scanner(System.in);

                    String searched = newScanner.nextLine();
                    currentUser.setService(searched);
                    IServiceStrategy currentUserService =currentUser.getService();
                    System.out.println(currentUserService.getName()+" Selected ");
                    currentUserService.ExecuteService();
                    System.out.println("Do you want to pay?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    int payFlag= sc.nextInt();
                    if(payFlag  ==1 ){
                        int ind = 1;
                        for(ServiceProvider serviceProvider: serviceProviders ) {
                            System.out.print(ind+" - ");
                            System.out.println(serviceProvider.getName());
                            ind++;
                        }
                        System.out.println("Enter Num of Service Provider to Pay!");
                        int numService = sc.nextInt();
                        ServiceProvider currentServiceProvider = serviceProviderFactories.get(numService-1).getServiceProvider();
                        currentServiceProvider.makePayment();

                    }
                    else if (payFlag  ==2){

                    }
                }
            }
            else{
                System.out.println("1- Sign In ");
                System.out.println("2- Sign Up ");
                System.out.println("3- Exit ");
                int option = sc.nextInt();
                Scanner stringScanner = new Scanner(System.in);
                if(option==1){
                    System.out.println("Enter Email");
                    String email = stringScanner.nextLine();
                    System.out.println("Enter Password");
                    String pass = stringScanner.nextLine();
                    User user = new User(email,pass);
                    currentUser = user;
                    signedIn = true;

                }
                else if(option == 2){
                    System.out.println("Enter UserName");
                    String userName = stringScanner.nextLine();
                    System.out.println("Enter Email");
                    String email = stringScanner.nextLine();
                    System.out.println("Enter Password");
                    String pass = stringScanner.nextLine();
                    User user = new User(userName,email,pass);
                    users.add(user);
                    System.out.println("Do u want to continue Exploring the service");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    int yesNo = stringScanner.nextInt();
                    if(yesNo ==1){
                        signedIn = true;
                        currentUser = user;
                    }
                }
                else if(option ==3){
                    return ;
                }
            }
//            User zoza = new User("GEMY","mohamedgamal45031@gmail.com","01100984620");
//            zoza.setService("Rechrage");

        }
//        gemy.setDiscountForOneUser(.05,zoza);
//        zoza.PayForService();



//        Search search=Search.getInstance();
//
//
//
//
//          search.putService("WERechrage" , new  Discount(.05,search.getService("WERechrage")));
//
//          search.getService("WERechrage").ExecuteService();
//
//          Search search2 =Search.getInstance();
//
//        search.getService("WERechrage").ExecuteService();

    }
}
