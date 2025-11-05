public class selection_sort {
    public static void main(String[] args){
        int[] arr = {1,2,4,5,2,7,8};
        int min_index=0;
        for(int i=0;i<arr.length;i++){
            min_index=i;
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[j]<arr[min_index]){
                    min_index=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
        for(int i:arr){
            System.out.println(i);
        }
    }
}
