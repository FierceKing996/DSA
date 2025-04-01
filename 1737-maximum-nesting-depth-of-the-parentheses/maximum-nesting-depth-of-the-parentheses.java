class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int size = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(c);
                size = Math.max(size,stack.size());
            }else if(c==')'){
                stack.pop();
            }
        }
        return size;
    }
}