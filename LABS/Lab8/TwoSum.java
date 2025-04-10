import java.util.HashMap;
public class TwoSum {
    public static int twoSum(int[] nums, int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            int complement=k-nums[i];
            
            if(map.containsKey(complement)){
                if(map.get(complement)<i){
                    count++;
                }
            }

            map.put(nums[i],i);

        }
        return count;
    }
    public static void main(String args[]){

        int[] nums={-5, -3, -1, 2, 4, 6};
        int target=1;
        System.out.println(twoSum(nums, target));
    }
}
