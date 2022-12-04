package FawrySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<User>();
        Admin mhmdSamir = new Admin("MohamedSamir@gmail.com", "123456");
        mhmdSamir.setDiscountForAllServices(0.5);
        Scanner sc = new Scanner(System.in);
        boolean signedIn = false;
        boolean admin = false;
        User currentUser = new User();
        List<ServiceProvider> serviceProviders = new ArrayList<>();
        ServiceProvider vodafone = new VodafoneCashProvider();
        ServiceProvider creditCard = new CreditCardProvider();
        serviceProviders.add(vodafone);
        serviceProviders.add(creditCard);
        while (true) {
            if (signedIn && admin) {
                System.out.println("1- Log Out");
                System.out.println("2- Set Discounts");
                System.out.println("3- Show Refund Requests");
                int option = sc.nextInt();
                if (option == 1) {
                    signedIn = false;
                    admin = false;
                } else if (option == 2) {
                    System.out.println("1 - For Specific Discount For One Service");
                    System.out.println("2 - For Overall Discount For All Services");
                    int discountOption = sc.nextInt();
                    if (discountOption == 1) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Enter Service Name");
                        String serviceName = scanner.nextLine();
                        System.out.println("Enter Percentage of Discount");
                        int percent = sc.nextInt();
                        mhmdSamir.setDiscount(serviceName, (double) percent / 100);
                    } else if (discountOption == 2) {
                        System.out.println("Enter Percentage for All Services");
                        int percent = sc.nextInt();
                        mhmdSamir.setDiscountForAllServices((double)percent/100);
                    }

                } else if (option == 3) {
                    int ind = 1;
                    List<Integer> removeRefunds = new ArrayList<>();
                    for (Refund r : mhmdSamir.getRefunds()) {
                        System.out.println(r.getDescription() + " " + r.getAmount() + " " + r.getUser().getUserName());
                        System.out.println("Do you want to Refund?");
                        System.out.println("1- Yes");
                        System.out.println("2- No");
                        System.out.println("3- Exit");
                        Scanner newScanner = new Scanner(System.in);
                        int optionRefund = newScanner.nextInt();
                        if (optionRefund == 1) {
                            r.getUser().setWalletBalance(r.getUser().getWalletBalance() + r.getAmount());
                            System.out.println("Request Has Been Refunded *_*");
                            removeRefunds.add(ind - 1);
                        } else if (optionRefund == 2) {
                            removeRefunds.add(ind - 1);
                            System.out.println("Request Hasn't Been refunded -_-");

                        } else {
                            break;
                        }
                        ind++;

                    }
                    for (int i = removeRefunds.size() - 1; i >= 0; i--) {
                        System.out.println("Fund Number " + i + " Has Been Removed");
                        mhmdSamir.getRefunds().remove(i);
                    }
                }
            } else if (signedIn && !admin) {
                System.out.println("1- Log Out");
                System.out.println("2- Search");
                System.out.println("3- Transfer Money To Wallet");
                System.out.println("4- Make Refund Request");
                int option = sc.nextInt();
                if (option == 1) {
                    currentUser = null;
                    signedIn = false;
                }
                if (option == 2) {
                    System.out.println("Search For The Service You Want!");
                    Scanner newScanner = new Scanner(System.in);
                    String searched = newScanner.nextLine();
                    currentUser.setService(searched);
                    IServiceStrategy currentUserService = currentUser.getService();
                    System.out.println(currentUserService.getName() + " Selected ");
                    currentUserService.ExecuteService();
                    System.out.println("Do you want to pay?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    int payFlag = sc.nextInt();
                    if (payFlag == 1) {
                        int ind = 1;
                        for (ServiceProvider serviceProvider : serviceProviders) {
                            System.out.print(ind + " - ");
                            System.out.println(serviceProvider.getName());
                            ind++;
                        }
                        System.out.println(ind + " - Fawry Wallet");
                        System.out.println("Enter Num of Service Provider to Pay!");
                        int numService = sc.nextInt();
                        Transaction tr = new Transaction();
                        if (numService <= 2) {
                            ServiceProvider currentServiceProvider = serviceProviders.get(numService - 1);
                            currentServiceProvider.handler();
                            tr.setTransactionName(currentUserService.getName());
                            tr.setAmount(currentUserService.getPrice());
                            currentUser.addTransactions(tr);
                        } else {
                            if (currentUser.getWalletBalance() < currentUserService.getPrice()) {
                                System.out.println("Your wallet balance is not enough !!!!!");
                            } else {
                                double walletBalance = currentUser.getWalletBalance();
                                double price = currentUserService.getPrice();
                                System.out.println("Your wallet balance is : " + walletBalance);
                                System.out.println("Your service cost is : " + price);
                                currentUser.setWalletBalance(walletBalance - price);
                                System.out.println("Your wallet balance after make payment : " + currentUser.getWalletBalance());
                                tr.setTransactionName(currentUserService.getName());
                                tr.setAmount(currentUserService.getPrice());
                                currentUser.addTransactions(tr);

                            }
                        }
                    } else if (payFlag == 2) {

                    }
                }
                if (option == 3) {
                    System.out.println("Enter Credit Card number");
                    Scanner scannerFloat = new Scanner(System.in);
                    float creditCardNumber = scannerFloat.nextFloat();
                    System.out.println("Enter Amount");
                    Scanner scannerAmount = new Scanner(System.in);
                    float amount = scannerAmount.nextFloat();
                    System.out.println(currentUser.getWalletBalance() + " Is Your Current Balance before Transfer!");
                    System.out.println(amount + " Transferred!");
                    currentUser.setWalletBalance(currentUser.getWalletBalance() + amount);
                    System.out.println(currentUser.getWalletBalance() + " Is Your Current Balance after Transfer!");
                }
                if (option == 4) {
                    List<Transaction> refundableRequests = currentUser.getRefundableRequests();
                    if (refundableRequests.size() > 0) {
                        for (int i = 0; i < refundableRequests.size(); i++) {
                            Transaction t = refundableRequests.get(i);
                            System.out.println((i + 1) + " - " + t.getTransactionName() + " " + t.getAmount());
                        }
                        System.out.println("Choose FawrySystem.Transaction to Make Refund Request!");
                        Scanner newScanner = new Scanner(System.in);
                        int refund = newScanner.nextInt();
                        String transactionName = refundableRequests.get(refund - 1).getTransactionName();
                        double transactionAmount = refundableRequests.get(refund - 1).getAmount();
                        Refund r = new Refund(transactionName, transactionAmount, currentUser);
                        refundableRequests.get(refund - 1).setRefundRequested(true);
                        mhmdSamir.addRefund(r);
                    } else {
                        System.out.println("No Refundable Requests Are Available!");
                    }

                }
            } else if (!signedIn) {
                System.out.println("1- Sign In As Admin");
                System.out.println("2- Sign In As User");
                System.out.println("3- Sign Up ");
                System.out.println("4- Exit ");
                int option = sc.nextInt();
                Scanner stringScanner = new Scanner(System.in);
                if (option == 1) {
                    System.out.println("Enter Email");
                    String email = stringScanner.nextLine();
                    System.out.println("Enter Password");
                    String pass = stringScanner.nextLine();
                    if (Objects.equals(email, "MohamedSamir@gmail.com") && Objects.equals(pass, "123456")) {
                        admin = true;
                        signedIn = true;
                    } else {
                        System.out.println("Wrong Credentials");
                    }
                } else if (option == 2) {
                    System.out.println("Enter Email");
                    String email = stringScanner.nextLine();
                    System.out.println("Enter Password");
                    String pass = stringScanner.nextLine();
                    for (User u : users) {
                        if (Objects.equals(u.getEmail(), email) && Objects.equals(u.getPassword(), pass)) {
                            currentUser = u;
                            signedIn = true;

                        }
                    }
                } else if (option == 3) {
                    System.out.println("Enter UserName");
                    String userName = stringScanner.nextLine();
                    System.out.println("Enter Email");
                    String email = stringScanner.nextLine();
                    System.out.println("Enter Password");
                    String pass = stringScanner.nextLine();
                    User user = new User(userName, email, pass);
                    users.add(user);
                    System.out.println("Do u want to continue Exploring the service");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    int yesNo = stringScanner.nextInt();
                    if (yesNo == 1) {
                        signedIn = true;
                        currentUser = user;
                    }
                } else if (option == 4) {
                    return;
                }
            }

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
