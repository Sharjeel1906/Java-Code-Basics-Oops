package Equation_solving;
import java.util.*;
public class eq_solving {
    public static void main(String[] args){
        double ya=1;
        double yb=1;
        double yc=1;
        double c=1;
        Scanner read = new Scanner(System.in);
        String eq = "x*x - 5x + 6";
        System.out.println("Please entre the value of a");
        double a = read.nextDouble();
        System.out.println("Please entre the value of b");
        double b = read.nextDouble();
        while (Math.abs(ya) > 0.00000001 && Math.abs(yb) > 0.00000001 && Math.abs(yc) > 0.00000001){
            ya = a*a -5*a +6;
            yb = b*b - 5*b +6;
            double y= ya*yb;
            if(y<0){
                c = (a+b)/2;
                yc = c*c - 5*c +6;
                if(yc<0 && ya>0 || yc>0 && ya<0){
                    b=c;
                }else if (yc<0 && yb>0 || yc>0 && yb<0){
                    a=c;
                }
            }else{
                System.out.println("Please entre correct values of a and b");
                System.out.println("Please entre the value of a");
                a = read.nextDouble();
                System.out.println("Please entre the value of b");
                b = read.nextDouble();
            }
        }
        if(Math.abs(ya)<=0.00000001){
            System.out.println("Solution of equation is "+ a);
        }else if (Math.abs(yb)<=0.00000001){
            System.out.println("Solution of equation is "+ b);
        }else{
            System.out.println("Solution of equation is "+ c);
        }
        read.close();

    }
}
