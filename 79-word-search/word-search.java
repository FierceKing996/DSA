class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Try to start DFS from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, int row, int col, int index){
        if(index==word.length()){
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
            || board[row][col] != word.charAt(index)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (backtrack(board, word, newRow, newCol, index + 1)) {
                return true;
            }
        }
        board[row][col] = temp;

        return false;
    }
}