class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //this is special because we dont need duplicates
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(result,new ArrayList<>(),nums,0);
        return result;
        
    }

    public void backtracking(List<List<Integer>> result,List<Integer> temp,int[] nums,int start){

//remove duplicates 
if(result.contains(temp)){
    return;
}

result.add(new ArrayList<>(temp));

for(int i =start;i<nums.length;i++){
    temp.add(nums[i]);

    backtracking(result,temp,nums,i+1); //avoids duplicates

    temp.remove(temp.size()-1);
}

    }
}
