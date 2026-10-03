import java.util.*;
interface PaymentMethod{
    void pay(double amount);
    void refund(double amount);
}
class UPIPayment implements PaymentMethod{
    @Override
    public void pay(double amount){
        System.out.println("UPI: Payment of " + amount + " successful");
    }
    @Override
    public void refund(double amount){
        System.out.println("UPI: Refund of " + amount + " successful");
    }
}
class CreditCardPayment implements PaymentMethod{
    @Override
    public void pay(double amount){
        System.out.println("CREDIT: Payment of " + amount + " successful");
    }
    @Override
    public void refund(double amount){
        System.out.println("CREDIT: Refund of " + amount + " successful");
    }
}
class DebitCardPayment implements PaymentMethod{
    @Override
    public void pay(double amount){
        System.out.println("DEBIT: Payment of " + amount + " successful");
    }
    @Override
    public void refund(double amount){
        System.out.println("DEBIT: Refund of " + amount + " successful");
    }
}
class WalletPayment implements PaymentMethod{
    @Override
    public void pay(double amount){
        System.out.println("WALLET: Payment of " + amount + " successful");
    }
    @Override
    public void refund(double amount){
        System.out.println("WALLET: Refund of " + amount + " successful");
    }
}
class PaymentProcessor{
    void processPayment(PaymentMethod paymentMethod, double amount){
        paymentMethod.pay(amount);
    }
}
public class payment_gateway {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        PaymentProcessor processor=new PaymentProcessor();
        for(int i=0;i<n;i++){
            String type=inp.next();
            double amount=inp.nextDouble();
            PaymentMethod paymentMethod;
            if(type.equals("UPI")){
                paymentMethod=new UPIPayment();
            }
            else if(type.equals("CREDIT")){
                paymentMethod=new CreditCardPayment();
            }
            else if(type.equals("DEBIT")){
                paymentMethod=new DebitCardPayment();
            }
            else{
                paymentMethod=new WalletPayment();
            }
            processor.processPayment(paymentMethod, amount);
        }
        inp.close();
    }
}
