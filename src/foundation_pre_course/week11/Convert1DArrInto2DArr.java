package foundation_pre_course.week11;

public class Convert1DArrInto2DArr {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m*n){
            return new int[0][0];
        }
        int[][] arr = new int[m][n];
        int current_index = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = original[current_index];
                current_index++;
            }
        }
        return arr;
    }

}
