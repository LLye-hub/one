package huaweiOd;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 阿里巴巴找黄金宝箱(4)
 * 一贫如洗的椎夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从 0-N 的箱子，
 * 每个箱子上面有一人数字，箱子排列成一个环，数字最大的箱子的下一个是编号为 0 的箱子。
 * 请输出每个箱子贴的数字之后的第一个比它大的数，如果不存在则输出-1。
 * @case 2, 5, 2
 * return：5,-1,5
 * @created 2023-10-30 21:47
 */
public class AlibabaFindGoldBox4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(",");
		int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
		int len = nums.length;
		// 获取数字最大的箱子的id
		int maxNum = 0;
		int maxId = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] > maxNum) {
				maxId = i;
				maxNum = nums[i];
			}
		}
		// 编号为 0 的箱子的id
		maxId++;
		// 初始化
		int[] res = new int[len];
		Arrays.fill(res, -1);
		// 遍历，起始索引位置为maxId + 1
		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = maxId; i < len * 2 + maxId; i++) {
			while (!queue.isEmpty() && nums[i % len] > nums[queue.peekLast()]) {
				int id = queue.pollLast();
				res[id] = nums[i % len];
			}
			queue.addLast(i % len);
			//System.out.println(i + ": " + Arrays.toString(res) + "   " + queue.toString());
		}

		// 输出结果
		System.out.println();
		for (int i = 0; i < len; i++) {
			if (i == len - 1) {
				System.out.print(res[i]);
			} else {
				System.out.print(res[i] + ",");
			}
		}
	}
}
