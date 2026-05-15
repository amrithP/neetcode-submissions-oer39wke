class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            if(isOperation(token)){
                int b = stack.pop(); //second element
                int a = stack.pop(); //first Element 
                int result = doOperation(token,a,b);
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(token)); //convert and keep
            }
        }
        return stack.pop();
    }
   private boolean isOperation(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    } //only for char use '', for string use "" even if its a single letter
   private int doOperation(String token,int a,int b){
        switch(token){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: return 0;   //this is important 
        }
    
    }
}
