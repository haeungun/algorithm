/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 */
 
import java.util.*;

public class PacificAtlantic {
  // solution 1: dfs
	public static void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
		if (visited[i][j]) return;
		
		visited[i][j] = true;
		
		int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // up, down, left, right
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			
			if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] >= matrix[i][j]) {
				dfs(matrix, x, y, visited);
			}
		}
		
	}
  
  // solution 2: bfs 
  public static void bfs(Queue<int[]> queue, int[][] matrix, boolean[][] visited) {
		 int m = matrix.length;
		 int n = matrix[0].length;
		 
		 int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};  // up, down, left, right
		 while (!queue.isEmpty()) {
		   	int[] coor = queue.poll();
		   	int i = coor[0];
		   	int j = coor[1];

	   		System.out.println(Arrays.toString(coor));
		   	for (int[] dir : dirs) {
		   		int x = i + dir[0];
		   		int y = j + dir[1];
		   		if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] >= matrix[i][j] && !visited[x][y]) {
		   			visited[x][y] = true;
		   			queue.add(new int[] {x, y});
		   		}
		   	}
		 }
			
	}
	
	public static List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> ret = new ArrayList<>();
        
    if (matrix.length < 1) return ret;
        
    int m = matrix.length;
    int n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        
        for (int i = 0; i < m; i++) {
        	dfs(matrix, i, 0, pacific);
        	dfs(matrix, i, n - 1, atlantic);        	
        }
        
        for (int i = 0; i < n; i++) {
        	dfs(matrix, 0, i, pacific);
        	dfs(matrix, m - 1, i, atlantic);  
        }
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (pacific[i][j] && atlantic[i][j]) ret.add(new int[] {i, j});
        	}
        }
        
        return ret;
    }
}
