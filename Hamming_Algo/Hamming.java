package Hamming_Algo;

public class Hamming {
    public static void main(String[] args) {

        // Sender Side
        String[] msg = {"2","0","0","0","0","1","0","0","0","1","1","1","0","0","1"};
        int[] parity = new int[4];
        int[] pos = {1,2,4,8};  // parity bit positions

        // finding parity bits
        for(int i=0;i<pos.length;i++){
            int p = pos[i];
            int sum = 0;
            for(int j=p;j<msg.length;){
                for(int k=0;k<p && j+k<msg.length;k++){
                    sum += Integer.parseInt(msg[j+k]);
                }
                j += p*2;
            }
            parity[i] = sum;
            if(sum%2!=0){
                msg[p] = "1";
            }
        }

        System.out.print("Message to Send: ");
        for(String bit: msg){
            System.out.print(bit);
        }
        System.out.println();

        // Receiver Side
        String[] recv = {"2","1","1","0","0","1","0","0","1","1","1","1","1","0","1"};
        int[] check = new int[4];
        int errPos = 0;

        // checking error
        for(int i=0;i<pos.length;i++){
            int p = pos[i];
            int sum = 0;
            for(int j=p;j<recv.length;){
                for(int k=0;k<p && j+k<recv.length;k++){
                    sum += Integer.parseInt(recv[j+k]);
                }
                j += p*2;
            }
            check[i] = sum;
            if(sum%2!=0){
                errPos += p;
            }
        }

        if(errPos!=0){
            System.out.println("Error found at bit position: " + errPos);
        }else{
            System.out.println("Message received correctly!");
        }
    }
}
