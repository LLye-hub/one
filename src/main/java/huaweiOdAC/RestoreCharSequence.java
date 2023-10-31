package huaweiOdAC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author 数仓开发-雨叶
 * @description 恢复数字序列 (AC)
 * 对于一个连续正整数组成的序列，可以将其拼接成一个字符串，再将字符串里的部分字符打乱顺序。
 * 如序列8 9 10 11 12,拼接成的字符串为89101112,打乱一部分字符后得到90811211,原来的正整数10就被拆成了0和1。
 * 现给定一个按如上规则得到的打乱字符的字符串，请将其还原成连续正整数序列，并输出序列中最小的数字。
 * 输入描述：
 * 输入一行，为打乱字符的字符串和正整数序列的长度，两者间用空格分隔，字符串长度不超过200,正整数不超过1000,保证输入可以还原成唯一序列。
 * 输出描述：
 * 输出一个数字，为序列中最小的数字。
 * @case 19801211 5
 * reutrn：8
 * 432111111111 4
 * return：111
 * @created 2023-10-31 18:06
 */
public class RestoreCharSequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] input = in.nextLine().split(" ");

		// 顺序排列被打乱的数字序列
		char[] chars = input[0].toCharArray();
		Arrays.sort(chars);
		String str1 = String.valueOf(chars);
		//System.out.println(str1);

		// 初始化长度为 k 的窗口数组
		int k = Integer.parseInt(input[1]);
		List<Integer> win = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			win.add(i);
		}
		// 遍历2-1000，滑窗统计窗口内出现的字符
		String str2;
		for (int i = 1; i <= 1000 - k; i++) {
			win.remove(Integer.valueOf(i - 1));
			win.add(i + k - 1);
			str2 = reorder(win);
			//System.out.println(i + " " + str2);
			if (str1.equals(str2)) {
				System.out.println(i);
				return;
			}
		}

	}

	// 顺序排列被打乱的数字序列
	public static String reorder(List<Integer> win) {
		String str1 = win.stream().map(String::valueOf).collect(Collectors.joining());
		char[] chars = str1.toCharArray();
		Arrays.sort(chars);
		return String.valueOf(chars);
	}
}
