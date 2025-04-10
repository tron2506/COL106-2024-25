import java.util.Stack;
import java.util.Scanner;
public class EncodedString {
    public static int findEndIndex(String str, int startIndex){
        int open=1;
        int len=str.length();
        int i=startIndex+1;
        while(i<len){
                if(str.charAt(i)=='[') open++;
                if(str.charAt(i)==']') open--;
                if(open==0) break;
                i++;
        }
        return i;
    }
    public static String decodeString(String str){

        Stack<String> stacks1=new Stack<>();
        Stack<String> stacks2=new Stack<>();
        String result="";
        int length=str.length();
        
        for(int i=0;i<length;i++){

            if(Character.isDigit(str.charAt(i))){

                int num=Integer.valueOf(String.valueOf(str.charAt(i)));

                for(int j=0;j<num;j++){

                    stacks1.push(decodeString(str.substring(i+2,findEndIndex(str,i+1))));

                }

                i=findEndIndex(str,i+1);

            }
            else{
                        stacks1.push(String.valueOf(str.charAt(i)));

            }
        }

        while(!stacks1.isEmpty()){
            stacks2.push(stacks1.pop());
        }
        while(!stacks2.isEmpty()){
            result=result+stacks2.pop();
        }
        return result;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        // System.out.println("enter a string");
        String str=sc.nextLine();
        System.out.println(decodeString(str));
    }
}
