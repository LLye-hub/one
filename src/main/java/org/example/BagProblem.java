package org.example;

import java.util.Scanner;


/**
 * @author 数据组-雨叶
 * @description
 * @created 2023-06-27 15:28
 */
public class BagProblem {
	public static void main(String[] args) {
		/* case
		50 5
		20 3 5
		20 3 5
		10 3 0
		10 2 0
		10 1 0
		* */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt() / 10; // 总钱数
		int m = in.nextInt(); // 物品个数

		Goods[] goods = new Goods[m + 1];
		// 对象初始化一定要前置处理，否则有空指针异常
		for (int i = 1; i <= m; i++) {
			goods[i] = new Goods();
		}
		// 遍历从1开始，与物品编号 1-m 保持一致
		for (int i = 1; i <= m; i++) {
			goods[i].v = in.nextInt() / 10;
			goods[i].vp = in.nextInt() * goods[i].v; // 直接计算出单个物品的满意度
			int q = in.nextInt();
			if (q == 0) {
				goods[i].main = true; // 是主件
			} else if (goods[q].a1 == -1) {
				goods[q].a1 = i; // 第一个附件
			} else {
				goods[q].a2 = i; // 第二个附件
			}
		}

		// 01背包问题：动态规划，一维dp数组
		// dp[j]表示在预算【j】内可获得的最大满意度
		int[] dp = new int[n + 1];
		// 双层遍历物品和预算
		for (int i = 1; i <= m; i++) {
			for (int j = n; j >= 0; j--) {
				// 不买物品i
				//dp[j] = dp[j];

				/* 买物品i
				   1、附件不单独买
				   2、只买主件
				   3、买主 + 1附（如有两个附件则有两种情况）
				   4、买主 + 2附
				 */
				// 1、附件不单独买
				if (!goods[i].main) {
					continue;
				}
				// 2、只买主件
				if (j - goods[i].v >= 0) {
					dp[j] = Math.max(dp[j], dp[j - goods[i].v] + goods[i].vp);
				}
				// 3、买主 + 1附
				if (goods[i].a1 != -1 && (j - goods[i].v - goods[goods[i].a1].v >= 0)) {
					dp[j] = Math.max(dp[j], dp[j - goods[i].v - goods[goods[i].a1].v] + goods[i].vp + goods[goods[i].a1].vp);
				}
				// 3、买主 + 1附
				if (goods[i].a2 != -1 && (j - goods[i].v - goods[goods[i].a2].v >= 0)) {
					dp[j] = Math.max(dp[j], dp[j - goods[i].v - goods[goods[i].a2].v] + goods[i].vp + goods[goods[i].a2].vp);
				}
				// 4、买主 + 2附
				if (goods[i].a1 != -1 && goods[i].a2 != -1 && (j - goods[i].v - goods[goods[i].a1].v - goods[goods[i].a2].v >= 0)) {
					dp[j] = Math.max(dp[j], dp[j - goods[i].v - goods[goods[i].a1].v - goods[goods[i].a2].v] + goods[i].vp + goods[goods[i].a1].vp + goods[goods[i].a2].vp);
				}
				// 打印数组
				for (int k = 0; k <= n; k++) {
					System.out.print(dp[k] + " ");
				}
				System.out.println();
			}
		}

		System.out.print(dp[n] * 10);
	}
}

class Goods {
	int v;  // 物品价格
	int vp;  // 单个物品满意度
	boolean main = false; // 是否主件
	int a1 = -1;  // 初始化定义附件1的编号
	int a2 = -1;  // 初始化定义附件2的编号
}