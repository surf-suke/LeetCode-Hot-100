package Matrix;

public class Hot20 {
    public void rotate(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        if(row!=col)
            return;
        horizontalFlip(matrix);
        antidiagonalFlip(matrix);
    }
    public void horizontalFlip(int[][] matrix){
        int row= matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][col-1-j];
                matrix[i][col-1-j]=temp;
            }
        }
    }
    public void antidiagonalFlip(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col-i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[col-1-j][row-1-i];
                matrix[col-1-j][row-1-i]=temp;
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        new Hot20().rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
