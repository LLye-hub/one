package huaweiOd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 根据某条件聚类最少交换次数（同力扣题：最少交换次数来组合所有的1）
 * 给出数字k，请输出所有结果小于k的整数组合到一起的最少交换次数。
 * 组合一起是指满足条件的数字相邻，不要求相邻后在数组中的位置。
 * @case 1 3 1 4 0
 * 2
 * return：1
 * 0 0 0 1 0
 * 2
 * return：0
 * 2 3 2
 * 1
 * return：0
 * 1 2 3 4 1 5 6 7 8 1
 * 2
 * return：2
 * @created 2023-10-30 14:40
 */
public class MinChangeTimes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(" ");
		int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
		int k = Integer.parseInt(in.nextLine());

		method1(nums, k);
		method2(nums, k);
	}

	public static void method1(int[] nums, int k) {
		// 记录小于k的整数的索引
		List<Integer> indexList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				indexList.add(i);
			}
		}
		// 数组中的整数，都大于 k 或都小于 k，直接返回交换次数 0
		int len = indexList.size();
		if (len == 0 || len == nums.length) {
			System.out.println(0);
			return;
		}

		// 此题可以转换为，从 [minIdx, maxIdx] 区间中，找出一个长度为 len 的闭区间，使 nums 数组中大于 k 的数字的个数最小
		int minIdx = indexList.get(0);
		int maxIdx = indexList.get(len - 1);
		// 初始化第一个区间中，大于k的数字
		int curCnt = 0;
		for (int i = minIdx; i < minIdx + len - 1; i++) {
			if (nums[i] >= k) {
				curCnt++;
			}
		}
		// 从 [minIdx, maxIdx] 区间中，滑窗计算curCnt
		int minChanges = len;
		for (int i = minIdx; i <= maxIdx - len + 1; i++) {
			// 计算当前区间内大于等于k的个数
			if (nums[i + len - 1] >= k) {
				curCnt++;
			}
			//System.out.println("[" + nums[i] + "," + nums[i + len - 1] + "] 区间最小交换次数: " + curCnt);
			minChanges = Math.min(curCnt, minChanges);
			// 下一区间无nums[i]
			if (nums[i] >= k) {
				curCnt--;
			}
		}
		System.out.println(minChanges);
	}

	public static void method2(int[] nums, int k) {
		// 记录小于k的整数个数
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				count++;
			}
		}
		// 数组中的整数，都大于 k 或都小于 k，直接返回交换次数 0
		if (count == 0 || count == nums.length) {
			System.out.println(0);
			return;
		}
		// 此题可以转换为，以步长 count 滑窗计算大于等于 k 的个数（即当前窗口交换次数）
		// 初始化第一个窗口 [0,count-1)
		int curCnt = 0;
		for (int i = 0; i < count - 1; i++) {
			if (nums[i] >= k) {
				curCnt++;
			}
		}
		int minTimes = count;
		for (int i = 0; i <= nums.length - count; i++) {
			// 计算窗口 [i,i+count-1] 的交换次数
			if (nums[i + count - 1] >= k) {
				curCnt++;
			}
			minTimes = Math.min(curCnt, minTimes);
			// 下一窗口无 num[i]
			if (nums[i] >= k) {
				curCnt--;
			}
		}
		System.out.println(minTimes);
	}
}
