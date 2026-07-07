class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res,new ArrayList<>(),nums);
    return res;}
    public void backtracking(List<List<Integer>> res ,List<Integer> temp,int[] nums){
 //if nums.length then its permutation
          if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
          }
        for(int num: nums){
            if (temp.contains(num)){
                continue;    //skip duplicates
            }

            temp.add(num);
            backtracking(res,temp,nums);
            temp.remove(temp.size()-1);
        }
    }
}
