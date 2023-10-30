package huaweiOdAC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author 数仓开发-雨叶
 * @description 阿里巴巴找黄金宝箱2（AC）
 * 地上有编号0-N的箱子，每个箱子上贴有藏的金币数量。
 * 从金币数量中选出一个数字集合，并销毁贴有这些数字的箱子，如果能销毁一半以上的箱子，则返回这个数字集合的最小大小。
 * 输入：一个数字字串，逗号分隔
 * 输出：这个数字集合的最小大小
 * @case 1, 1, 1, 1, 3, 3, 3, 6, 6, 8
 * return: 2。选择集合{1,8}或{1,3}或{1,6}或{3,6}，销毁5个
 * @case 2, 2, 2, 2
 * return: 1
 * @created 2023-10-16 21:15
 */
public class NumberSetMin {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(",");
		int len = strs.length;
		// 统计各数字出现次数
		Map<String, Integer> map = new HashMap<>();
		for (String str : strs) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		List<Integer> cnts = map.values().stream().collect(Collectors.toList());
		cnts.sort((o1, o2) -> o2 - o1);
		// 计算总数占一半以上的数字个数
		int sum = 0, idx = 0;
		while (sum * 2 < len) {
			sum += cnts.get(idx);
			idx++;
		}
		System.out.println("这个数字集合的最小大小为 " + idx);
	}
}
