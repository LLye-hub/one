package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description melon的难题
 * melon有一批精美的雨花石，准备送给s和w。melon希望送俩人的雨花石重量一致，请你设计一个程序，帮melon确认能否将雨花石平均分配。
 * 如果可以均分，从当前雨花石中最少拿出几块，可以使两堆重量相等；不能均分返回 -1。
 * @case 4
 * 1 1 2 2
 * return：2。平均分配 1、2 和 1、2
 * @case 10
 * 1 1 1 1 1 9 8 3 7 10
 * return：3。均分时可以为 1 1 1 1 1 9 7 和 10 8 3，或1 1 1 1 9 8 和 10 7 3 1，最少是拿出10 8 3，共【3】块
 * @created 2023-10-26 20:03
 */
/*
4
1 1 2 2
10
1 1 1 1 1 9 8 3 7 10
4
1 5 11 5
4
1 2 3 5
* */
public class DistributeStone {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = Integer.parseInt(in.nextLine());
			String[] strs = in.nextLine().split(" ");
			int[] stones = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

			System.out.println(method1(n, stones));

			System.out.println(method2(n, stones));
		}
	}


	public static int method1(int n, int[] stones) {
		int sum = Arrays.stream(stones).sum();
		// 总重量不能整除2，说明不能均分
		if (sum % 2 != 0) {
			return -1;
		}
		// 寻找均分分组
		// 背包问题：满足分组和为 sum/2 的所有情况。  题目参考：分割等和子集
		int amount = sum / 2;
		// 初始化数组，用于存放满足当前重量的最少石头数
		int[][] dp = new int[n + 1][amount + 1];
		// 先遍历石头数，再遍历重量
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= amount; j++) {
				int weight = stones[i - 1];
				if (j >= weight) {
					// 放石头
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + 1);
				} else {
					// 不放石头
					dp[i][j] = dp[i - 1][j];
				}
				//System.out.println(Arrays.toString(dp[i]));
			}
			//System.out.println(Arrays.toString(dp[i]));
		}
		//System.out.println(dp[n][amount]);
		if (dp[n][amount] == n) {
			return -1;
		} else {
			return n - dp[n][amount];
		}
	}

	public static int method2(int n, int[] stones) {
		int sum = Arrays.stream(stones).sum();
		// 总重量不能整除2，说明不能均分
		if (sum % 2 != 0) {
			return -1;
		}
		// 寻找均分分组
		// 背包问题：满足分组和为 sum/2 的所有情况。  题目参考：分割等和子集
		int amount = sum / 2;
		// 初始化数组，用于存放满足当前重量的最少石头数
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			dp[i] = n;
		}
		// 先遍历石头数，再倒序遍历重量
		for (int i = 0; i < n; i++) {
			int weight = stones[i];
			for (int j = amount; j >= weight; j--) {
				dp[j] = Math.min(dp[j], dp[j - weight] + 1);
				//System.out.println(Arrays.toString(dp));
			}
		}
		if (dp[amount] == n) {
			return -1;
		} else {
			return dp[amount];
		}
	}
}
