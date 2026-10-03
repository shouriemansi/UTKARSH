import java.util.*;
class Product{
    int productId;
    String name;
    double price;
    Product(int productId, String name, double price){
        this.productId=productId;
        this.name=name;
        this.price=price;
    }
    double calculateFinalPrice(){
        return price;
    }
}
class Electronics extends Product{
    Electronics(int id, String name, double price){
        super(id, name, price);
    }
    @Override
    double calculateFinalPrice(){
        return price + (price*0.18) + 1000;
    }
}
class Clothing extends Product{
    Clothing(int id, String name, double price){
        super(id, name, price);
    }
    @Override
    double calculateFinalPrice(){
        double discountedPrice=price - (price*0.10);
        return discountedPrice + (discountedPrice * 0.05);
    }
}
class Book extends Product{
    Book(int id, String name, double price){
        super(id, name, price);
    }
    @Override
    double calculateFinalPrice(){
        return price + (price*0.05);
    }
}
public class e_commerce {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        Product[] products=new Product[n];
        for(int i=0;i<n;i++){
            String type=inp.next();
            int id=inp.nextInt();
            String name=inp.next();
            double price=inp.nextDouble();
            if(type.equals("ELECTRONICS")){
                products[i]=new Electronics(id, name, price);
            }
            else if(type.equals("CLOTHING")){
                products[i]=new Clothing(id, name, price);
            }
            else{
                products[i]=new Book(id, name, price);
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(
                products[i].name + ": " +
                products[i].calculateFinalPrice()
            );
        }
        inp.close();        
    }
}
