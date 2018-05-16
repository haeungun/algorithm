/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 */


class NumMatrix {
	int[][] matrix;
	
	public NumMatrix(int[][] matrix) {
		int N = matrix.length;
        	int M = matrix[0].length;
        
        	this.matrix = new int[N][M];
        	for (int i = 0; i < N; i++) {
            		for (int j = 0; j < M; j++) {
                		if (j == 0) {
                    			this.matrix[i][0] = matrix[i][0];
                		} else {
                    			this.matrix[i][j] = this.matrix[i][j - 1] + matrix[i][j];
                		}
            		}
        	}
    	}
    
	public int sumRegion(int row1, int col1, int row2, int col2) {
    		if (row1 > row2 || col1 > col2) return 0;
        
    		int sum = 0;
    		for (int i = row1; i <= row2; i++) {
    			sum += this.matrix[i][col2];
    		}
        
        	if (col1 > 0) {
        		for (int i = row1; i <= row2; i++) {
        			sum -= this.matrix[i][col1 - 1];
        		}
        	}
        	return sum;
	}
}
