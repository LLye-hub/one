package huaweiOdAC;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 知识图谱新词挖掘1（AC）
小华负责公司知识图谱产品，现在要通过新词挖掘完善知识图谱。
新词挖掘：给出一个待挖掘文本内容字符串content和一个词的字符串word，找到content中所有word的新词。
新词：使用词word的字符排列形成的字符串。
请帮小华实现新词挖掘，返回发现的新词的数量。
 * 输入描述：第一行为待挖掘文本内容content
 * 第二行为词word
 * 输出描述：在content中找到所有word的新词数量
 * @case qweebaewqd
 * qwe
 * return：2
 * @case abab
 * ab
 * return：3
 * @created 2023-10-10 20:45
 */
public class NewWordCounts {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String content = in.nextLine();
		String word = stringSort(in.nextLine());
		int len = word.length();
		int res = 0;
		for (int i = 0; i <= content.length() - len; i++) {
			String newWord = content.substring(i, i + len);
			if (StringUtils.equals(word, stringSort(newWord))) {
				res++;
			}
		}
		System.out.println("在content中找到所有word的新词数量 = " + res);
	}


	private static String stringSort(String str) {
		char[] wordChars = str.toCharArray();
		Arrays.sort(wordChars);
		return String.valueOf(wordChars);
	}


}
