package huaweiOd;

import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 箱子之形摆放
 * 输入一行字符串，通过空格分割，前面部分为字母或数字组成的字符串str，表示箱子，后面部分为一个数字n，表示空地的宽度
 * @case ABCDEFG 3
 * return：AFG
 * BE
 * CD
 * @created 2023-10-11 12:05
 */
public class PlaceBoxs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 箱子字符串
		String str = in.next();
		// 空地宽度，行数
		int n = in.nextInt();
		// 列数
		int len = str.length();
		int m = (int) Math.ceil(len * 1.0 / n);

		char[][] res = new char[n][m];
		int index = 0;
		for (int i = 0; i < m; i++) {
			if (i % 2 == 0) {
				// 从上到下，从左到右放置箱子
				for (int j = 0; j < n && index < len; j++) {
					res[j][i] = str.charAt(index++);
				}
			} else {
				// 从上到下，从右到左放置箱子
				for (int j = n - 1; j >= 0 && index < len; j--) {
					res[j][i] = str.charAt(index++);
				}
			}
		}
		// 输出结果
		for (int k = 0; k < n; k++) {
			System.out.println(String.valueOf(res[k]));
		}
	}
}
