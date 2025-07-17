class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0,s,new ArrayList(),result);
        return result;
    }
    public void backtrack(int start,String s,List<String> path,List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int end = start ; end < s.length() ; end++){
            String subs = s.substring(start,end+1);
            if(palindrome(subs)){
                path.add(subs);
                backtrack(end+1,s,path,result);
                path.remove(path.size()-1);
            }
        } 
    }
    public boolean palindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}