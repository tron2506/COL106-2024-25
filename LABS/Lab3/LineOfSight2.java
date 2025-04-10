import java.util.*;
public class LineOfSight2 {
    public int[] nextSecGreater(int[] hist){
        int n=hist.length;
        int[] results=new int[n];
        Arrays.fill(results,-1);
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && hist[i] > hist[st.peek()]){
                results[st.pop()]=i;
            }
            st.push(i);
        }
        for(int i=n-1;i>=0;i--){
            
        }

        return results;
    }
    public static void main(String args[]){
        
    }
}
