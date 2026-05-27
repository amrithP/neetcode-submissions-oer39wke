class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        if(n<1){
            return 0;
        }
    
    int [] dp = new int[amount+1];
    dp[0] =0;

    for(int i=1;i<=amount;i++){
        dp[i] = Integer.MAX_VALUE; //assume non existent 

//coin choice is coin. amount to be made is i(index of dp)
        for(int coin:coins){
          if(coin<=i && dp[i-coin]!=Integer.MAX_VALUE){
            dp[i] = Math.min(dp[i],1+dp[i-coin]);
          }
        }
        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }

        
    }
return dp[amount];
        
    }
}
