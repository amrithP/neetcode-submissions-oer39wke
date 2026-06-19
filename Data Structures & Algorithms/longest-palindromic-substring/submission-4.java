class Solution {
    public String longestPalindrome(String s) {

        if(s==null || s.length()<1){
            return "";
        }
         int left =0; int right =0;
        for(int i = 0;i<s.length();i++){
            int len1 = checkPalindrome(s,i,i); //single middle for odd
            int len2 = checkPalindrome(s,i,i+1); //2 middle for even
            int len = Math.max(len1,len2);

            if(len>right-left){  //if pallindrome length comes out  greater thsn the prev one
         //so fix the left and right  for the substring part

         left = i - (len-1)/2;
         right = i + len/2;



            }
        }
        return s.substring(left,right+1); //add 1 so that the right index char is included in substring
    }

    public int checkPalindrome(String s,int left,int right ){

        int L = left;
        int R = right;
//expansion takes place here 
        while(L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;  //WE WENT EXTRA SO reduce by 1.TC is n^2 and SC is n
    }
}
