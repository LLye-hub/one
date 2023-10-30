package huaweiOdAC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 阿里巴巴找黄金宝箱3
 * 一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0~N的箱子，每个箱子上面贴有一个数字。
 * 阿里巴巴念出一个咒语数字，查看宝箱是否存在两个不同箱子，这两个箱子上贴的数字相同，同时这两个箱子的编号之差的绝对值小于等于咒语数字。
 * 如果存在这样的一对宝箱，请返回最先找到的那对宝箱左边箱子的编号，如果不存在则返回-1。
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
				System.out.println(map.get(num));
				return;
			}
		}
		System.out.println(-1);
	}
}
