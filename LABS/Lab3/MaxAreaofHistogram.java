import java.util.*;

public class MaxAreaofHistogram {
    public int[] nextSmaller(int[] hist){
        int n=hist.length;
        int[] nextS=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){nextS[i]=-1;}
        for(int i=0;i<n;i++){
            while(!st.isEmpty()  && hist[i] < hist[st.peek()]){
                nextS[st.pop()]=hist[i];
            }
            st.push(i);
        }
        return nextS;
    }
    public int[] nextSmaller1(int[] hist){
        int n=hist.length;
        int[] nextS=new int[n];
        for(int i=0;i<n;i++){nextS[i]=-1;}
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && hist[i] < hist[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                nextS[i]=hist[st.peek()];
            }
            st.push(i);
        }
        return nextS;
    }
    public int[] nextGreater(int[] hist){
        int n=hist.length;
        int[] nextG=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){nextG[i]=-1;}
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && hist[i] > hist[st.peek()]){
                nextG[st.pop()]=hist[i];
            }
            st.push(i);
        }
        return nextG;
    }
    public int[] nextGreater1(int[] hist){
        int n=hist.length;
        int[] nextG=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){nextG[i]=-1;}
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && hist[i] > hist[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                nextG[i]=hist[st.peek()];
            }
            st.push(i);
        }
        return nextG;
    }
    public int[] prevSmaller(int[] hist){
        int n=hist.length;
        int[] prevS=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){prevS[i]=-1;}
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && hist[i] > hist[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                prevS[i]=hist[st.peek()];
            }
            st.push(i);
        }
        return prevS;
    }
    public int[] prevSmaller1(int[] hist){

    }
    public int getMaxArea(int[] hist){
        // try using nextsmaller algo and prev smaller element of an element in the stack is the element just below it in the stack.
        int n=hist.length;
        int maxarea=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && hist[i] <= hist[st.peek()]){
                int tempele=st.pop(); //element at ith index is the next smaller element for this popped element;
                int width= st.isEmpty() ? i : (i-st.peek()-1);
                maxarea = Math.max(maxarea, hist[tempele]*width);
            }


            st.push(i);
        }
        while(!st.isEmpty()){
            int tempele=st.pop();
            int width=st.isEmpty() ? n : n-st.peek()-1;
            maxarea=Math.max(maxarea,hist[tempele]*width);
        }

        return maxarea;
    }
    public static void main(String args[]){

        MaxAreaofHistogram ugh=new MaxAreaofHistogram();

        int hist[]={2,1,5,6,2,3};
        for(int x:ugh.nextGreater1(hist)){
            System.out.print(x+ " ");
        }
    }
}
