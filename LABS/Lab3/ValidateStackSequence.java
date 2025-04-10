import java.util.Stack;
import java.util.Scanner;

public class ValidateStackSequence{

    public static Boolean validateStackSequence(int[] pushed, int[] popped){

        Stack<Integer> stacks=new Stack<>();
        int pushindex=0;

        for(int i=0;i<popped.length;i++){

            while(stacks.isEmpty() || stacks.peek()!=popped[i]){
                if(pushindex<pushed.length){
                    stacks.push(pushed[pushindex]);
                    pushindex++;
                }
                else{
                    return false;
                }
            }
            stacks.pop();
            
        }



        return true;
    }
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        int len;
        len=Integer.valueOf(sc.nextLine());
        int[] pushed=new int[len];
        int[] popped=new int[len];
    
        for(int i=0;i<len;i++){

            pushed[i]=sc.nextInt();
        }
        for(int i=0;i<len;i++){

            popped[i]=sc.nextInt();
        }

        System.out.println(validateStackSequence(pushed,popped));
    }
}