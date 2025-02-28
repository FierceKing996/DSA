class Solution {
    public int maxelement(int[][] mat,int mid){
        int row = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<mat.length;i++){
            max = Math.max(mat[i][mid],max);
            if(max==mat[i][mid]){
                row = i;
            }
        }
        return row;
    }
    public int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length-1;
        while(low<=high){
            int mid = (low+high)/2;
            int row = maxelement(mat,mid);
            int left = mid -1 >=0 ? mat[row][mid-1] : -1;
            int right = mid + 1 < (mat[0].length) ? mat[row][mid+1] : -1;
            if(mat[row][mid]>left && mat[row][mid]>right){
                return new int[]{row,mid};
            } else if(mat[row][mid]<left){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}