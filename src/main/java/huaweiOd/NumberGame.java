package huaweiOd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 数仓开发-雨叶
 * @description 数字游戏
 * 是否存在连续的若干张牌，其和可以整除小明手中牌上的数字
 * @case 6 7
 * 2 12 6 3 5 5
 * 10 11
 * 1 1 1 1 1 1 1 1 1 1
 * return：1
 * 0
 * 解释：两组输入。第一组小明牌为 7，再发了6张牌，第1、2张牌和为14，能整除7，返回1。
 * 第一组小明牌为 11，再发了10张牌，10张牌和为10，不能整除11，返回0。
 * @created 2023-10-26 13:25
 */
/*
6 7
2 12 6 3 5 5
10 11
1 1 1 1 1 1 1 1 1 1
*/
public class NumberGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String[] str1 = in.nextLine().split(" ");
			String[] str2 = in.nextLine().split(" ");
			// 后续发牌数
			int n = Integer.parseInt(str1[0]);
			// 手上的牌
			int m = Integer.parseInt(str1[1]);
			// 后续发牌数字
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(str2[i]);
			}
			System.out.println(method1(m, n, nums));
			System.out.println(method2(m, n, nums));
		}
	}

	// 暴力解法
	public static int method1(int m, int n, int[] nums) {
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += nums[j];
				if (sum % m == 0) {
					return 1;
				}
			}
		}
		return 0;
	}

	// 数学规律
	/* 结合率：如果 (a-b)%k=0， 则 a%k=b%k。反之 a%k=b%k，则 a~b 连续区间定能整除 k。
	 * 利用这个数学性质，不必双重for遍历，只需要检查preSum数组中是否存在两个元素 % k的结果相同，即可说明存在区间之和可以整除k。
	 * */
	public static int method2(int m, int n, int[] nums) {
		Set<Integer> remain = new HashSet<>();
		// 初始化，存在从第一个数字连续求和直接能整除情况
		remain.add(0);
		int preSum = 0;
		for (int i = 0; i < n; i++) {
			preSum += nums[i];
			if (remain.contains(preSum % m)) {
				return 1;
			} else {
				remain.add(preSum % m);
			}
		}
		return 0;
	}
}

