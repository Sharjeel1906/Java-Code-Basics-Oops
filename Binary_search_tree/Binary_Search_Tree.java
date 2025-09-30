package Binary_search_tree;

import java.io.File;
import java.util.Scanner;

public class Binary_Search_Tree {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        int user_choice,num;
        int[][] Arr = {
                { 3, 45, 1 },
                { 4, 52, 2 },
                { 7, 77, 8 },
                { -1, 17, 5 },
                { -1, 49, -1 },
                { 6, 38, -1 },
                { -1, 20, 10 },
                { -1, 60, -1 },
                { -1, 93, 9 },
                { -1, 95, -1 },
                { -1, 25, -1 }
        };

        System.out.println("Please Select Any Option from Following:\n1-Print Leaf Nodes Data\n2-Search a value\n3-Search number and give parent and child nodes\n4-Print in-orderd Traversal nodes\n5-Take data from txt file");
        user_choice = read.nextInt();
        if(user_choice==1){
            Leaf_nodes(Arr);
        }else if(user_choice==2){
            System.out.println("Entre the number you want to search:");
            num = read.nextInt();
            Search_num(num, Arr);
        }else if(user_choice==3){
            System.out.println("Entre the number of which parent and child nodes you want to know:");
            num = read.nextInt();
            parent_and_child_nodes(num, Arr);
        }else if(user_choice==4){
            inorderd_traversal_nodes(0,Arr);
        }else if(user_choice==5){
            Data_from_txt_file();
        }else{
            System.out.println("Wrong Value Entered");
        }
        read.close();
    }
    public static void Leaf_nodes(int[][] Arr){
        System.out.println("Leaf Nodes Are :");
        // Both left and right index should be equal to zero
        int count=0;
        for(int i=0;i<Arr.length;i++){
            int[] sub_arr = Arr[i];
            if(sub_arr[0]==-1 && sub_arr[2]==-1){
                System.out.println(sub_arr[1]);
                count++;
            }
        }
        System.out.println("Total number of Leaf nodes are "+count);
    }
    public static void Search_num(int num,int[][] Arr){
        boolean found=false;
        for(int i=0;i<Arr.length;i++){
            int[] sub_arr = Arr[i];
            if(sub_arr[1]==num){
                System.out.println(num+" Found at index: "+i);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println(num+" Not found in array");
        }
    }
    public static void parent_and_child_nodes(int num,int[][] Arr){
        for(int i=0;i<Arr.length;i++){
            int[] sub_arr = Arr[i];
            int left_index = sub_arr[0];
            int right_index = sub_arr[2];
            if(sub_arr[1]==num){
                // finding parent 
                for(int j=0;j<Arr.length;j++){
                    if(Arr[j][0]==i || Arr[j][2]==i){
                        System.out.println("Parent of "+num+" is :"+Arr[j][1]);
                    }
                }
                // finding childs
                if(left_index==-1 && right_index==-1){
                System.out.println("No child Nodes Exist");
                }else if(left_index==-1 && right_index!=-1){
                    int[] right_arr = Arr[right_index];
                    System.out.println("Child of "+num+" is : "+right_arr[1]);
                }else if(left_index!=-1 && right_index==-1){
                    int[] left_arr = Arr[left_index];
                    System.out.println("Child of "+num+" is : "+left_arr[1]);
                }
                else{
                    int[] left_arr = Arr[left_index];
                    int[] right_arr = Arr[right_index];
                    System.out.println("Child of "+num+" are : "+left_arr[1]+" and "+right_arr[1]);
                }
            }
           
        }
       
    }
    public static void inorderd_traversal_nodes(int root_index,int[][] Arr){ // LNR
        if(root_index==-1) return;
        inorderd_traversal_nodes(Arr[root_index][0], Arr); // left
        System.out.println(Arr[root_index][1]);
        inorderd_traversal_nodes(Arr[root_index][2], Arr);
    }
    public static void Data_from_txt_file()throws Exception{

        File myfile = new File("C:\\Users\\97155\\OneDrive\\java_projects(1)\\Binary_search_tree\\data.txt");
        Scanner read = new Scanner(myfile);
        if (read.hasNextLine()) {
            read.nextLine();
        }
        int[][] data_arr = new int[11][3];
        for (int i = 0; i < 11; i++) {
            data_arr[i][0] = read.nextInt(); 
            data_arr[i][1] = read.nextInt(); 
            data_arr[i][2] = read.nextInt(); 
        }
        read.close();
        for (int i = 0; i < 11; i++) {
            System.out.println(data_arr[i][0] + " " + data_arr[i][1] + " " + data_arr[i][2]);
        }
}
}
