package Matrix;

public class Hot21 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = 0;
        int c = cols - 1; // 从右上角开始

        while (r < rows && c >= 0) {
            int val = matrix[r][c];
            if (val == target) return true;
            if (val > target) {
                c--; // 当前值太大，列左移
            } else {
                r++; // 当前值太小，行下移
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}
        };
        int target = 5;
        boolean result = new Hot21().searchMatrix(matrix, target);
        System.out.println("Target found: " + result);
    }
}