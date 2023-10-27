package huaweiOd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 运动员比赛
 * 有n个运动员，比赛规则是 0号和1号比赛，2号和3号比赛，以此类推，每一轮相邻的运动员进行比赛，获胜的进入下一轮。
 * 实力值大的获胜，实力值相等的情况下id小的获胜，轮空的直接进入下一轮
 * @case 2 3 4 5
 * return：3 1 2
 * @created 2023-10-27 23:03
 */
public class SportPlayerRank {
	private static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(" ");
		int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

		List<Integer> idxs = new ArrayList<>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			idxs.add(i);
		}
		winner(idxs, nums);
		System.out.println(list.get(len - 1) + " " + list.get(len - 2) + " " + list.get(len - 3));
	}

	public static void winner(List<Integer> idxs, int[] nums) {
		int len = idxs.size();
		if (len == 1) {
			list.add(idxs.get(0));
			return;
		}
		// 初始化列表，用于存放下一轮选手
		List<Integer> tmp = new ArrayList<>();
		int i = 0;
		while (i < len) {
			int id1 = idxs.get(i);
			// 轮空
			if (i == len - 1) {
				tmp.add(id1);
				break;
			}
			int id2 = idxs.get(i + 1);
			// 相邻比赛，实力值大的赢
			if (nums[id1] >= nums[id2]) {
				tmp.add(id1);
				list.add(id2);
			} else {
				tmp.add(id2);
				list.add(id1);
			}
			i += 2;
		}
		winner(tmp, nums);


	}
}
