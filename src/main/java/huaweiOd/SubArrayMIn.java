package huaweiOd;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 最小循环子数组
 * 给定一个由若干整数组成的数组nums，请检查数组是否是由某个子数组重复循环拼接而成
 * 输出这个最小的子数组
 * 输入：元素个数n
 * ----输入数组的数字序列nums，空格分隔
 * 输出：最小子数组的数字序列，以空格分隔
 * @case 9
 * 1 2 1 1 2 1 1 2 1
 * return：1 2 1
 * @created 2023-10-17 11:33
 */
public class SubArrayMIn {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String nums = in.nextLine().replace(" ", "");

		System.out.println();
		String res1 = method1(n, nums);
		System.out.print("最小子数组序列为：");
		for (int i = 0; i < res1.length(); i++) {
			System.out.print(res1.charAt(i) + " ");
		}

		System.out.println();
		String res2 = method2(n, nums);
		System.out.print("最小子数组序列为：");
		for (int i = 0; i < res2.length(); i++) {
			System.out.print(res2.charAt(i) + " ");
		}

	}

	public static String method1(int n, String nums) {
		String newStr = nums + nums;
		for (int i = 1; i < n / 2 + 1; i++) {
			if (StringUtils.equals(newStr.substring(i, i + n), nums)) {
				return newStr.substring(0, i);
			}
		}
		return "";
	}

	// kmp算法
	public static String method2(int n, String nums) {
		// 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
		nums = " " + nums;
		// 构建next数组
		int[] next = new int[n + 1];
		for (int i = 2, j = 0; i <= n; i++) {
			// i 指向后缀末尾位，j 指向前缀末尾位（也相当于相等的前后缀长度）
			// 前缀和后缀匹配失败，j回到前一位置 next数组对应的值
			while (j > 0 && nums.charAt(i) != nums.charAt(j + 1)) {
				j = next[j];
			}
			// 前缀和后缀匹配成功，j后移
			if (nums.charAt(i) == nums.charAt(j + 1)) {
				j++;
			}
			// 更新next数组
			next[i] = j;
		}
		//System.out.println(ArrayUtils.toString(next));
		// 最后判断是否是重复的子字符串，这里 next[n] 即代表next数组末尾的值
		if (next[n] > 0 && n % (n - next[n]) == 0) {
			return nums.substring(1, n - next[n] + 1);
		}
		return "";
	}
}
