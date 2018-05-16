/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/
 */

class Solution {
  public int minSwap(int[] A, int[] B) {
    int N = A.length;
    
    int[] keep = new int[N];
    int[] swap = new int[N];
    
    Arrays.fill(keep, Integer.MAX_VALUE);
    Arrays.fill(swap, Integer.MAX_VALUE);
    
    keep[0] = 0;
    swap[1] = 1;
    
    for (int i = 1; i < N; i++) {
      int a1 = A[i - 1], a2 = A[i];
      int b1 = B[i - 1], b2 = B[i];
      
      if (a1 < a2 && b1 < b2) { // Can keep 
        keep[i] = keep[i - 1];
        swap[i] = swap[i - 1] + 1;
      }
      
      if (a1 < b2 && b1 < a2) { // Can swap
        keep[i] = Math.min(keep[i], swap[i - 1]);
        swap[i] = Math.min(swap[i], keep[i- 1] + 1);
      }
    }
    
    return Math.min(keep[N - 1], swap[N - 1]);
  }
}
 
