package huaweiOd;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 数仓开发-雨叶
 * @description 解压报文
 * 为了提升数据传输的效率，会对传输的报文进行压缩处理输入一个压缩后的报文，请返回它解压后的原始报文.
 * 压缩规则:n[str]，表示方括号内部的str正好重复n次。注意n为正整数(0<n<=100)，str只包含小写英文字母，不考虑异常情况
 * 输入描述：输入压缩后的报文
 * 1)不考虑无效的输入，报文没有额外的空格，方括号总是符合格式要求的;
 * 2)原始报文不包含数字，所有的数字只表示重复的次数n，例如不会出现像5或3[8]的输入
 * 输出描述：解压后的原始报文
 * @case 3[k]2[mn]
 * return：kkkmnmn
 * 3[m2[c]]
 * return：mccmccmcc
 * @created 2023-11-01 16:35
 */
public class DecodeMessage {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		//String input = "3[m2[c]2[n]]";

		method1(input);
		System.out.println();
		method2(input);
	}

	public static void method1(String strs) {
		char[] chars = strs.toCharArray();
		Stack<Character> stack = new Stack<>();
		String str = "";
		String num = "";
		char curChar;
		for (char s : chars) {
			if (s != ']') {
				// 非 ] 字符，无法解压
				stack.add(s);
			} else {
				// 遇到 ] 字符，开始解压
				//System.out.println("遇到 ] 字符，开始解压");
				if (!stack.empty()) {
					curChar = stack.pop();
					while (curChar != '[') {
						str = curChar + str;
						if (stack.empty()) {
							break;
						}
						curChar = stack.pop();
					}
					//System.out.println("str=" + str);
					curChar = stack.pop();
					while (!Character.isLetter(curChar)) {
						num = curChar + num;
						if (stack.empty()) {
							break;
						}
						curChar = stack.pop();
					}
					stack.add(curChar);
					int n = Integer.parseInt(num);
					//System.out.println("n=" + n);
					while (n > 0) {
						for (int i = 0; i < str.length(); i++) {
							stack.add(str.charAt(i));
						}
						n--;
					}
					num = "";
					str = "";
					//System.out.println(stack.toString());
				}

			}
		}
		String res = "";
		while (stack.size() > 1) {
			res = stack.pop() + res;
		}
		System.out.println(res);
	}

	public static void method2(String strs) {
		char[] chars = strs.toCharArray();
		Stack<Character> stack = new Stack<>();
		String str = "";
		String num = "";
		char curChar;
		for (char s : chars) {
			if (s != ']') {
				// 非 ] 字符，无法解压
				stack.add(s);
			} else {
				// 遇到 ] 字符，开始解压
				//System.out.println("遇到 ] 字符，开始解压");
				curChar = s;
				while (!stack.empty() && Character.isLetter(stack.peek())) {
					curChar = stack.pop();
					str = curChar + str;
				}
				//System.out.println("str=" + str);
				// 丢掉 '['
				stack.pop();
				while (!stack.empty() && Character.isDigit(stack.peek())) {
					curChar = stack.pop();
					num = curChar + num;
				}
				int n = Integer.parseInt(num);
				//System.out.println("n=" + n);
				while (n > 0) {
					for (int i = 0; i < str.length(); i++) {
						stack.add(str.charAt(i));
					}
					n--;
				}
				str = "";
				num = "";
				//System.out.println(stack.toString());
			}
		}
		String res = "";
		while (!stack.empty()) {
			res = stack.pop() + res;
		}
		System.out.println(res);
	}


}
