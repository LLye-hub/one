package huaweiOdAC;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 食堂供餐
 * 某公司员工食堂以盒饭方式供餐。为将员工取餐排队时间降低为0，食堂的供餐速度必须要足够快。
 * 现在需要根据以往员工取餐的统计信息，计算出一个刚好能达成排队时间为0的最低供餐速度。即，食堂在每个单位时间内必须至少做出多少份盒饭才能满足要求。
 * 输入描述：第1行为一个正整数N，表示食堂开餐时长。1 <= N <= 1000。
 * 第2行为一个正整数M，表示开餐前食堂已经准备好的盒饭份数。pi <= M <= 1000。
 * 第3行为N个正整数，用空格分隔，依次表示开餐时间内按时间顺序每个单位时间进入食堂取餐的人数Pi。1 <=i<= N，0<= Pi<=100。
 * 输出描述：一个整数，能满足题目要求的最低供餐速度(每个单位时间需要做出多少份盒饭)。
 * 补充说明：每人只取一份盒饭。
 * 需要满足排队时间为0，必须保证取餐员工到达食堂时，食堂库存盒饭数量不少于本次来取餐的人数。
 * 第一个单位时间来取餐的员工只能取开餐前食堂准备好的盒饭。
 * 每个单位时间里制作的盒饭只能供应给后续单位时间来的取餐的员工。
 * 食堂在每个单位时间里制作的盒饭数量是相同的。
 * @case 3
 * 14
 * 10 4 5
 * return：3
 * @created 2023-11-02 16:02
 */
public class CanteenDeliverySpeed {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 开餐时长
		int n = in.nextInt();
		// 开餐前盒饭数
		int m = in.nextInt();
		// 单位时间进入食堂取餐的人数
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}

		// 测试提交，时间超限
		method1(n, m, nums);
		System.out.println();
		method2(n, m, nums);
	}

	public static void method1(int n, int m, int[] nums) {
		int left = 0;
		int right = Arrays.stream(nums).max().getAsInt();
		while (left < right) {
			int mid = (left + right + 1) / 2;
			if (check(nums, mid, m)) {
				// 猜大了
				right = mid;
			} else {
				// 猜小了
				left = mid + 1;
			}
		}
		System.out.println(left);
	}

	public static boolean check(int[] nums, int mid, int m) {
		int pre = m;
		for (int i = 0; i < nums.length; i++) {
			// i 时刻消耗盒饭数
			pre -= nums[i];
			// 盒饭不够
			if (pre < 0) {
				//System.out.println(mid +"不够");
				return false;
			}
			// i 时刻剩余盒饭数
			pre += mid;
		}
		//System.out.println(mid +"够");
		return true;
	}

	public static void method2(int n, int m, int[] nums) {
		// 按题意，出餐速度为 x，要保证不排队，则需要 i 时刻始终满足不等式 m+x*i(i时刻累计提供餐数) >= nums[0]+……nums[i](i时刻累计用餐人数)
		int currentSumNeeded = 0;
		// 初始化出餐速度
		int x = 0;
		int currentStock = m;
		for (int i = 0; i < n; i++) {
			currentStock = m + i * x;
			currentSumNeeded += nums[i];
			// i 时刻是否满足不等式
			if (currentStock < currentSumNeeded) {
				// 不满足条件，计算最小的 x（新值必定比当前的x大），确保 currentStock >= currentSumNeeded
				// 当 x 值变大，不等式的左边比以前更大。这意味着当 x 取新值（更大的值）时，这个不等式在 0 到 ( i - 1 )  一定是成立的。
				// 所以下一个 x 值一定满足条件 x >= (nums[0]+……nums[i]-m)/i
				int diff = currentSumNeeded - m;
				// 除不尽，向上取整
				if (diff % i != 0) {
					x = (diff / i) + 1;
				}
			}
		}
		System.out.println(x);
	}

}
