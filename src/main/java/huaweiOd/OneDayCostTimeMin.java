package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 编码能力提升计划
 * n道题，小王计划在m天内按照题目编号顺序刷完所有题，小王不能用多天完成同一题。
 * 小王需要time[i]时间完成编号i的题目。此外，小王每天最多能查看一次答案，查看答案不计入做题总时间。
 * 定义m天中做题时间最多的一天耗时为T，请帮小王求出最小的T是多少。
 * @case 999, 999, 999
 * 4 （m天）
 * return: 0。 前三天每天都查看答案
 * <p>
 * 1,2,2,3,5,4,6,7,8
 * 5
 * return: 4。第一天完成3题，第3题看答案；第二天完成4和5，第5题看答案；第三天完成6和7，第7题看答案；第四天完成8，直接看答案；第四天完成9，直接看答案；
 * @created 2023-10-28 13:40
 */
public class OneDayCostTimeMin {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(",");
		int[] times = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
		int m = Integer.parseInt(in.nextLine());
		int right = Arrays.stream(times).sum();
		int left = 0;
		int mid;
		if (m > times.length) {
			System.out.println("最小化最多一天耗时T = " + 0);
			return;
		}
		while (left < right) {
			// 取中间值，作为一天最多耗时时间
			mid = (left + right + 1) / 2;
			// 判断一天最多耗时 mid 的情况下，完成刷题需要的天数
			int days = check(times, mid);
			if (days < m) {
				// 猜大了
				right = mid - 1;
			} else if (days > m) {
				// 猜小了
				left = mid;
			} else {
				System.out.println("最小化最多一天耗时T = " + mid);
				return;
			}
		}

	}

	public static int check(int[] times, int t) {
		int len = times.length;
		int i = 0;
		int sum = 0;
		int days = 0;
		while (i < len) {
			sum += times[i];
			// 判断当前天数做题时间是否超出 t
			if (sum > t) {
				// 做题时间超出，可以看一次答案，则重置并进入下一天
				days++;
				sum = 0;
			}
			i++;
		}
		if (sum > 0) {
			days++;
		}
		System.out.println("T = " + t + " ; days");
		return days;
	}


}
