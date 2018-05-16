/**
 * https://algospot.com/judge/problem/read/TILING2
 */

import java.util.*;

public class Main {
	
	public static int tiling(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		
		int[] nums = new int[n];
		nums[0] = 1;
		nums[1] = 2;
		
		for (int i = 2; i < n; i++) {
			nums[i] = (nums[i - 1] + nums[i - 2]) % 1000000007;
		}
		
		return nums[n - 1];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numsOfTestCase = scan.nextInt();
		int[] results = new int[numsOfTestCase];
		
		for (int i = 0; i < numsOfTestCase; i++) {
			results[i] = tiling(scan.nextInt());
		}
		
		for (int i = 0; i < numsOfTestCase; i++) {
			System.out.println(results[i]);
		}
	}
}
