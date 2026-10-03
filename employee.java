import java.util.*;
class Employee{
    String name;
    String employeeId;
    double baseSalary;
    Employee(String name, String employeeId, double baseSalary){
        this.name=name;
        this.employeeId=employeeId;
        this.baseSalary=baseSalary;
    }
    double calculateSalary(){
        return baseSalary;
    }
    double calculateSalary(double bonus){
        return baseSalary + bonus;
    }
}
class Manager extends Employee{
    Manager(String name, String id, double salary){
        super(name, id, salary);
    }
    @Override
    double calculateSalary(){
        return baseSalary + (baseSalary*0.20);
    }
}
class Developer extends Employee{
    Developer(String name, String id, double salary){
        super(name, id, salary);
    }
    @Override
    double calculateSalary(){
        return baseSalary + (baseSalary*0.15);
    }
}
class Intern extends Employee{
    Intern(String name, String id, double salary){
        super(name, id, salary);
    }
    @Override
    double calculateSalary(){
        return baseSalary + 5000;
    }
}
public class employee {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        Employee[] employees=new Employee[n];
        for(int i=0;i<n;i++){
            String type=inp.next();
            String id=inp.next();
            String name=inp.next();
            double salary=inp.nextDouble();
            if(type.equals("MANAGER")){
                employees[i]=new Manager(name, id, salary);
            }
            else if(type.equals("DEVELOPER")){
                employees[i]=new Developer(name, id, salary);
            }
            else{
                employees[i]=new Intern(name, id, salary);
            }
        }
        for(int i=0;i<n;i++){
            double finalSalary=employees[i].calculateSalary();
            String role="";
            if(employees[i] instanceof Manager){
                role="Manager";
            }
            else if(employees[i] instanceof Developer){
                role="Developer";
            }
            else{
                role="Intern";
            }
            System.out.println(
                employees[i].name + " - " +
                role + " - " +
                finalSalary
            );
        }
        inp.close();       
    }
}
