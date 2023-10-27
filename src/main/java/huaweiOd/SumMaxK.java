package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 阿里巴巴找黄金宝箱5
 * 藏宝地有编号 0-n 的箱子，每个箱子贴有一个数字，找出连续 k 个宝箱数字和的最大值并输出该最大值。
 * @case 2, 10,-3,-8,40,5
 * 4
 * <p>
 * 8
 * 1
 * @created 2023-10-27 14:50
 */
public class SumMaxK {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(",");
		int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
		int k = Integer.parseInt(in.nextLine());

		int sumK = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i < k) {
				sumK += nums[i];
			} else {
				sumK = Math.max(sumK, sumK + nums[i] - nums[i - k]);
			}
		}
		System.out.println("连续 k 个宝箱数字和的最大值 = " + sumK);


	}

}
