import java.util.*;
abstract class Course{
    String courseCode;
    String courseName;
    int credits;
    Course(String courseCode, String courseName, int credits){
        this.courseCode=courseCode;
        this.courseName=courseName;
        this.credits=credits;
    }
    abstract double calculateFee();
    abstract void displayCourseDetails();
}
class RegularCourse extends Course{
    RegularCourse(String code, String name, int credits){
        super(code, name, credits);
    }
    @Override
    double calculateFee(){
        return credits * 5000;
    }
    @Override
    void displayCourseDetails(){
        System.out.println(
            courseName + " (" + courseCode + ") - " +
            "RegularCourse - Fee: " + calculateFee()
        );
    }
}
class OnlineCourse extends Course{
    OnlineCourse(String code, String name, int credits){
        super(code, name, credits);
    }
    @Override
    double calculateFee(){
        return credits * 3000;
    }
    @Override
    void displayCourseDetails(){
        System.out.println(
            courseName + " (" + courseCode + ") - " +
            "OnlineCourse - Fee: " + calculateFee()
        );
    }
}
class CertificationCourse extends Course{
    CertificationCourse(String code, String name, int credits){
        super(code, name, credits);
    }
    @Override
    double calculateFee(){
        return (credits*2000) + 1000;
    }
    @Override
    void displayCourseDetails(){
        System.out.println(
            courseName + " (" + courseCode + ") - " +
            "CertificationCourse - Fee: " + calculateFee()
        );
    }
}
public class university {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        Course[] courses=new Course[n];
        for(int i=0;i<n;i++){
            String type=inp.next();
            String code=inp.next();
            String name=inp.next();
            int credits=inp.nextInt();
            if(type.equals("REGULAR")){
                courses[i]=new RegularCourse(code, name, credits);
            }
            else if(type.equals("ONLINE")){
                courses[i]=new OnlineCourse(code, name, credits);
            }
            else{
                courses[i]=new CertificationCourse(code, name, credits);
            }
        }
        for(int i=0;i<n;i++){
            courses[i].displayCourseDetails();
        }
        inp.close();
    }
}
