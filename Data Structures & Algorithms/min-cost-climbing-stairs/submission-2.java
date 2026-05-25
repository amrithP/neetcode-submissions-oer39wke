class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n+1];  //includes 0 but top also.Reach panrathukaana cost
        dp[0]=0; //min cost to reach 0 is O
        dp[1] = 0; //min cost to reach 1 is 1.
        //as we can start from either the bottommost or the 2nd bottommost

        for(int i=2;i<=n;i++){
            dp[i] = Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
        }
return dp[n];  //tc and sc o(n)
        
    }
}
