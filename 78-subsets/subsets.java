class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(nums,0,new ArrayList<>() , result);
        return result;
    }
    public void generate(int[] nums, int index, List<Integer> current, List<List<Integer>> result){
         if(index==nums.length){
            result.add(new ArrayList<>(current));
            return;
         }
         generate(nums,index+1,current,result);
         current.add(nums[index]);
         generate(nums, index + 1, current, result);
         current.remove(current.size() - 1);
    }
}