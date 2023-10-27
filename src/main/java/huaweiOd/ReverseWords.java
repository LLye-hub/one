package huaweiOd;

import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 按单词下标区间翻转文章内容
 * 给定一段英文文章片段，由若干单词组成，空格间隔。请翻转片段中指定区间的单词顺序并返回翻转后的内容。
 * @case I am a developer
 * 1
 * 2
 * return: I a am developer
 * <p>
 * hello world
 * -1
 * 1
 * return: world hello。下标小于0，从第一个单词开始
 * <p>
 * I am a developer
 * 0
 * 5
 * return: developer a am I。下标大于实际单词个数，则按照最大下标算
 * <p>
 * I am a developer
 * -2
 * -1
 * return: I am a developer。翻转无效
 * @created 2023-10-27 16:39
 */
public class ReverseWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] words = in.nextLine().split(" ");
		int n1 = Integer.parseInt(in.nextLine());
		int n2 = Integer.parseInt(in.nextLine());

		int idMax = words.length - 1;
		if (!(n1 > idMax || n2 <= 0 || n2 <= n1)) {
			n1 = Math.max(n1, 0);
			n2 = Math.min(n2, idMax);

			String tmp;
			while (n1 < n2) {
				tmp = words[n1];
				words[n1++] = words[n2];
				words[n2--] = tmp;
			}
		}
		for (int i = 0; i <= idMax; i++) {
			System.out.print(words[i] + " ");
		}
	}
}
