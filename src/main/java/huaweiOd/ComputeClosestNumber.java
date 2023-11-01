package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 计算最接近的数
 * 给定一个数组X和正整数K，请找出使表达式X[i] - x[i+1] ... - X[i+K-1]，结果最接近于数组中位数的下标i，如果有多个i满足条件，请返回最大的i。
 * 其中，数组中位数:长度为N的数组，按照元素的值大小升序排列后，下标为N/2元素的值
 * 补充说明:
 * 1.数组X的元素均为正整数;
 * 2.X的长度n取值范围: 2<= n <= 1000;
 * 3.K大于0且小于数组的大小;
 * 4.i的取值范围: 0 <=i < 1000;
 * 5.题目的排序数组X[N]的中位数是X[N/2].
 * @case [50, 50, 2, 3], 2
 * return：1
 * @created 2023-11-01 15:47
 */
public class ComputeClosestNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		//String input = "[50,50,2,3],2";
		input = input.replaceAll("\\[|\\]", "");
		int[] arr = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
		int k = arr[arr.length - 1];
		int[] nums = new int[arr.length - 1];
		for (int i = 0; i < arr.length - 1; i++) {
			nums[i] = arr[i];
		}
		//System.out.println(k);
		//System.out.println(Arrays.toString(nums));

		// 计算中位数
		int n = nums.length;
		int[] tmp = nums.clone();
		Arrays.sort(tmp);
		int midNum = tmp[n / 2];

		// 窗口初始化
		int win = nums[0];
		for (int i = 1; i < k - 1; i++) {
			win -= nums[i];
		}
		// 滑窗遍历
		int diff = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 0; i < n - k; i++) {
			win -= nums[i + k - 1];
			// 判断是否满足条件
			int absDiff = Math.abs(win - midNum);
			if (diff >= absDiff) {
				idx = i;
				diff = absDiff;
			}
			win += nums[i] * 2;
		}
		System.out.println(idx);
	}
}
