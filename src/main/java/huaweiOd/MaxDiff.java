package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 分割数组的最大差值
 * 给定一个由若干整数组成的数组nums，可以在数组内任意位置进行分割，将该数组分割成两个非空子数组，分别对子数组求和得到两个值，计算这两个值的差值。
 * 请输出所有分割方案中，差值最大的值。
 * @case 6
 * 1 -2 3 4 -9 7
 * return：10。【1 -2 3 4 -9】和【7】
 * @created 2023-10-29 20:39
 */
public class MaxDiff {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String[] strs = in.nextLine().split(" ");
		int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
		int leftSum = 0;
		int rightSum = Arrays.stream(nums).sum();
		int maxDiff = 0;
		for (int i = 0; i < n - 1; i++) {
			leftSum += nums[i];
			rightSum -= nums[i];
			maxDiff = Math.max(maxDiff, Math.abs(leftSum - rightSum));
		}
		System.out.println("所有分割方案中差值最大的值为" + maxDiff);
	}
}
