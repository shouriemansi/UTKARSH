import java.util.*;
class BankAccount{
    private int accountNumber;
    private String accountHolder;
    private double balance;
    static int totalAccounts=0;
    static String bankName="Utkarsh Bank";
    BankAccount(String accountHolder, double balance){
        totalAccounts++;
        this.accountNumber=totalAccounts;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }
    void deposit(double amount){
        if(amount>0){
            this.balance+=amount;
        }
    }
    void withdraw(double amount){
        if(amount<=0){
            return;
        }
        if(amount>0 && amount<=this.balance){
            this.balance-=amount;
        }
    }
    static int getTotalAccounts(){
        return totalAccounts;
    }
    void displayDetails(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println();
    }
    int getAccountNumber(){
        return accountNumber;
    }
}

public class bank_account_management_system{
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        BankAccount[] accounts=new BankAccount[n];
        for(int i=0;i<n;i++){
            String name=inp.next();
            double balance=inp.nextDouble();
            accounts[i]=new BankAccount(name, balance);
        }
        int m=inp.nextInt();
        for(int i=0;i<m;i++){
            int accountNumber=inp.nextInt();
            String type=inp.next();
            double amount=inp.nextDouble();
            for(int j=0;j<n;j++){
                if(accounts[j].getAccountNumber()==accountNumber){
                    if(type.equals("DEPOSIT")){
                        accounts[j].deposit(amount);
                    }
                    else if(type.equals("WITHDRAW")){
                        accounts[j].withdraw(amount);
                    }
                    break;
                }
            }
        }
        for(int i=0;i<n;i++){
            accounts[i].displayDetails();
        }
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
        inp.close();
    }
}