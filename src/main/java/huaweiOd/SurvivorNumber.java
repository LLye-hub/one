package huaweiOd;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 荒岛逃生游戏
 * 一个荒岛上有若干人，岛上只有一条路通往岛屿两端的港口，大家需要逃生两端的港口才可逃生，假定每个人移动的速度一样，且只可选择向左或向右逃生。
 * 若两个人相遇，则进行决斗，战斗力强的能够活下来，并损失掉与对方相同的战斗力；若战斗力相同，则两人同归于尽。
 * 输入：正表示向右逃生，负表示向左逃生
 * 输出：能逃生的人总数，没有人逃生输出0，输入异常输出-1
 * @case 5 10 8 -8 -5
 * return：2。
 * -3 5 10 8 -8 -5
 * return：3。
 * 10 20 -20 -5 10
 * return：2
 * @created 2023-10-31 17:22
 */
public class SurvivorNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] input = in.nextLine().split(" ");
		int[] nums = new int[input.length];
		try {
			nums = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
		} catch (NumberFormatException e) {
			System.out.println(-1);
		}

		int n = nums.length;

		Deque<Integer> right = new ArrayDeque<>();
		int leftMan = 0;
		int cur;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			cur = nums[i];
			// 逃生方向
			if (cur > 0) {
				// 向右逃生
				right.addLast(cur);
			} else {
				// 向左逃生
				leftMan = Math.abs(cur);
				// 战斗力抵消
				while (!right.isEmpty()) {
					if (right.peekLast() > leftMan) {
						// 向右逃生 能完全打败 向左逃生
						right.add(right.pollLast() - leftMan);
						leftMan = 0;
					} else {
						// 向右逃生 不能打败 向左逃生，或是战力相同
						leftMan -= right.pollLast();
					}
					if (leftMan == 0) {
						break;
					}
				}
				// 打败所有向右逃生的人后还有战力，则逃出成功
				if (leftMan > 0) {
					cnt++;
				}
			}
		}
		System.out.println(right.size() + cnt);
	}

}
