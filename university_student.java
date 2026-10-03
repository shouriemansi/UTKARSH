import java.util.*;
class Person{
    String name;
    int age;
    Person(String name, int age){
        this.name=name;
        this.age=age;
    }
    void displayDetails(){
        System.out.println("Person: " + name + ", Age: " + age);
    }
}
class Student extends Person{
    String studentId;
    Student(String studentId, String name, int age){
        super(name, age);
        this.studentId=studentId;
    }
    @Override
    void displayDetails(){
        System.out.println("Student: " + name + ", ID: " + studentId + ", Age: " + age);
    }
}
class EngineeringStudent extends Student{
    String branch;
    EngineeringStudent(String studentId, String name, int age, String branch){
        super(studentId, name, age);
        this.branch=branch;
    }
    @Override
    void displayDetails(){
        System.out.println("Engineering Student: " + name + ", ID: " + studentId + ", Age: " + age + ", Branch: " + branch);
    }
}
class CSEStudent extends EngineeringStudent{
    String specialization;
    CSEStudent(String studentId, String name, int age, String specialization){
        super(studentId, name, age, "CSE");
        this.specialization=specialization;
    }
    @Override
    void displayDetails(){
        System.out.println("CSE Student: " + name + ", ID: " + studentId + ", Age: " + age + ", Specialization: " + specialization);
    }
}
public class university_student {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        Person[] people=new Person[n];
        for(int i=0;i<n;i++){
            String type=inp.next();
            if(type.equals("STUDENT")){
                String id=inp.next();
                String name=inp.next();
                int age=inp.nextInt();
                people[i]=new Student(id, name, age);
            }
            else if(type.equals("ENGINEERING")){
                String id=inp.next();
                String name=inp.next();
                int age=inp.nextInt();
                String branch=inp.next();
                people[i]=new EngineeringStudent(id, name, age, branch);
            }
            else if(type.equals("CSE")){
                String id=inp.next();
                String name=inp.next();
                int age=inp.nextInt();
                String specialization=inp.next();
                people[i]=new CSEStudent(id, name, age, specialization);
            }
        }
        Person p=new CSEStudent("C104", "Riya", 21, "AI");
        p.displayDetails();
        for(int i=0;i<n;i++) {
            people[i].displayDetails();
        }
        inp.close();
    }
}
