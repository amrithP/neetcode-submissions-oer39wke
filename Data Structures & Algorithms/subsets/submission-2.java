class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List <List<Integer>> resultSet = new ArrayList<>();
        
        backtracking(resultSet,new ArrayList<>(),nums,0); //new ArrayList<>() is the empty {} that we start with. 0 represents start

        return resultSet;
        
    }

    public void backtracking(List<List<Integer>> resultSet, List<Integer> temp,int[] nums,int start){

//adding every element . this is not req in combination sums
        resultSet.add(new ArrayList<>(temp)); //include the {} first and later on...

        for(int i=start;i<nums.length;i++){

            //add the number 
            temp.add(nums[i]);

            //backtrack to check for a not taking the number option
            backtracking(resultSet,temp,nums,i+1);

            //remove the number for not taking the number option
            temp.remove(temp.size()-1);
        }
    }
}
