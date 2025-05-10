class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] cols = new int[n];
        // Initialize columns as 0,1,2,...,n-1
        for (int i = 0; i < n; i++) cols[i] = i;
        permuteAndCheck(cols, 0, solutions, n);
        return solutions;
    }
    private void permuteAndCheck(int[] cols, int start, List<List<String>> solutions, int n) {
        if (start == n) {
            if (isValid(cols)) {
                solutions.add(buildBoard(cols));
            }
            return;
        }
        for (int i = start; i < n; i++) {
            swap(cols, start, i);
            permuteAndCheck(cols, start + 1, solutions, n);
            swap(cols, start, i);
        }
    }

    private boolean isValid(int[] cols) {
        int n = cols.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check diagonal: if rowDiff == colDiff
                if (Math.abs(i - j) == Math.abs(cols[i] - cols[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }

    private List<String> buildBoard(int[] cols) {
        int n = cols.length;
        List<String> board = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[cols[r]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}