class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];

        //initializing buckets ,give arraylist
        for(int i=0;i<bucket.length;i++){
            bucket[i]=new ArrayList<>();
        }

        //filling hashmap
        for(int n:nums){
            count.put(n,count.getOrDefault(n,0)+1);
        }
        //filling buckets
        for(Map.Entry<Integer,Integer> entry :count.entrySet()){
               bucket[entry.getValue()].add(entry.getKey());
        }
        //traversing bucket from the end and adding it in array
        int[]res= new int[k];
        int index=0;

        for(int i=bucket.length-1;i>0&&index<k;i--){
            for(int b:bucket[i]){
                res[index++]=b;
                if(index==k){
                    return res;
                }
            }

        }
     //return new int[]{};
     //or
     return res;
    }
}
