package huaweiOd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author 数仓开发-雨叶
 * @description 预定酒店
 * 小明决定到某旅游景点游玩，他在网上搜索了各种价位的酒店（长度为n的数组A）
 * 他的心理价位是x元，请帮他筛选出k个最接近x元的酒店(n>=k>0)，并由低到高打印酒店价格。
 * 0 < n,k,x < 10000
 * @case 10 5 6
 * 1 2 3 4 5 6 7 8 9 10
 * return: 4 5 6 7 8
 * @case 10 4 6
 * 10 9 8 7 6 5 4 3 2 1
 * return: 4 5 6 7
 * @case 6 3 1000
 * 30 30 200 500 70 300
 * return: 200 300 500
 * @created 2023-10-10 14:46
 */
public class reserveHotel {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int x = in.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = in.nextInt();
		}
		// 解法1
		solution1(n, k, x, prices);
		System.out.println();
		// 解法2
		solution2(n, k, x, prices);
		System.out.println();
		// 解法3
		solution3(n, k, x, prices);
		System.out.println();

	}

	public static void solution1(int n, int k, int x, int[] prices) {

		System.out.print(k + "个最接近" + x + "元的酒店为：");

		// 计算所有酒店价格与心理价位的价差
		Arrays.sort(prices);
		Map<Integer, List<Integer>> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			int diff = Math.abs(prices[i] - x);
			List<Integer> pos = map.getOrDefault(diff, new ArrayList<>());
			pos.add(prices[i]);
			map.put(diff, pos);
		}
		// 筛选出k个最接近x元的酒店
		List<Integer> res = new ArrayList<>();
		for (Integer key : map.keySet()) {
			//System.out.println(key);
			List<Integer> pos = map.get(key);
			int i = 0;
			while (k > 0) {
				if (i >= pos.size()) {
					break;
				}
				res.add(pos.get(i));
				i++;
				k--;
			}
		}
		// 升序输出结果
		Collections.sort(res);
		for (int price : res) {
			System.out.print(price + " ");
		}
	}

	public static void solution2(int n, int k, int x, int[] prices) {

		System.out.print(k + "个最接近" + x + "元的酒店为：");

		// 计算所有酒店价格与心理价位的价差
		Arrays.sort(prices);
		// 创建一个二维数组，用于存放酒店价格和与心理价位价差
		int[][] price_rating = new int[n][2];
		for (int i = 0; i < n; i++) {
			price_rating[i][0] = prices[i];
			price_rating[i][1] = Math.abs(prices[i] - x);
		}
		// 按价差排序，获取前k个酒店价格
		Arrays.sort(price_rating, new MyComparator());
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(price_rating[i][0]);
		}
		// 升序输出结果
		Collections.sort(res);
		for (int price : res) {
			System.out.print(price + " ");
		}
	}

	public static void solution3(int n, int k, int x, int[] prices) {

		System.out.print(k + "个最接近" + x + "元的酒店为：");

		// 计算所有酒店价格与心理价位的价差
		Arrays.sort(prices);
		// 创建一个二维数组，用于存放酒店价格和与心理价位价差
		int[][] price_rating = new int[n][2];
		for (int i = 0; i < n; i++) {
			price_rating[i][0] = prices[i];
			price_rating[i][1] = Math.abs(prices[i] - x);
		}
		// 按价差排序，获取前k个酒店价格
		Arrays.sort(price_rating, Comparator.comparingInt(o -> o[1]));
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(price_rating[i][0]);
		}
		// 升序输出结果
		Collections.sort(res);
		for (int price : res) {
			System.out.print(price + " ");
		}
	}

	static class MyComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] arr1, int[] arr2) {
			return arr1[1] - arr2[1];
		}
	}

}
