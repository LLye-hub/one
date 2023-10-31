package huaweiOdAC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 观看文艺汇演问题（同力扣题：435. 无重叠区间）
 * 一人只能同时观看一场演出，且不能迟到早退。由于演出分散在不同的演出场地，所以连续观看的演出至少要有15min的时间间隔。
 * 小明是一个狂热的文艺迷，想观看尽可能多的演出。现给出演出时间表，请帮小明计算他最多能观看几场演出。
 * 输入：第一行 n，表示演出场数
 * 接下来n行，每一行有两个空格分隔的整数，第一个 t 表示演出开始时间，第二个 l 表示演出持续时间。
 * @case 2
 * 720 120
 * 840 120
 * return: 1。两场演出间隔时间为0，不满足间隔15min要求，最多只能观看一场演出
 * 2
 * 0 60
 * 90 60
 * return：2
 * @created 2023-10-30 19:54
 */
public class PerformanceViewTimes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int[][] shows = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] line = in.nextLine().split(" ");
			// 演出开始时间 和 下一次可以观看演出时间
			shows[i][0] = Integer.parseInt(line[0]);
			shows[i][1] = Integer.parseInt(line[0]) + Integer.parseInt(line[1]) + 15;
		}

		method1(n, shows);
	}

	// 贪心算法
	public static void method1(int n, int[][] shows) {
		// 按 下一次可以观看演出时间 升序排列
		Arrays.sort(shows, Comparator.comparingInt(o -> o[0]));

		// 记录重叠区间个数
		int res = 0;
		// 初始化右端点
		int right = shows[0][1];
		for (int i = 1; i < n; i++) {
			if (shows[i][0] >= right) {
				// 下一区间左端点 >= 上一区间右端点，则不重叠
				right = shows[i][1];
			} else {
				// 重叠情况，取最小的右端点作为下一区间分割线
				right = Math.min(right, shows[i][1]);
				res++;
			}
		}
		System.out.println(n - res);

	}

}



