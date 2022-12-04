package FawrySystem;

import java.util.Scanner;

public class CreditCardProvider implements ServiceProvider {
    private String name  = "Credit Card";
    @Override
    public void handler() {
        showPaymentForm();
        System.out.println("Credit Card Paying.....");
    }
//dhfdkjhdglkdjg
    @Override
    public void showPaymentForm() {
        System.out.println("### --------------- Credit Card Provider form --------------- ### ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Credit Card number: ");
        int cardNum=sc.nextInt();
        System.out.println("Enter Amount: ");
        float amount=sc.nextInt();
        System.out.println("### --------------- ------------------------- --------------- ### ");
    }

    @Override
    public String getName(){
        return name;
    }
}
