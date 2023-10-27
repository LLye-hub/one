package huaweiOd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 阿里巴巴找黄金宝箱5
 * 藏宝地有编号 0-n 的箱子，每个箱子贴有一个数字，念出一个咒语数字。
 * 是否存在两个不同的箱子，数字相同，且编号之差的绝对值小于等于咒语数字。
 * @case 6, 3, 1, 6
 * 3
 * return：0。存在，6
 * 5,6,7,5,6,7
 * 2
 * return：-1。不存在
 * @created 2023-10-27 15:42
 */
public class IfExistNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(",");
		int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
		int diff = Integer.parseInt(in.nextLine());

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (!map.containsKey(num)) {
				map.put(num, i);
			} else if (i - map.get(num) <= diff) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(-1);
	}
}
