class Solution {
    public void reversearray(int[] nums, int start, int end){
        while (start < end) {
            
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length ;
        int index = -1;
        for(int i = n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        System.out.println(index);
        if(index==-1){
            reversearray(nums,0,nums.length-1);
        }
        else{
        for(int i = n-1;i>index ; i--){
            if(nums[i]>nums[index]){
                int temp = nums[index];

                nums[index] = nums[i];
                
                nums[i] = temp;
                
                break;
            }
        }
        
        reversearray(nums,index+1,nums.length-1);
        }
    }
}