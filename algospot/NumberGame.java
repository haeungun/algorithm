/**
 * 출처: https://algospot.com/judge/problem/read/NUMBERGAME
 * 
 * n개의 정수를 일렬로 늘어놓은 게임판을 가지고 현우와 서하가 게임을 합니다. 
 * 게임은 현우부터 시작해서 번갈아가며 진행하며, 각 참가자는 자기 차례마다 두 가지 일 중 하나를 할 수 있습니다.

 * 1. 게임판의 왼쪽 끝에 있는 숫자나 오른쪽 끝에 있는 숫자 중 하나를 택해 가져갑니다. 가져간 숫자는 게임판에서 지워집니다.
 * 2. 게임판에 두 개 이상의 숫자가 있을 경우, 왼쪽 끝에서 2개, 혹은 오른쪽 끝에서 2개를 지웁니다.
 *
 * 게임은 모든 숫자가 다 없어졌을 때 끝나며, 각 사람의 점수는 자신이 가져간 숫자들의 합입니다. 
 * 현우와 서하는 점수가 더 낮은 쪽이 점수 높은 쪽에 한 점 차이마다 백 원씩 주기로 내기를 했습니다. 
 * 두 사람 모두 최선을 다할 때, 두 사람의 최종 점수 차이는 얼마일까요?
 *
 */

import java.util.*;

public class NumberGame {
	public static int[] game;
	public static int[][] scores;
	
	public static int numberGame(int left, int right) {	
		if (left > right) return Integer.MIN_VALUE;
		if (scores[left][right] != Integer.MIN_VALUE) return scores[left][right];
		
		if (left - right == 0) { // 게임판에 남은 숫자가 1개 일떄
			scores[left][right] = game[left];
		} else {	
      // 1. 숫자를 가져가거나(왼쪽, 오른쪽)
      // 2. 숫자를 지우거나(왼쪽, 오른쪽)
			int choice1 = Math.max(game[left] - numberGame(left + 1, right), game[right] - numberGame(left, right - 1));
			int choice2 = Math.max(-numberGame(left + 2, right), -numberGame(left, right - 2));
			scores[left][right] = Math.max(choice1, choice2);
		}
		
		return scores[left][right];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numsOfTestCase = scan.nextInt();
		int[] results = new int[numsOfTestCase];
		
		for (int i = 0; i < numsOfTestCase; i++) {
			int N = scan.nextInt();

			game = new int[N];
			scores = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				Arrays.fill(scores[j], Integer.MIN_VALUE);
			}
			
			for (int k = 0; k < N; k++) {
				game[k] = scan.nextInt();
			}
			
			results[i] = numberGame(0, N - 1);
		}
		
		for (int i = 0; i < numsOfTestCase; i++) System.out.println(results[i]);
		scan.close();
	}

}
