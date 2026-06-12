class Solution {
    public int findDuplicate(int[] nums) {
    
       int fast = 0;
       int slow = 0;

       do{
         slow = nums[slow];
         fast = nums[nums[fast]];

       }while(slow!=fast);  //fast and slow at the same position



   slow=0; //bring back slow to index 0;So slow and fast can meet at the list cycle start point  by taking single step 
       while(slow!=fast){
          slow = nums[slow];
          fast = nums[fast];
       }

          return slow;
    }
}
