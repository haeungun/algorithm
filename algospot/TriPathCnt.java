/**
 * https://algospot.com/judge/problem/read/TRIPATHCNT
 */

import java.util.*;

public class Main {

	public static int triPathCnt(int[][] triangle) {
		int N = triangle.length;
		
		int maxCount = 0;
		int maxVal = Integer.MIN_VALUE;
		
		int[][] sums = new int[N][N];
		int[][] count = new int[N][N];
		
		sums[0][0] = triangle[0][0];
		count[0][0] = 1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j > 0) {
					if (sums[i - 1][j] > sums[i - 1][j - 1]) {
						sums[i][j] = sums[i - 1][j];
						count[i][j] = count[i - 1][j];
					} else if (sums[i - 1][j] < sums[i - 1][j - 1]) {
						sums[i][j] = sums[i - 1][j - 1];
						count[i][j] = count[i - 1][j - 1];
					} else {
						sums[i][j] = sums[i - 1][j];
						count[i][j] = count[i - 1][j] + count[i - 1][j - 1];
					}
				} else {
					sums[i][j] = sums[i - 1][j];
					count[i][j]++;
				}
				sums[i][j] += triangle[i][j];
				maxVal = Math.max(maxVal, sums[i][j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (sums[N - 1][i] == maxVal) {
				maxCount += count[N - 1][i];
			}
		}
		
		return maxCount;
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
			results[i] = triPathCnt(triangle);
		}
		
		for (int i = 0; i < numsOfTestCase; i++) System.out.println(results[i]);
		scan.close();
	}

}
