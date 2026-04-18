class Solution {
    public int characterReplacement(String s, int k) {
        int left =0;
        int maxFreq=0;
        int maxWindow=0;
        int[] freq = new int[26];

        for(int right=0;right<s.length();right++){
            //set the frequency for the respective char
            freq[s.charAt(right)-'A']++;
              
              maxFreq=Math.max(maxFreq,freq[s.charAt(right)-'A']);
              int windowLength=right-left+1;
  
  //windowLength-maxFreq is no of times char to be replaced
              if((windowLength-maxFreq)>k){
                freq[s.charAt(left)-'A']--;  //in table change the value
                  left++; //move the left pointer
              }

       windowLength=right-left+1;
       maxWindow=Math.max(windowLength,maxWindow);

         
        }
        return maxWindow;
    }
}
