import java.util.*;
class Employee{
    String name;
    String employeeId;
    double salary;
    Employee(String name, String employeeId, double salary){
        this.name=name;
        this.employeeId=employeeId;
        this.salary=salary;
    }
    double calculateBonus(){
        return 0;
    }
    void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println();
    }
}
class Developer extends Employee{
    Developer(String name, String employeeId, double salary){
        super(name, employeeId, salary);
    }
    @Override
    double calculateBonus(){
        return salary * 0.10;
    }
}
class Manager extends Employee{
    Manager(String name, String employeeId, double salary){
        super(name, employeeId, salary);
    }
    @Override
    double calculateBonus(){
        return salary * 0.15;
    }
}
public class employee_bonus {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        Employee[] employees=new Employee[n];
        for (int i=0;i<n;i++){
            String type=inp.next();
            String employeeId=inp.next();
            String name=inp.next();
            double salary=inp.nextDouble();
            if(type.equals("DEVELOPER")){
                employees[i]=new Developer(name, employeeId, salary);
            }
            else{
                employees[i]=new Manager(name, employeeId, salary);
            }
        }
        for(int i=0;i<n;i++){
            employees[i].displayDetails();
        }
        inp.close();
    }
}
