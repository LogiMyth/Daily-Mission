// optimal approach
class rotatematrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // int m = matrix[0].length;
       for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
        }
       } 
       for(int i = 0; i < n; i++){
       int left = 0;
       int right = matrix[0].length - 1;
       while(left < right){
        int temp = matrix[i][left];
        matrix[i][left] = matrix[i][right];
        matrix[i][right] = temp;

        left++;
        right--;
       }}
    }
    
}
