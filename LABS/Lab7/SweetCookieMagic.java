// package col_106.LABS.Lab7;
import java.util.ArrayList;

public class SweetCookieMagic {
    static ArrayList<Integer> heap=new ArrayList<>();

    public static void heapifyDown(int[] array, int index){
        int left=2*index+1;
        int right=2*index+2;
        if(left<=array.length){
            int min=left;
            if(right<=array.length){
                min=array[left]<array[right] ? left : right;
            }
            if(array[min]<array[index]){

                int temp=array[index];
                array[index]=array[min];
                array[min]=temp;
                heapifyDown(array, min);

            }
        }
    }
    public static void buildHeap(int[] array){
        heap.clear();
        int index=(array.length-2)/2;
        for(int i=index;i>=0;i--){
            heapifyDown(array, i);
        }
    }

    public static ArrayList<Integer> cookieMagic(int[][] mat, int k){
        ArrayList<Integer> lst= new ArrayList<>();
        for(int i=0;i<mat.length;i++){
            int count=0;
            buildHeap(mat[i]);
            while(heap)
        }
        return lst;
    }

    public static void main(String args[]){
        int[][] mat = {{1, 1, 1}, {1, 1, 0}, {0, 0, 0}};
        int k = 2;
        for(int item : cookieMagic(mat, k)){
            System.out.print(item + " ");
        }
    }
}
