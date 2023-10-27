package huaweiOd;

import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 报文重排序
 * 每个子报文在原始报文中的顺序已知，现在需要恢复原始报文。
 * @case 4
 * rolling3 stone4 like1 a2
 * return：like a rolling stone
 * <p>
 * 8
 * gifts6 and7 Exchanging1 all2 precious5 things8 kinds3 of4
 * return: Exchanging all kinds of precious gifts and things
 * @created 2023-10-27 18:41
 */
public class RestoreBaowen {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String[] strs = in.nextLine().split(" ");
		String[] newStrs = new String[n];
		for (int i = 0; i < n; i++) {
			int len = strs[i].length();
			int idx = strs[i].charAt(len - 1) - '0';
			String str = strs[i].substring(0, len - 1);
			newStrs[idx - 1] = str;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(newStrs[i] + " ");
		}
	}
}
