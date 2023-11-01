package huaweiOdAC;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 跳房子I (AC)
 * 跳房子，也叫跳飞机，是一种世界性的儿童游戏。
 * 游戏参与者需要分多个回合按顺序跳到第1格直到房子的最后一格
 * 跳房子的过程中，可以向前跳，也可以向后跳。
 * 假设房子的总格数是count，小红每回合可能连续跳的步教都放在数组steps中，请问数组中是否有一种步数的组合，可以让小红两个回合跳到最后一格?
 * 如果有，请输出索引和最小的步数组合。
 * 注意:
 * - 数组中的步数可以重复，但数组中的元素不能重复使用。
 * - 提供的数据保证存在满足题目要求的组合，且索引和最小的步数组合是唯一的。
 * @case [1, 4, 5, 2]
 * 7
 * return: [5,2]
 * @created 2023-11-01 21:27
 */
public class JumpHouse {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] str = in.nextLine().replaceAll("\\[|\\]", "").split(",");
		int[] nums = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
		int count = Integer.parseInt(in.nextLine());

		int n = nums.length;
		int minIds = Integer.MAX_VALUE;
		int[] res = new int[2];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// 满足条件 且 索引和最小
				if (nums[i] + nums[j] == count && i + j < minIds) {
					res[0] = nums[i];
					res[1] = nums[j];
					minIds = i + j;
				}
			}
		}
		System.out.println("[" + res[0] + "," + res[1] + "]");
	}
}
