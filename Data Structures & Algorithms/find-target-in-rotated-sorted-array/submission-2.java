class Solution {
    public int search(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;

          while(left <=right){
            int mid = left + (right-left)/2 ;

            if(nums[mid]== target){
                return mid;
            }

            if(nums[left] <= nums[mid]){ //left subpart

            if(target >= nums[left] && target < nums[mid]){ //target in the part
                right = mid-1;
            }else{   //target not in the part

            left = mid+1;
  
            }

            }
            else{  //right subpart

            if(target>nums[mid] && target <= nums[right]){  // target in the part
                         left = mid+1;
            }else{
                right = mid-1;
            }

            }
      
            }
            return -1;
}
}
