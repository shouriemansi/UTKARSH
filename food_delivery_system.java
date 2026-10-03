import java.util.*;
class Address{
    private String address;
    Address(String address){
        this.address=address;
    }
    String getAddress(){
        return address;
    }
}
class Customer{
    private String name;
    private Address address;
    Customer(String name, Address address){
        this.name=name;
        this.address=address;
    }
    String getName(){
        return name;
    }
    Address getAddress(){
        return address;
    }
}
class Restaurant{
    private String name;
    Restaurant(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
}
class FoodItem{
    private String name;
    private double price;
    private int quantity;
    FoodItem(String name, double price, int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    double getTotalPrice(){
        return price*quantity;
    }
    String getName(){
        return name;
    }
    double getPrice(){
        return price;
    }
    int getQuantity(){
        return quantity;
    }
}
class Order{
    private Customer customer;
    private Restaurant restaurant;
    private ArrayList<FoodItem> items;
    private final double DELIVERY_CHARGE=50;
    private final double TAX_RATE=0.05;
    private final double DISCOUNT_RATE=0.10;
    Order(Customer customer, Restaurant restaurant){
        this.customer=customer;
        this.restaurant=restaurant;
        items = new ArrayList<>();
    }
    void addFoodItem(FoodItem item){
        items.add(item);
    }
    double calculateSubtotal(){
        double subtotal=0;
        for(FoodItem item:items){
            subtotal=subtotal+item.getTotalPrice();
        }
        return subtotal;
    }
    double calculateDiscount(){
        double subtotal=calculateSubtotal();
        if(subtotal>=1000){
            return subtotal*DISCOUNT_RATE;
        }
        return 0;
    }
    double calculateTax(){
        double subtotal=calculateSubtotal();
        double discount=calculateDiscount();
        double amountAfterDiscount=subtotal-discount;
        return amountAfterDiscount*TAX_RATE;
    }
    double calculateFinalBill(){
        double subtotal=calculateSubtotal();
        double discount=calculateDiscount();
        double tax=calculateTax();
        return subtotal - discount + tax + DELIVERY_CHARGE;
    }
    void displayOrderDetails(){
        double subtotal=calculateSubtotal();
        double discount=calculateDiscount();
        double tax=calculateTax();
        double finalBill=calculateFinalBill();
        System.out.println("Customer: " + customer.getName());
        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Delivery Charge: " + DELIVERY_CHARGE);
        System.out.println("Final Bill: " + finalBill);
    }
}
public class food_delivery_system {
    public static void main(String[] args) {
       Scanner inp=new Scanner(System.in);
       String customerName=inp.nextLine();
       String addressText=inp.nextLine();
       Address address=new Address(addressText);
       Customer customer=new Customer(customerName, address);
       String restaurantName=inp.nextLine();
       Restaurant restaurant=new Restaurant(restaurantName);
       Order order=new Order(customer, restaurant);
       int N=inp.nextInt();
       for(int i=0;i<N;i++){
            String itemName=inp.next();
            double price=inp.nextDouble();
            int quantity=inp.nextInt();
            FoodItem item=new FoodItem(itemName, price, quantity);
            order.addFoodItem(item);
        }
        order.displayOrderDetails();
        inp.close();
    }
}
