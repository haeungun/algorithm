/**
 * 출처: https://leetcode.com/problems/number-of-islands/description/
 */

class Solution {
    
    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
        
        while (!queue.isEmpty()) {
            int[] coor = queue.poll();
            
            for (int[] dir : dirs) {
                int x = coor[0] + dir[0];
                int y = coor[1] + dir[1];
                
                if (x < n && y < m && x >= 0 && y >= 0) {
                    if (grid[x][y] == '1') {
                        queue.add(new int[] {x, y});
                        grid[x][y] = '2';
                    }
                }
            }
        }
        
    }
    
    public int numIslands(char[][] grid) {
        int N = grid.length;
        
        if (N < 1) return 0;
        
        int M = grid[0].length;
        
        int numOfIslands = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    numOfIslands++;
                }
            }
        }
        
        return numOfIslands;
    }
}
