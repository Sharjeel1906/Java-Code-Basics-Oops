package lambda_anonymas;

import java.util.ArrayList;
import java.util.Arrays;

@FunctionalInterface
interface Operation{
    double compute(double a, double b);
}
@FunctionalInterface
interface studentfilter{
    boolean test(Student s);
}
class Student{
    String name;
    double marks;
    int age;
    public Student(String name,double marks,int age){
        this.age=age;
        this.marks=marks;
        this.name = name;
    }

}
public class pract {
    public static void main(String[] args){
        /*Operation add = (a,b)->a+b;
        Operation sub = (a,b)->a-b;
        Operation mul = (a,b)->a*b;
        Operation div = (a,b)->a/b;
        Operation mod = new Operation() {
            public double compute(double a,double b){
                return a%b;
            }
        };
        System.out.println(add.compute(21, 7));
        System.out.println(sub.compute(21, 7));
        System.out.println(mul.compute(21, 7));
        System.out.println(div.compute(21, 7));
        System.out.println(mod.compute(21, 7));*/
        Student s1 = new Student("Sharjeel",90,18);
        Student s2 = new Student("Ali",65,19);
        Student s3 = new Student("Ahmed",32,23);
        Student s4 = new Student("Haris",67,21);
        ArrayList<Student> array = new ArrayList<>(Arrays.asList(s1,s2,s3,s4));
        studentfilter highmarks = (Student s)->s.marks>80;
        studentfilter age = (Student s)->s.age<20;
        studentfilter combine = (Student s)-> s.marks>80 || s.age<20 || s.name.startsWith("A");
        studentfilter name = new studentfilter() {
            public boolean test(Student s){
                return s.name.startsWith("A");
            }
        };
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            if(combine.test(s)){
                System.out.println(s.name);
            }
            // if(highmarks.test(s)){
            //     System.out.println(s.name);
            // }else if(age.test(s)){
            //     System.out.println(s.name);
            // }else if(name.test(s)){
            //     System.out.println(s.name);
            // }
        }
    }
    
}
