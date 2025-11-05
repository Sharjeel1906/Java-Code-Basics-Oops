public class Linear_search {
    public static void main(String[] args){
        int[] array = {1,3,5,2,6,7};

        int target=6;
        for(int i=0;i<array.length;i++){
            if(array[i]==target){
                System.out.println("Target found at index :"+i);
                break;
            }else{
                continue;
            }
        }
    }
}
