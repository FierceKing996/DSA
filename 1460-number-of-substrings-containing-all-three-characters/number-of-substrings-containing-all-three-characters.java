class Solution {
    public int numberOfSubstrings(String s) {
        int l =0;
        int count =0;
        
        int[] hash = new int[3];
        for(int r =0;r<s.length();r++){
            hash[s.charAt(r) - 'a']++;
            while(hash[0]>0&&hash[1]>0&&hash[2]>0){
                count += s.length() - r;
                hash[s.charAt(l) - 'a']--;
                l++;
                
            }
        }
        
        return count;
    }
}