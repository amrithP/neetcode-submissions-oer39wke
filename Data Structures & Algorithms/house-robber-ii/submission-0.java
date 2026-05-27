class Solution {
    public int rob(int[] nums) {
        //take 2 arrays. One without first element and the other without the last
    int n = nums.length;

    if(n<2){
        return nums[0];
    }

    int [] skipFirst = new int [n-1];
    int [] skipLast = new int[n-1];

    for(int i=0;i<n-1;i++){
        skipFirst[i] = nums[i+1];
        skipLast[i] = nums[i];
    }

    int First = helpRob(skipFirst);
    int Last = helpRob(skipLast);

    return Math.max(First,Last);
        
    }

   public  int helpRob(int [] arr){
        int n = arr.length;
        if(n<2){
            return arr[0];
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);

        for(int i=2;i<n;i++){
            dp[i]= Math.max(arr[i]+dp[i-2],dp[i-1]);
        }

        return dp[n-1];
    }
}
