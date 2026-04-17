class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start =0;
        int maxLength = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(int end=0;end<s.length();end++){
            char curr = s.charAt(end);

            if(map.containsKey(curr)){
                start=Math.max(start,map.get(curr)+1);
            }
            map.put(curr,end);
            maxLength=Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
}
