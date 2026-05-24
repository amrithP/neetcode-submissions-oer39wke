class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return n;
        }

//store in array(memoization)
        int[] dp = new int[n+1]; //start from 0 to n.
        dp[1]=1; //1 way for one step
        dp[2] =2; //2 ways for two steps. a. 1+1 b.2

        //if u wanna reach 7. start from 6(1 step) or start from 5(2 steps)

        for(int i =3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

  return dp[n];   //tc  and sc are  o(n) 
        
    }
}
