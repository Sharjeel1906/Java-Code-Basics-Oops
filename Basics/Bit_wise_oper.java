public class Bit_wise_oper {
    public static void main(String[] args){
        // Bit wise operators

       /*  AND &
        OR |
        NOT ~
        XOR ^
        LEFT SHIFT <<
        RIGHT SHIFT >>
        UNSIGNED RIGHT SHIFT >>>
        */

        int c = 4 & 5;
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));
        // By performing And operation in between bits of 4 and 5 we get 4 thats why c=4
        System.out.println(c);

        int d = 4 & 5;
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));
        // By performing OR operation in between bits of 4 and 5 we get 4 thats why d=2
        System.out.println(d);

        int e = 4 ^ 5;
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));
        // By performing XOR operation in between bits of 4 and 5 we get 4 thats why e=1
        System.out.println(e);
         
        int f = 4;
        System.out.println(Integer.toBinaryString(4));
        int g = ~f;
        System.out.println(Integer.toBinaryString(g));
        // ~ Not turn each bit to opposite value
        System.out.println(g);

        int h = 4;
        System.out.println(Integer.toBinaryString(4));
        int i = h<<1 ;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
        // left shift << Move each bit to the left upto n terms
        System.out.println(h);
       
        int j = 4;
        System.out.println(Integer.toBinaryString(4));
        int k = j>>1 ;
        System.out.println(Integer.toBinaryString(k));
        System.out.println(k);
        // left shift << Move each bit to the left upto n terms
        System.out.println(j);

    }
    
}
