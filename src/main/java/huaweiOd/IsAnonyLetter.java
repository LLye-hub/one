package huaweiOd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 数仓开发-雨叶
 * @description 分界线
 * 输入描述：第一行为newspaper内容，包含1-N个字符串，用空格分开
 * 第二行为anonymousLetter内容，包含1-N个字符串，用空格分开
 * 1、字符串由小写英文字母组成且每个字母只能使用一次
 * 2、newspaper的每个字符顺序可随意调整，但必须保证字符串完整性
 * 3、1<N<100
 * 输出描述：报纸能拼成匿名信返回true，否则false。
 * @case ab cd
 * ab
 * return：true
 * @case ab ef
 * aef
 * return：false
 * @case ab bcd ef
 * cbd ef
 * return：true
 * @case ab bcd ef
 * cd ef
 * return：false
 * @created 2023-10-10 17:49
 */
public class IsAnonyLetter {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] news = in.nextLine().split(" ");
		String[] letters = in.nextLine().split(" ");

		//System.out.println(Arrays.toString(news));
		//System.out.println(Arrays.toString(letters));

		Set<String> dict = new HashSet<String>();
		for (int i = 0; i < news.length; i++) {
			char[] chars = news[i].toCharArray();
			Arrays.sort(chars);
			dict.add(String.valueOf(chars));
		}
		boolean res = true;
		for (int i = 0; i < letters.length; i++) {
			char[] chars = letters[i].toCharArray();
			Arrays.sort(chars);
			String sortedLetter = String.valueOf(chars);
			if (!dict.contains(sortedLetter)) {
				res = false;
			}
		}

		System.out.println("报纸能拼成匿名信的结果 = " + res);
	}
}
