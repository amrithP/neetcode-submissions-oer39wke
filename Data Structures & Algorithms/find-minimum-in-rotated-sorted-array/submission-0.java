class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        while(left<right){  //when left and right point to the same element , i need to get out and return answer
             
             int mid = left + (right-left)/2;

             if(nums[mid]>nums[right]){
                left = mid+1;
             }
             else{
                right = mid;  //this may be the ans
             }


        }
        return  nums[left]; // when left and right are same
    }
}
