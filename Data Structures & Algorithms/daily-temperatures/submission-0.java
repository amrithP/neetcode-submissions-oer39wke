class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for(int index=n-1;index>=0;index--){

            while(!stack.isEmpty() && temperatures[index]>= temperatures[stack.peek()]){
                stack.pop();
            }   // the reason im using while instead of if ,is because it can pop not just one but many 


             if(!stack.isEmpty()){
                result[index]= stack.peek()-index;
            }





            stack.push(index);
        }
        return result;
    }
}
