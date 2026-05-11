class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //input array is already sorted.That is why we are using two pointer method
        int left =0;
        int right=numbers.length-1;

        while(left<right){
            //3 cases
            int currSum=numbers[left]+numbers[right];
            if(currSum>target){
                right--;
            }
            else if(currSum<target){
                left++;
            }
            else{
                return new int[]{left+1,right+1};
            }
        }
        return new int[]{};
    }
}
