class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); //it will avoid checking the sum for values once the sum becomes greater than the target
        backtracking(result,new ArrayList<>(),candidates,target,0);
        return result;
    }

    public void backtracking(List<List<Integer>> result, List<Integer> temp,int[] candidates,int target,int start){
      
  if(target == 0){
    result.add(new ArrayList<>(temp));
  }

  for(int i = start;i<candidates.length;i++){

            //skip duplicates  [1,2,2,3,4]  2 is checked only once. Other 2 is skipped and moved on to 3 directly 
       if(i>start && candidates[i] == candidates[i-1]){
           continue;
       }

       if(target-candidates[i]<0){
        break;
       }

       temp.add(candidates[i]);
       backtracking(result,temp,candidates,target-candidates[i],i+1);//i+1 because no duplicates 
       temp.remove(temp.size()-1);

  }



    }
}
