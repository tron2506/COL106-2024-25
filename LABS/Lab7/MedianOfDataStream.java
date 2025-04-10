import java.util.ArrayList;
public class MedianOfDataStream {
    public static ArrayList<Double> streamMed(int[] A){
        ArrayList<Integer> heap= new ArrayList<>();
        ArrayList<Double> med= new ArrayList<>();

        for(int i=0;i<A.length;i++){

            heap.add(A[i]);
            heapifyUp(heap, heap.size()-1);
            if(heap.size()%2!=0){
                med.add(heap.get(heap.size()/2)*1.0);
            }
            else{
                med.add((heap.get(heap.size()/2 - 1) + heap.get(heap.size()/2))/2.0);
            }


        }


        return med;
    }
    public static void heapifyUp(ArrayList<Integer> heap, int index){
        while(index>0){
            int parent = (index - 1) / 2;
            if(heap.get(parent)>heap.get(index)){
                int temp = heap.get(index);
                heap.set(index, heap.get(parent));
                heap.set(parent, temp);
                index = parent;
            }
            else{
                break;
            }
        }
        return;
    }
}
