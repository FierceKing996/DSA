class Solution {
    public int totalFruit(int[] fruits) {
        int l =0;
        int maxlen =0;
        int count=0;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int r =0;r<fruits.length;r++){
            if(!freq.containsKey(fruits[r])){
                if(freq.size()<2){
                    freq.put(fruits[r],1);
                    maxlen = Math.max(maxlen,r-l+1);
                }else{
                    while(freq.size()!=1){
                        freq.put(fruits[l],freq.get(fruits[l])-1);
                        if(freq.get(fruits[l])==0){
                            freq.remove(fruits[l]);
                        }
                        l++;
                    }
                    freq.put(fruits[r],1);
                }
            }else{
                freq.put(fruits[r],freq.get(fruits[r])+1);
                maxlen = Math.max(maxlen,r-l+1);
            }
        }
        return maxlen;
    }
}