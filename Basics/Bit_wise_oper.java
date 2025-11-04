public class Bit_wise_oper {
    public static void main(String[] args){
        // Bitwise Operators in Java
        /*
         AND &     → Bit is 1 only if both bits are 1
         OR |      → Bit is 1 if any one bit is 1
         NOT ~     → Flips every bit (1→0, 0→1)
         XOR ^     → Bit is 1 if bits are different
         LEFT SHIFT <<   → Moves bits to left (multiply by 2 for each shift)
         RIGHT SHIFT >>  → Moves bits to right (divide by 2 for each shift)
         UNSIGNED RIGHT SHIFT >>> → Shifts right but fills left bits with 0
        */

        int c = 4 & 5;
        System.out.println(Integer.toBinaryString(4)); // 4 = 100
        System.out.println(Integer.toBinaryString(5)); // 5 = 101
        // 100 & 101 = 100  (only common 1 at the leftmost bit)
        // Binary 100 = Decimal 4
        System.out.println(c); // Output: 4

        int d = 4 | 5;
        System.out.println(Integer.toBinaryString(4)); // 4 = 100
        System.out.println(Integer.toBinaryString(5)); // 5 = 101
        // 100 | 101 = 101  (any position having 1 gives 1)
        // Binary 101 = Decimal 5
        System.out.println(d); // Output: 5

        int e = 4 ^ 5;
        System.out.println(Integer.toBinaryString(4)); // 4 = 100
        System.out.println(Integer.toBinaryString(5)); // 5 = 101
        // 100 ^ 101 = 001  (bits differ only in last position)
        // Binary 001 = Decimal 1
        System.out.println(e); // Output: 1
         
        int f = 4;
        System.out.println(Integer.toBinaryString(4)); // 4 = 100
        int g = ~f;
        System.out.println(Integer.toBinaryString(g));
        // ~100 → flips bits = ...1111111111111011 (in 32-bit form)
        // Result = -5 (because Java uses 2’s complement for negatives)
        System.out.println(g); // Output: -5

        int h = 4;
        System.out.println(Integer.toBinaryString(4)); // 4 = 100
        int i = h << 1;
        System.out.println(Integer.toBinaryString(i)); // 1000
        // Left shift by 1 moves bits left → multiply by 2
        // 4 << n = 4 * 2^n
        // 4 << 1 = 8
        System.out.println(i); // Output: 8
        System.out.println(h); // Original remains 4
       
        int j = 4;
        System.out.println(Integer.toBinaryString(4)); // 4 = 100
        int k = j >> 1;
        System.out.println(Integer.toBinaryString(k)); // 10
        // Right shift by 1 moves bits right → divide by 2
        // 4 >> n = 4/2^n
        // 4 >> 1 = 2
        System.out.println(k); // Output: 2
        System.out.println(j); // Original remains 4
    }
}
