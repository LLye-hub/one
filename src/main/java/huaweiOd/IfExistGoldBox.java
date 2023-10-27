package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 阿里巴巴找黄金宝箱1
 * 藏宝地有编号 0-n 的箱子，每个箱子贴有一个数字，箱子中可能有一个黄金宝箱，满足排在它之前的所有箱子数字和 等于 排在它之后的所有箱子数字和。
 * 输出第一个满足条件的黄金宝箱编号，不存在则返回 -1。
 * @case 2, 5,-1,8,6
 * return: 3
 * <p>
 * 8,9
 * return: -1
 * <p>
 * 11
 * return: 0
 * @created 2023-10-27 16:12
 */
public class IfExistGoldBox {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(",");
		int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

		int leftSum = 0;
		int rightSum = Arrays.stream(nums).sum();
		for (int i = 0; i < nums.length; i++) {
			if (i > 0) {
				leftSum += nums[i - 1];
			}
			rightSum -= nums[i];
			if (leftSum == rightSum) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}
