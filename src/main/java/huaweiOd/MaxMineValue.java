package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 寻找最大价值的矿堆
 * 给你一个由 '0'（空地）、'1'（银矿）、'2'（金矿）组成的的地图，矿堆只能由上下左右相邻的金矿或银矿连接形成。超出地图范围可以认为是空地。
 * 假设银矿价值 1 ，金矿价值 2 ，请你找出地图中最大价值的矿堆并输出该矿堆的价值。
 * 输入描述：
 * 地图元素信息如：
 * 4 5
 * 22220
 * 00000
 * 00000
 * 01111
 * 4 表示输入数据为 4 行， 5 表示输入数据为 5 列；地图范围最大为 300 * 300；0 <= 地图元素 <= 2。
 * 输出描述：矿堆的最大价值。
 * @case 4 5
 * 22220
 * 00000
 * 00000
 * 01111
 * return：8
 * 4 5
 * 22220
 * 00020
 * 00010
 * 01111
 * return：15
 * 4 5
 * 20000
 * 00020
 * 00000
 * 00111
 * return：3
 * @created 2023-11-02 17:39
 */
public class MaxMineValue {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] mn = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int m = mn[0];
		int n = mn[1];
		int[][] graph = new int[m][n];
		for (int i = 0; i < m; i++) {
			graph[i] = Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
		}

		// 遍历
		int maxValue = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 找到了矿堆
				if (graph[i][j] != 0) {
					maxValue = Math.max(dfs(graph, i, j), maxValue);
				}
			}
		}
		System.out.println(maxValue);
	}

	public static int dfs(int[][] graph, int i, int j) {
		// 终止条件，超出范围或是空地
		if (i < 0 || i >= graph.length || j < 0 || j >= graph[0].length || graph[i][j] == 0) {
			return 0;
		}
		// 标记当前矿堆，防止重复计算
		int cur = graph[i][j];
		graph[i][j] = 0;
		// 对上下左右相邻的矿堆进行dfs计算
		cur += dfs(graph, i - 1, j);
		cur += dfs(graph, i + 1, j);
		cur += dfs(graph, i, j - 1);
		cur += dfs(graph, i, j + 1);
		return cur;
	}
}
