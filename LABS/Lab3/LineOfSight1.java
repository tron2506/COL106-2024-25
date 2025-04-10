import java.util.Stack;
import java.util.Scanner;

public class LineOfSight1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int [] arr=new int[len];
        int[] result=new int[len];
        Stack<Integer> stacks=new Stack<>();

        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=len-1;i>=0;i--){

            while(!stacks.isEmpty() && arr[i]>=stacks.peek()){
                stacks.pop();
            }
            if(stacks.isEmpty()){
                result[i]=-1;
            }
            else{
                result[i]=stacks.peek();
            }
            stacks.push(arr[i]);
            
        }

        for(int i=0;i<len;i++){
            System.out.print(result[i]+" ");
        }

        
    }
}

