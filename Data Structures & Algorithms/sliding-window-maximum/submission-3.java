class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
//step 1:Initialize
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n-k+1];

//step 2:WINDOW
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        result[0]=nums[deque.peekFirst()];

        
        for(int i=k;i<n;i++){
            //remove the element from the window that has slipped out
            if(deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
             while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
             }
             deque.offerLast(i); 

             result[i-k+1]=nums[deque.peekFirst()];
        }
        return result;
    }
}                         //tc o(n) becuase one insertion and at most one removal, whih is 2n but still n 
                       //sc is o(k). deque can atmost store k elements.
