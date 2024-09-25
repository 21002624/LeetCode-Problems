//Write a function that reverses a string. The input string is given as an array of characters s.
//You must do this by modifying the input array in-place with O(1) extra memory.
import java.util.*;
public class Day12 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        char[] array=new char[n];
        String input=sc.nextLine();
        for(int i=0;i<n;i++){
            array[i]=input.charAt(i);
        }
        for(int i=0;i<n;i++){
            int left=0;
            int right=n-1;
            while(left<right){
                char temp=array[left];
                array[left]=array[right];
                array[right]=temp;
                left++;
                right--;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(array[i]+" ");
        }
    }
}
