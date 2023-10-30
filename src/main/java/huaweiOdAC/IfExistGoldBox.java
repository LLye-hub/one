package huaweiOdAC;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 阿里巴巴找黄金宝箱1
一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从 0 ~ N 的箱子，每个箱子上面贴有一个数字，箱子中可能有一个黄金宝箱。
黄金宝箱满足排在它之前的所有箱子数字和等于排在它之后的所有箱子数字之和；第一个箱子左边部分的数字和定义为0；最后一个箱子右边部分的数字和定义为0。
请帮阿里巴巴找到黄金宝箱，输出第一个满足条件的黄金宝箱编号，如果不存在黄金宝箱，请返回 -1 。
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
