/**
 * https://algospot.com/judge/problem/read/PI
 */

import java.util.*;
 
public class Main {

	public static int pi(String str) {
		int n = str.length();
		int[] diff = new int[n];
		
		diff[2] = difficulty(str, 0, 3);
		diff[3] = difficulty(str, 0, 4);
		diff[4] = difficulty(str, 0, 5);
		
		for (int i = 2; i < n; i++) {
			for (int j = 3; j <= 5; j++) {
				int pos = i + j;
				if (pos >= n) break;
				
				int d = diff[pos - j] + difficulty(str, pos - j + 1,i + j + 1);
				if (diff[pos] == 0) {
					diff[pos] = d;
				} else {
					diff[pos] = Math.min(diff[pos], d);
				}
				
			}
		}
		
		return diff[n - 1];
	}
	
	public static int difficulty(String str, int start, int end) {		
		int size = end - start;
		if (!(size == 3 || size == 4 || size == 5)) return Integer.MAX_VALUE;
		
		String nums = str.substring(start, end);
		
		if (isOne(nums)) return 1;
		else if (isTwo(nums)) return 2;
		else if (isFour(nums)) return 4;
		else if (isFive(nums)) return 5;
		else return 10;
	}
	
	public static boolean isOne(String nums) {
		for (int i = 0; i < nums.length() - 1; i++) {
			int n = (int) nums.charAt(i); 
			int m = (int) nums.charAt(i + 1);
			if (n != m) return false;
		}
		return true;
	}
	
	public static boolean isTwo(String nums) {
		boolean decrease = true;
		boolean increase = true;
		for (int i = 0; i < nums.length() - 1; i++) {
			int n = (int) nums.charAt(i); 
			int m = (int) nums.charAt(i + 1);
			if (n - 1 != m) decrease = false;
			if (n + 1 != m) increase = false;
			if (!increase && !decrease) break;
		}
		return decrease || increase;
	}
	
	public static boolean isFour(String nums) {
		for (int i = 0; i < nums.length(); i ++) {
			int n = (int) nums.charAt(i);
			int m = (int) nums.charAt(i % 2);
			if (n != m) return false;
		}
		return true;
	}
	
	public static boolean isFive(String nums) {
		int diff = (int) nums.charAt(1) - (int) nums.charAt(0);
		for (int i = 0; i < nums.length() - 1; i++) {
			int n = (int) nums.charAt(i);
			int m = (int) nums.charAt(i + 1);
			if (diff != (m - n)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numsOfTestCase = scan.nextInt();
		int[] results = new int[numsOfTestCase];
		
		for (int i = 0; i < numsOfTestCase; i++) {
			results[i] = pi(scan.next());
		}
		
		for (int i = 0; i < numsOfTestCase; i++) {
			System.out.println(results[i]);
		}
	}

}
