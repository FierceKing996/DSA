class Solution {
    private static final String[] KEYS = {
        "",    // 0
        "",    // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs",// 7
        "tuv", // 8
        "wxyz" // 9
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        if(digits.isEmpty() || digits == null) return result;
        backtrack(0,digits,path,result);
        return result;
    }
    public void backtrack(int index,String digits,StringBuilder path,List<String> result){
        if(index == digits.length()){
            result.add(path.toString());
            return ;
        }
        int digit = digits.charAt(index) - '0';
        String letters = KEYS[digit];
        
        for (char ch : letters.toCharArray()) {
            path.append(ch);                    
            backtrack(index + 1, digits, path, result);
            path.deleteCharAt(path.length() - 1); 
        }
    }
}