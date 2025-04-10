// package col_106.LABS.Lab7;
import java.util.ArrayList;

public class KSmallestElements {
    public static void heapifyDownHSort(int[] array, int index, int endindex){
        int left=2*index+1;
        int right=2*index+2;
        if(left<=endindex){
            int max=left;
            if(right<=endindex){
                max=array[left]>array[right] ? left : right;

            }

            int temp=array[index];
            if(array[max]> temp){
                array[index]=array[max];
                array[max]=temp;
                heapifyDownHSort(array,max,endindex);
            }
        }
    }
    public static void heapSort(int[] array, int arraySize){
        int index=(arraySize-2)/2;
        for(int i=index;i>=0;i--){
            heapifyDownHSort(array, i, arraySize-1);
        }
        // int j=arraySize-1;
        // while(j>=0){
        //     int temp=array[0];
        //     array[0]=array[j];
        //     array[j]=temp;
        //     j--;
        //     heapifyDownHSort(array,0,j);
        // }
    }
    public static void kSmallestElements(int[] arr, int k){

        heapSort(arr,k);
        int N=arr.length;
        for(int i=N-1;i>=k;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapifyDownHSort(arr,0,k-1);
        }
        int j=k-1;
        while(j>=0){
            int temp=arr[0];
            arr[0]=arr[j];
            arr[j]=temp;
            j--;
            heapifyDownHSort(arr,0,j);
        }
        for(int i=0;i<k;i++){
            System.out.print(arr[i]+ " ");
        }


    }
    public static void main(String args[]){
        int[] array={1,23,4,63,3,2,5,6,34,5,6,73};
        kSmallestElements(array, 12);
    }
}
