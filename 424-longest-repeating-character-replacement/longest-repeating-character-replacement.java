class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int maxlen=0;
        int maxfreq=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int r=0;r<s.length();r++){
            if(!map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),1);
                maxfreq=Math.max(maxfreq,map.get(s.charAt(r)));
            }else{
                map.put(s.charAt(r),map.get(s.charAt(r))+1);
                maxfreq=Math.max(maxfreq,map.get(s.charAt(r)));
            }
            if((r-l+1)-maxfreq>k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}