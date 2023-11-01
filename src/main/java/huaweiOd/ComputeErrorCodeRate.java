package huaweiOd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 计算误码率
 * 误码率 是最常用的数据通信传输质量指标。它可以理解为“在多少位数据中出现一位差错”。
 * 移动通信网络中的误码率主要是指比特误码率，其计算公式如下：比特误码率=错误比特数/传输总比特数，
 * 为了简单，我们使用字符串来标识通信的信息，一个字符错误了，就认为出现了一个误码输入一个标准的字符串，和一个传输后的字符串，计算误码率字符串会被压缩，
 * 例："2A3B4D5X1Z"表示"AABBBDDDDXXXXXZ"
 * 用例会保证两个输入字符串解压后长度一致，解压前的长度不一定一致,每个生成后的字符串长度<100000000。
 * 输入描述：两行，分别为两种字符串的压缩形式。每行字符串(压缩后的)长度<100000
 * 输出描述：一行，错误的字等数量/展开后的总长度
 * @case 3A3B
 * 2A4B
 * return：1/6
 * 5Y5Z
 * 5Y5Z
 * return：0/10
 * 4Y5Z
 * 9Y
 * return：5/9
 * @created 2023-11-01 12:21
 */
public class ComputeErrorCodeRate {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String code1 = in.nextLine();
		String code2 = in.nextLine();
		List<String> decode1 = decode(code1);
		List<String> decode2 = decode(code2);
		int n = decode1.size();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (!decode1.get(i).equals(decode2.get(i))) {
				cnt++;
			}
		}
		System.out.println(cnt + "/" + n);
	}

	public static List<String> decode(String code1) {
		String str1 = code1.replaceAll("[A-Z]", " ");
		int[] nums = Arrays.stream(str1.split(" ")).mapToInt(Integer::parseInt).toArray();
		String str2 = code1.replaceAll("[0-9]", "");
		String[] strs = str2.split("");
		int n = strs.length;
		List<String> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int total = nums[i];
			while (total > 0) {
				res.add(strs[i]);
				total--;
			}
		}
		return res;
	}

}
