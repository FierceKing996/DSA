class Solution {
    public int lessthanequaltogoal(int[] nums,int goal){
        if(goal<0)return 0;
        int l=0;
        int sum=0;
        int count=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            count = count + (r-l+1);
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return lessthanequaltogoal(nums,goal)-lessthanequaltogoal(nums,goal-1);
    }
}