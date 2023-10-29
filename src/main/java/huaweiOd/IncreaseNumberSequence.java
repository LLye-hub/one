package huaweiOd;

import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 非严格递增连续数字序列
 * 输入一个字符串仅包含大小写字母和数字，求字符串中包含的最长的非严格递增连续数字序列的长度（如12234）
 * @case abc2234019A334bc
 * return: 4。数字序列2234
 * abc2234013579A334bc
 * return: 6。数字序列013579
 * @created 2023-10-29 17:15
 */
public class IncreaseNumberSequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] chars = in.nextLine().toCharArray();
		int len = chars.length;
		int max = 0;
		int cur = 0;
		char lastChar = '0';
		for (int i = 0; i < len; i++) {
			char cha = chars[i];
			if (!Character.isDigit(cha)) {
				// 当前字符非数字，初始化变量
				cur = Character.isDigit(cha) ? 1 : 0;
				lastChar = '0';
			} else if (cha - lastChar >= 0) {
				// 当前字符是数字，且满足非严格递增
				cur++;
				lastChar = cha;
				max = Math.max(max, cur);
			} else {
				// 当前字符是数字，但不满足非严格递增，初始化变量
				cur = 1;
				lastChar = cha;
			}
		}
		System.out.println(max);
	}

}
