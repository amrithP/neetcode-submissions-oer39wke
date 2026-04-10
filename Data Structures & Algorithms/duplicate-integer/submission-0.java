class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<>(); //does not have duplicate values
        //O(n)

        for(int num:nums){
            if(hash.contains(num)){
                return true;
            }
           hash.add(num);
        }

        return false;
    }
}