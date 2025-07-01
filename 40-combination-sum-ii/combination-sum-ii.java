class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates==null || candidates.length==0){
            return result;
        }
        Arrays.sort(candidates);
        backtrack(result,new ArrayList<>(),candidates,target,0);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> curr,int[] candidates, int target,int index){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target<0 || index==candidates.length){
            return;
        }
        curr.add(candidates[index]);
        backtrack(result,curr,candidates,target-candidates[index],index+1);
        curr.remove(curr.size()-1);
        int next = index+1;
        while(next<candidates.length && candidates[next]==candidates[index]){
            next++;
        }
        backtrack(result,curr,candidates,target,next);
    }
}