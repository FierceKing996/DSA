class Solution {
    public int hours(int[] piles, int mid){
        int totalhour = 0;
        for(int i=0;i<piles.length;i++){
            totalhour += Math.ceil((double)piles[i]/mid);
        }
        return totalhour;
    }
    public int minEatingSpeed(int[] piles, int h) {
       int low = 1;
       int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
       while(low<=high){
          int mid = (low+high)/2;
          int totalhours = hours(piles, mid );
          if(totalhours<=h){
            high = mid-1;
          }else{
            low = mid+1;
          }
       }
       return low;
    }
}