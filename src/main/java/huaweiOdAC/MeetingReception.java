package huaweiOdAC;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 会议接待/代表团坐车（AC）
 * 某组织举行会议，来了多个代表团同时到达，接待处只有一辆汽车，可以同时接待多个代表团，为了提高车辆利用率，
 * 请帮接待员计算可以坐满车的接待方案，输出方案数量。
 * 约束： 1. 一个团只能上一辆车，并且代表团人数（代表团数量小于30，每个代表团人数小于30）小于汽车容量（汽车容量小于100）
 * 2. 需要将车辆坐满
 * 输入：第一行代表团人数，英文逗号隔开，代表团数量小于30，每个代表团人数小于30。第二行汽车载客量，汽车容量小于100
 * 输出：坐满汽车的方案数量，如果无解输出0。
 * @case 5, 4, 2, 3, 2, 4, 9
 * 10
 * return：4
 * @created 2023-10-31 23:12
 */
public class MeetingReception {

	private static int res = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(",");
		// 代表团
		int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		// 载客量
		int cnt = Integer.parseInt(in.nextLine());
		backtracking(cnt, nums, 0, 0);
		System.out.println(res);
	}

	public static void backtracking(int cnt, int[] nums, int idx, int sum) {
		// 递归终止条件
		if (sum == cnt) {
			//System.out.println(idx+" "+sum+" "+res);
			res++;
			return;
		}
		if (sum > cnt) {
			return;
		}
		for (int i = idx; i < nums.length; i++) {
			// 处理节点
			int num = nums[i];
			sum += num;
			// 递归
			backtracking(cnt, nums, i + 1, sum);
			// 回溯
			sum -= num;
		}
	}
}
