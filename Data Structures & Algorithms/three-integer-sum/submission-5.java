class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null||nums.length<3){   //dont put 0,put null.Also check for null first.If u dont, it will cause error
            return new ArrayList<>();
        }

        Arrays.sort(nums);
     Set <List<Integer>> result = new HashSet<>(); //it avoids duplicate values


        for(int i=0;i<nums.length-2;i++){
            int left = i+1; //we will fix the starting number
            int right = nums.length-1;

            while(left<right){
                int sum=nums[i] + nums[left] + nums[right];

              if(sum==0){
                result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
               }
               else if(sum<0){
                left++;
               }
               else{
                right--;
               }



            }
        }
        return new ArrayList<>(result);
        
    }
}
