package Linked_list;
import java.util.Scanner;

public class LinkedListMain {
    static class Node {
        int data;
        int index;

        public Node(int d, int i) {
            data = d;
            index = i;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            int smallest_index = 0;
            int size = 0;

            System.out.println("Enter the size of array");
            size = input.nextInt();

            Node[] linked_list = new Node[size];
            System.out.println("Enter the values");
            for (int i = 0; i < size; i++) {
                int val = input.nextInt();
                linked_list[i] = new Node(val, -1);

                if (i == 0) {
                    smallest_index = i;
                } else {
                    if (val < linked_list[smallest_index].data) {
                        smallest_index = i;
                    }
                }
            }

            int second_smal = smallest_index;
            boolean[] Arr = new boolean[size];
            Arr[smallest_index] = true;

            for (int i = 1; i < size; i++) {
                int min = 1000000;
                int next_index = -1;
                for (int j = 0; j < size; j++) {
                    if (!Arr[j]) {
                        if (linked_list[j].data < min) {
                            min = linked_list[j].data;
                            next_index = j;
                        }
                    }
                }
                linked_list[second_smal].index = next_index;
                second_smal = next_index;
                Arr[second_smal] = true;
            }

            display(linked_list, size);
            sorted_arr(linked_list, size, smallest_index);

            input.nextLine(); 
            System.out.println("Do You Want to Add any number to list? y/n");
            String add = input.nextLine();
            if (add.equalsIgnoreCase("y")) {
    
            } else {
                System.out.println("Thank you !");
            }
            input.close();
        }

        


    public static void display(Node[] linked_list, int size) {
        System.out.println("Given Array is:");
        for (int i = 0; i < size; i++) {
            System.out.println("Data: " + linked_list[i].data + ", Index: " + linked_list[i].index);
        }
    }

    public static void sorted_arr(Node[] linked_list, int size, int smallest_index) {
        System.out.println("Sorted Array:");
        int current = smallest_index;

        while (current != -1) {
            System.out.println(linked_list[current].data);
            current = linked_list[current].index; // move to next
        }
    }
}
