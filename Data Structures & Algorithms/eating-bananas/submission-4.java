class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1; //per hour
        int maxSpeed = 0;
        for(int pile:piles){
            maxSpeed = Math.max(maxSpeed,pile);
        }

        while(minSpeed<maxSpeed){  // dont put minSpeed <= maxSpeed as when equal they wont get out of the loop so they might run forever 
            int mid = minSpeed + (maxSpeed - minSpeed)/2;

                if(cantEatInTime(piles,h,mid)){
                    maxSpeed = mid; //we dont put mid-1 becuase mid can itself be the answer
                }
                else{
                    minSpeed = mid+1;
                }
        }

        return minSpeed; //at this point both minspeed and maxSpeed are equal

    }
           public static boolean cantEatInTime(int[] piles,int h,int mid){
            int hours =0;
            for(int pile:piles){
            hours+= (int)  Math.ceil((double)pile/mid);}

            return hours <= h;  //theres a possibility for a lesser mid
           }

}    // tc is o(nlogn) and sc is o(1)
