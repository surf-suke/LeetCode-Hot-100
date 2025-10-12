package Matrix;
import java.util.*;

public class Hot19 {
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[] isRowAccessible = new boolean[matrix.length];
        boolean[] isColAccessible = new boolean[matrix[0].length];
        Arrays.fill(isRowAccessible, true);
        Arrays.fill(isColAccessible, true);
        List<Integer> result = new ArrayList<>();
        int totalElements = matrix.length * matrix[0].length;
        int row = 0, col = 0;
        int direction = 0; // 0:right, 1:down, 2:left, 3:up
        while (result.size() < totalElements) {
            result.add(matrix[row][col]);
            if (direction == 0) { // moving right
                if (col + 1 < matrix[0].length && isColAccessible[col + 1] && isRowAccessible[row]) {
                    col++;
                } else {
                    isRowAccessible[row] = false;
                    direction = 1; // change direction to down
                    row++;   //move down
                }
            } else if (direction == 1) {
                if (row + 1 < matrix.length && isColAccessible[col] && isRowAccessible[row + 1]) {
                    row++;
                } else {
                    isColAccessible[col] = false;
                    direction = 2; //change direction to left
                    col--;
                }
            } else if (direction == 2) {
                if (col - 1 >= 0 && isColAccessible[col - 1] && isRowAccessible[row]) {
                    col--;
                } else {
                    isRowAccessible[row] = false;
                    direction = 3; //change direction to up
                    row--;
                }
            } else {
                if (row - 1 >= 0 && isColAccessible[col] && isRowAccessible[row - 1]) {
                    row--;
                } else {
                    isColAccessible[col] = false;
                    direction = 0; //change direction to right
                    col++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Hot19 hot19 = new Hot19();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(hot19.spiralOrder(matrix)); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
