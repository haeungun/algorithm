/**
 * 출차: https://leetcode.com/problems/max-area-of-island/
 */

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    int area = bfs(grid, i, j);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }
    
    private int bfs(int[][] grid, int a, int b) {
        int area = 1;
        
        Queue<int[]> coordinates = new LinkedList<>();
        coordinates.add(new int[]{a, b});
        
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        while (coordinates.size() > 0) {
            int[] coor = coordinates.poll();
            
            for (int[] dir : dirs) {
                int x = coor[0] + dir[0];
                int y = coor[1] + dir[1];
                
                if (x >= 0 && x < grid.length &&
                   y >= 0 && y < grid[0].length) {
                    if (grid[x][y] > 0) {
                        grid[x][y] = -1;
                        coordinates.add(new int[]{x, y});
                        area++;
                    }
                }
            }
        }
        
        return area;
    }
}
