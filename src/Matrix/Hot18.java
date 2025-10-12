package Matrix;

public class Hot18 {
    public void setZeros(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (cols == 0) return;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 检查第一行是否有 0
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // 检查第一列是否有 0
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // 使用第一行和第一列作为标记
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据标记置零（跳过第一行和第一列）
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第一行
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) matrix[0][j] = 0;
        }

        // 处理第一列
        if (firstColZero) {
            for (int i = 0; i < rows; i++) matrix[i][0] = 0;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        new Hot18().setZeros(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}