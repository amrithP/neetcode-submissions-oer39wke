class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res,new ArrayList<>(),nums,target,0); //0 is the start
        return res;
        
    }
    public void  backtracking(List<List<Integer>> res,List<Integer> temp,int[] nums,int target,int start){

        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        else if(target<0){
            return;
        }

        //no need to add every element like subsets problem
        for(int i = start;i<nums.length;i++){

            //add
            temp.add(nums[i]);

            backtracking(res,temp,nums,target-nums[i],i); //start can remain the same as it can be reused.

            temp.remove(temp.size()-1);
        }
    }
}
