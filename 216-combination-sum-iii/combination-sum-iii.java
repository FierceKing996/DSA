class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        backprune(1,k,n,new ArrayList<>(),results);
        return results;
    }
    public void backprune(int start,int remainingk , int remainingsum,List<Integer> path, List<List<Integer>> results){
        if(remainingk ==0 && remainingsum==0){
            results.add(new ArrayList<>(path));
            return;
        }
        if(remainingk<0 && remainingsum<0){
            return;
        }
        for(int num = start; num<=9;num++){
            path.add(num);
            backprune(num+1,remainingk - 1,remainingsum - num,path,results);
            path.remove(path.size()-1);
        }
    }
}