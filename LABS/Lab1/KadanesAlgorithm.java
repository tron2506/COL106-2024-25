public class KadanesAlgorithm{
    public static int findMaxSubarraySum(int[] arr){
        int maxsum=0;
        int currmaxsum=0;
        for(int i=0;i<arr.length;i++){
            currmaxsum= (currmaxsum < 0) ? arr[i] : currmaxsum+arr[i];
            maxsum= (maxsum<currmaxsum) ? currmaxsum : maxsum;
        }
        return maxsum;
    }
    public static void main(String args[]){

        int[] arr={2,3,-8,7,-1,2,3};
        
        System.out.println(findMaxSubarraySum(arr));
    }
}