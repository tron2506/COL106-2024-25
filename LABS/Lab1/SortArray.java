import java.util.Scanner;
public class SortArray {
    
    public static int[] sort(int[] arr){

        int len=arr.length;
        int min=arr[0];
        int max=arr[0];
        int med=arr[0];
        for(int i=0;i<len;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];
            }
        }

        int mincount=0,maxcount=0;
        for(int i=0;i<len;i++){
            if(arr[i]==min){mincount++;}
            else if(arr[i]==max){maxcount++;}
            else{
                med=arr[i];
            }
        }
        for(int i=0;i<len;i++){
            if(i<mincount){
                arr[i]=min;
            }
            else if(i>=len-maxcount){
                arr[i]=max;
            }
            else{
                arr[i]=med;
            }
        }

        return arr;
    }
    public static void main(String args[]){
        int[] arr={2,1,3,2,1,3,2};

        for(int i:sort(arr)){
            System.out.println(i);
        }
    }
}
