package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PublicTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		while (n > 0) {
			char[] arr = in.nextLine().toCharArray();
			// 统计字符出现次数
			Map<Character, Integer> map = new HashMap<>();
			for (Character cha : arr) {
				map.put(cha, map.getOrDefault(cha, 0) + 1);
			}
			List<Integer> list = new ArrayList<>(map.values());
			list.sort((a, b) -> b - a);
			//System.out.println(list.toString());

			int cur = 26;
			int res = 0;
			for (Integer a : list) {
				res += cur * a;
				cur--;
			}
			System.out.println(res);
			n--;
		}
	}
}