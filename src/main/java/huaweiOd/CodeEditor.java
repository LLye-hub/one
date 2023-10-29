package huaweiOd;

import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 代码编辑器
 * 支持的指令如下：（X为大于等于0的整数，word为无空格字符串）
 * FORWORD X：指针向右移动，若超过了文本末尾，则移动到文本末尾
 * BACKWORD X：指针向左移动，若超过了文本开头，则移动到文本开头
 * SEARCH-FORWORD word：从指针当前位置向前查找word，并将指针移动到word的起始位置，未找到则不变
 * SEARCH-BACKWORD word：从指针当前位置向后查找word，并将指针移动到word的起始位置，未找到则不变
 * INSERT word：在指针当前位置前插入word，并将指针移动到word的结尾
 * REPLACE word：在指针当前位置替换并插入字符（删除原有字符，并增加新的字符）
 * DELETE X：在指针位置删除 X 个字符
 * 输入：第一行为命令列表的长度k
 * 第二行为文件的原始文本
 * 接下来的k行，每行为一个指令
 * @case 1
 * ello
 * INSERT h
 * return：hello。。。。。。。。。。
 * 2
 * hllo
 * FORWORD 1
 * INSERT e
 * return：hello。。。。。。。。。。
 * 2
 * hell
 * FORWORD 1000
 * INSERT o
 * return：hello。。。。。。。。。。
 * 1
 * hello
 * REPLACE HELLO
 * return：HELLO。。。。。。。。。。
 * 3
 * hello world
 * FORWORD 1000
 * SEARCH-FORWORD hello
 * REPLACE hi
 * return：HELLO。。。。。。。。。。
 * @created 2023-10-28 23:57
 */
public class CodeEditor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = Integer.parseInt(in.nextLine());
		String str = in.nextLine();
		// 初始化指针
		int idx = 0;
		while (k > 0) {
			String[] res = operate(idx, str, in.nextLine().split(" "));
			str = res[0];
			idx = Integer.parseInt(res[1]);
			k--;
		}
		System.out.println(str);

	}

	public static String[] operate(int idx, String str, String[] order) {
		int len = str.length();
		String word;
		int x;
		int id;
		switch (order[0]) {
			// 指针向右移动，若超过了文本末尾，则移动到文本末尾
			case "FORWORD":
				x = Integer.parseInt(order[1]);
				idx += x;
				idx = Math.min(len, idx);
				break;
			// 指针向左移动，若超过了文本开头，则移动到文本开头
			case "BACKWORD":
				x = Integer.parseInt(order[1]);
				idx -= x;
				idx = Math.max(0, idx);
				break;
			// 从指针当前位置向前查找word，并将指针移动到word的起始位置，未找到则不变
			case "SEARCH-FORWORD":
				word = order[1];
				id = str.substring(0, idx).indexOf(word);
				if (id != -1) {
					idx = id;
				}
				break;
			// 从指针当前位置向后查找word，并将指针移动到word的起始位置，未找到则不变
			case "SEARCH-BACKWORD":
				word = order[1];
				id = str.substring(idx, len).indexOf(word);
				if (id != -1) {
					idx = id;
				}
				break;
			// 在指针当前位置前插入word，并将指针移动到word的结尾
			case "INSERT":
				word = order[1];
				str = str.substring(0, idx) + word + str.substring(idx, len);
				idx += word.length();
				break;
			// 在指针当前位置替换并插入字符（删除原有字符，并增加新的字符）
			case "REPLACE":
				word = order[1];
				char[] chars = str.toCharArray();
				for (int i = idx; i < idx + word.length(); i++) {
					chars[i] = word.charAt(i - idx);
				}
				str = String.valueOf(chars);
				break;
			// 在指针位置删除 X 个字符
			case "DELETE":
				x = Integer.parseInt(order[1]);
				str = idx == 0 ? str.substring(idx + x, len) : str.substring(0, idx) + str.substring(idx + x, len);
				break;
		}
		return new String[]{str, String.valueOf(idx)};
	}
}
