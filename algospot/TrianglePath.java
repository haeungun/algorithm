/**
 * https://algospot.com/judge/problem/read/TRIANGLEPATH
 */

import java.util.*;

public class Main {
	
	public static int trianglePath(int[][] triangle) {
		int n = triangle.length;
		int[] path = new int[n];
		
		for (int i = 0; i < n; i++) path[i] = triangle[n - 1][i];
		
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				path[j] = Math.max(path[j], path[j + 1]) + triangle[i][j];
			}
		}
		
		return path[0];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numsOfTestCase = scan.nextInt();
		int[] results = new int[numsOfTestCase];
		
		for (int i = 0; i < numsOfTestCase; i++) {
			int triangleSize = scan.nextInt();
			int[][] triangle = new int[triangleSize][triangleSize];

			int count = 0;
			for (int j = 0; j < triangleSize; j++) {
				for (int k = 0; k <= count; k++) {
					triangle[j][k] = scan.nextInt();
				}
				count++;
			}
			
			results[i] = trianglePath(triangle);
		}

		for (int i = 0; i < numsOfTestCase; i++) System.out.println(results[i]);
		scan.close();
	}
}
