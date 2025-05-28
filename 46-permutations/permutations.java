class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(nums,0,result);
        return result;
    }
    public void recursion(int[] nums, int index,List<List<Integer>> result){
        if(index==nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int x : nums) temp.add(x);
            result.add(temp);
        }
        for(int i = index;i<nums.length;i++){
            swap(nums , index ,i);
            recursion(nums,index+1,result);
            swap(nums,index ,i) ;
        }
    }
    public void swap(int[] nums , int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}