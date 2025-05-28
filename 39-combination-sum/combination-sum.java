class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,candidates,target,0,0,new ArrayList<>());
        return result;
    }
    public void backtrack(List<List<Integer>> result,int[] candidates, int target , int index , int sum, List<Integer> temp){
        if(sum==target){
            result.add(new ArrayList<>(temp));
            return;
        }  
        if(sum>target) return;
        for(int i = index; i<candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(result,candidates,target,i,sum+candidates[i],temp);
            temp.remove(temp.size()-1);
        }
    }
}