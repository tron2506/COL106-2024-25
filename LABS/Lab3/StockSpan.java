package COL106.LABS;
import java.util.Stack;
import java.util.Scanner;


public class StockSpan {
    
    public static int[] stockSpan(int[] arr){
        
        int len=arr.length;
        int[] span=new int[len];

        Stack<Integer> stacks=new Stack<>();

        for(int i=0;i<len;i++){
            int days=1;
            while(!stacks.isEmpty() && arr[i]>=stacks.peek()){
                days++;
                stacks.pop();
            }
            if()
            stacks.push(arr[i]);
            span[i]=days;
        }

        return span;
    }
    public static void main(String args[]){

        int[] arr={100,80,60,70,60,75,85};
        for(int x:stockSpan(arr)){
            System.out.print(x+" ");
        }
    }

}
