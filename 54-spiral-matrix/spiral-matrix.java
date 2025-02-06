class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top=0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        int count = (bottom+1)*(right+1);
        int dir = 1;
        List<Integer> result = new ArrayList();
        while((left<=right) && (top<=bottom)){
            if(count>0){
                if(dir==1){
                    for(int i =left;i<=right;i++){
                        result.add(matrix[top][i]);
                        count--;
                    }
                    top++;
                    dir=2;
                }
            }
            if(count>0){
                if(dir==2){
                    for(int i = top;i<=bottom;i++){
                        result.add(matrix[i][right]);
                        count--;
                    }
                    right--;
                    dir=3;
                }
            }
            if(count>0){
                if(dir==3){
                    for(int i = right;i>=left;i--){
                        result.add(matrix[bottom][i]);
                        count--;
                    }
                    bottom--;
                    dir=4;
                }
            }
            if(count>0){
                if(dir==4){
                    for(int i = bottom;i>=top;i--){
                        result.add(matrix[i][left]);
                        count--;
                    }
                    left++;
                    dir=1;
                }
            }
        }
        return result;
    }
}