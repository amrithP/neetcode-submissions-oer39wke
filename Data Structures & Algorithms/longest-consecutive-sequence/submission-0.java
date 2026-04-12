class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength=0;
        Map<Integer,Boolean> map = new HashMap<>();
        for(int num:nums){
            map.put(num,Boolean.FALSE);
        }

        for(int num:nums){
            int currentLength=1;
           

           //checking for next value
          int   nextNum=num+1;//store the next val
            while(map.containsKey(nextNum) && map.get(nextNum)==false){
                currentLength++;
                map.put(nextNum,Boolean.TRUE);
                nextNum++;
            }


            //checking for previous value
           int prevNum=num-1;
            while(map.containsKey(prevNum)&& map.get(prevNum)==false){
                currentLength++;
                map.put(prevNum,Boolean.TRUE);
                prevNum--;
            }
           longestLength=Math.max(longestLength,currentLength);

        }
        return longestLength;
    }
}
