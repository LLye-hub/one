package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author 数仓开发-雨叶
 * @description 喊7的次数重排
 * 喊7是一个传统的聚会游戏，N个人围成一圈，按顺时针从1到N编号。
 * 编号为1的人从1开始喊数，下一个人喊的数字为上一个人的数字加1，但是当数字是7的倍数或者数字本身含有7的话，要喊"过"。
 * 现给定一个长度为N的数组，存储了打乱顺序的每个人喊"过"的次数，请把它还原成正确的顺序，即数组的第i个元素存储编号i的人喊"过"的次数。
 * @case 0 1 0
 * return: 1 0 0。只喊了一次7，发生在数字7，编号1的人会遇到
 * 0 0 0 2 1
 * return: 0 2 0 1 0
 * @created 2023-10-31 14:50
 */
public class ReorderCall7 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(" ");
		int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
		// 参与人数
		int n = nums.length;
		// 计算喊 7 的总次数
		int cnt = Arrays.stream(nums).sum();
		// 初始化
		int[] res = new int[n];
		int num = 1;
		while (cnt > 0) {
			// 判断是否需要喊 7
			if (ifCall(num)) {
				res[(num - 1) % n]++;
				cnt--;
			}
			num++;
		}
		System.out.println(Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}

	public static boolean ifCall(int num) {
		// 数字是7的倍数
		if (num % 7 == 0) {
			return true;
		}
		// 数字本身含有7
		while (num > 0) {
			if (num % 10 == 7) {
				return true;
			} else {
				num /= 10;
			}
		}
		return false;
	}
}
