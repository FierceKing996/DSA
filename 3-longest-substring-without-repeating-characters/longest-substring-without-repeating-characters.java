class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0;
        int maxlen = 0;
        int len =0;
        Map<Character,Integer> map = new HashMap<>();
        for(int r =0;r<s.length();r++){
            if(!map.containsKey(s.charAt(r))){
                len = r-l+1;
                maxlen=Math.max(len,maxlen);
            }else{
                l = Math.max(map.get(s.charAt(r)) + 1, l);
                len = r-l+1;
                maxlen=Math.max(len,maxlen);
            }
            map.put(s.charAt(r),r);
        }
        return maxlen;
    }
}