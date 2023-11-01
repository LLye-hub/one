package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 篮球比赛
 * 题目说明：篮球(5V5)比赛中，每个球员拥有一个战斗力，每个队伍的所有球员战斗力之和为该队伍的总体战斗力。
 * 现有 10 个球员准备分为两队进行训练赛，教练希望 2 个队伍的战斗力差值能够尽可能的小，以达到最佳训练效果。
 * 给出 10 个球员的战斗力，如果你是教练，你该如何分队，才能达到最佳训练效果?请说出该分队方案下的最小战斗力差值。
 * 输入描述：10 个篮球队员的战斗力(整数，范围[1，10000])战斗力之间用空格分隔，如：10 9 8 7 6 5 4 3 2 1。
 * 不需要考虑异常输入的场景。
 * 输出描述：输出描述最小的战斗力差值，如：1。
 * @case 10 9 8 7 6 5 4 3 2 1
 * return：1
 * @created 2023-11-01 18:43
 */
public class RectangularIntersectionArea {

	private static int cnt = 0;
	private static int res = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		//input = "10 9 8 7 6 5 4 3 2 1";
		int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
		// 排序后可以进行回溯剪枝
		//Arrays.sort(nums);
		int sum = Arrays.stream(nums).sum();
		backTracking(0, 0, nums, sum);
		System.out.println(res);

	}

	public static void backTracking(int idx, int curSum, int[] nums, int sum) {
		// 终止条件
		if (cnt == 5) {
			// 计算战斗力差值
			res = Math.min(res, Math.abs((sum - curSum) - curSum));
			return;
		}
		for (int i = idx; i < nums.length; i++) {
			// 处理节点
			int num = nums[i];
			cnt++;
			curSum += num;
			idx++;
			// 递归
			backTracking(idx, curSum, nums, sum);
			// 回溯
			cnt--;
			curSum -= num;
			idx--;
		}
	}
}
