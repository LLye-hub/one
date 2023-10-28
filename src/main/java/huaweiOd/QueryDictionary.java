package huaweiOd;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 查字典
 * 输入：单词前缀+字典长度+字典
 * 输出：换行输出所有包含该前缀的单词
 * @case b 3 a b c
 * return: b
 * <p>
 * abc 4 a ab abc abcd
 * return: abc abcd
 * <p>
 * a 3 b c d
 * return: -1
 * @created 2023-10-28 23:22
 */
public class QueryDictionary {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String prefix = in.next();
		int n = prefix.length();
		int len = in.nextInt();
		int cnt = 0;
		while (len > 0) {
			String word = in.next();
			if (word.length() >= n && StringUtils.equals(word.substring(0, n), prefix)) {
				cnt++;
				System.out.println(word);
			}
			len--;
		}
		if (cnt == 0) {
			System.out.println(-1);
		}

	}
}
