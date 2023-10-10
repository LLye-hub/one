package huaweiOd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 数据组-雨叶
 * @description 相同数字的积木游戏1
 * 小华和小薇一起玩积木，每个积木上有一个数字，积木块上的数字可能相同。
 * 小华随机拿出一些积木挨成一排，请小薇找到这排积木中数字相同且所处位置最远的2块积木，计算他们之间的距离。
 * 第一个数字为积木总数N，接下来N个数字为排成一排的积木数字
 * @case 5 1 2 3 1 4
 * return: 3
 * @case 2 1 2
 * return: -1(没有相同数字)
 * @case 8 1 2 3 1 4 3 2 1
 * return: 3
 * @created 2023-10-10 11:47
 */
public class sameNumberJimuGame1 {
	public static void main(String[] args) {
		// 解法1
		//main1();
		// 解法2
		main2();
	}

	public static void main1() {
		Scanner in = new Scanner(System.in);
		// 积木总数
		int n = in.nextInt();
		Map<Integer, List<Integer>> map = new HashMap<>();
		int i = 0;
		int res = -1;
		while (i < n) {
			int num = in.nextInt();
			List<Integer> pos = map.getOrDefault(num, new ArrayList<>());
			pos.add(i);
			map.put(num, pos);
			if (pos.size() > 1) {
				res = Math.max(res, i - pos.get(0));
			}
			i++;
		}
		System.out.println("数字相同且所处位置最远的2块积木之间的距离 = " + res);
	}

	public static void main2() {
		Scanner in = new Scanner(System.in);
		// 积木总数
		int n = in.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		int res = -1;
		while (i < n) {
			int num = in.nextInt();
			if (map.containsKey(num)) {
				res = Math.max(res, i - map.get(num));
			} else {
				// 记录数字第一次出现的位置
				map.put(num, i);
			}
			i++;
		}
		System.out.println("数字相同且所处位置最远的2块积木之间的距离 = " + res);
	}
}
