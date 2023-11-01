package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 最佳植树距离 (AC)
 * 小明在直线的公路上种树，现在给定可以种树的坑位的数量和位置，以及需要种多少棵树苗，
 * 问树苗之间的最小间距是多少时，可以保证种的最均匀（两棵树苗之间的最小间距最大）
 * 输入三行：
 * 第一行一个整数：坑位的数量
 * 第二行以空格分隔的数组：坑位的位置
 * 第三行一个整数：需要种植树苗的数量
 * @case 7
 * 1 3 6 7 8 11 13
 * 3
 * return：6
 * @created 2023-11-01 20:57
 */
public class BestPlantDistance {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		int target = Integer.parseInt(in.nextLine());

		int left = 0;
		int right = nums[n - 1] - nums[0];
		while (left < right) {
			int mid = (left + right + 1) / 2;
			if (check(nums, mid) < target) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		System.out.println(left);
	}

	public static int check(int[] nums, int k) {
		int cnt = 1;
		int pre = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[pre] >= k) {
				cnt++;
				pre = i;
			}
		}
		//System.out.println(k + " " + cnt);
		return cnt;
	}

}
