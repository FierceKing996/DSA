class Solution {
    public int finddays(int[] weights,int mid){
        int days = 1;
        int load = 0;
        for(int i=0;i<weights.length;i++){
            if(load + weights[i]>mid){
                days+=1;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        for(int weight : weights){
            low = Math.max(low,weight);
        }
        int high = 0;
        for(int weight : weights){
            high += weight;
        }
         while(low<=high){
            int mid = (low+high)/2;
            int noofd = finddays(weights,mid);
            if(noofd<=days){
                high = mid-1;
            }else{
                low=mid+1;
            }
         }
         return low;
    }
}