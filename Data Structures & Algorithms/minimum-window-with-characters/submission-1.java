class Solution {
    public String minWindow(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];

//filling the mapT
        for(char ch:t.toCharArray()){
            mapT[ch]++;
        }
        int left=0; int minLen = Integer.MAX_VALUE; int minStart=0;

        for(int right=0;right<s.length();right++){
            mapS[s.charAt(right)]++;
        
        while(contains(mapS,mapT)){
            if(right-left+1<minLen){
                minLen=right-left+1;
                minStart=left;
            }
           
            mapS[s.charAt(left)]--;
             left++;  //or write the 2 lines of code and simplify it as mapS[s.charAt(left++)]--;
        }
        }

        return minLen==Integer.MAX_VALUE?"":s.substring(minStart, minStart+minLen);
        // it means u have not taken minLen,as it is same as its old value so return ""
    }


    public boolean contains(int[]mapS,int[]mapT){
        for(int i=0;i<256;i++){
            if(mapS[i]<mapT[i])
            return false;
        }
        return true;
    }
}
