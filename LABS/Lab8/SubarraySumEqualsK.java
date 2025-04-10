import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        int sublen=0; 
        int count=0;
        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);
            if(map.containsKey(ch)){
                sublen = sublen < count ? count : sublen;
                map.remove(ch);
                count=count-1; //the length of current substring without repetition
            }
            count++;
            map.put(ch, i);
        }
        if(!map.isEmpty()){
            sublen = sublen < map.get(s.charAt(s.length()-1)) ? map.get(s.charAt(s.length()-1)) : sublen;
        }
        return sublen;
    }
}