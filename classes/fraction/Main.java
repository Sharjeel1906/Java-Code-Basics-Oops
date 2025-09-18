package classes.fraction;

public class Main {
    public static class Fraction{
        int num,deno;
        public Fraction(int numertor,int denominator){
            num = numertor;
            deno = denominator;
        }
        public static Fraction multiply(Fraction f1 , Fraction f2){
            int num =f1.num * f2.num;
            int deno = f1.deno * f2.deno;
            return  new Fraction(num, deno);
        }
    }
    public static void main(String[] args){
        Fraction f1 = new Fraction(3,5);
        Fraction f2 = new Fraction(5, 2);
        Fraction result = Fraction.multiply(f1,f2);
        System.out.println(result.num+"/"+result.deno);
    }
}
