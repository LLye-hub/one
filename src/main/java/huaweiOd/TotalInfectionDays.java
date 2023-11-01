package huaweiOd;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author 数仓开发-雨叶
 * @description 计算疫情扩散时间
 * 在一个地图中(地图由n*n个区域组成），有部分区域被感染病菌。 感染区域每天都会把周围（上下左右）的4个区域感染。
 * 请根据给定的地图计算，多少天以后，全部区域都会被感染。 如果初始地图上所有区域全部都被感染，或者没有被感染区域，返回-1
 * @case 1, 0, 1, 0, 0, 0, 1, 0, 1
 * return：2
 * 0,0,0,0
 * return：-1
 * 1,1,1,1,1,1,1,1,1
 * return：-1
 * @created 2023-11-01 14:28
 */
public class TotalInfectionDays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> nums = Arrays.stream(in.nextLine().split(",")).map(Integer::valueOf).collect(Collectors.toList());
		int n = (int) Math.sqrt(nums.size());

		if (!nums.contains(0) || !nums.contains(1)) {
			System.out.println(-1);
			return;
		}

		// 判断是否被全部感染
		int days = 0;
		// 初始化指针
		int i, j, idx;
		Stack<Integer> stack = new Stack<>();
		while (nums.contains(0)) {
			days++;
			for (int k = 0; k < nums.size(); k++) {
				// 当前元素在地图中的索引
				i = k / n;
				j = k % n;
				// 判断是否感染上下左右，(i-1,j), (i+1,j), (i,j-1), (i,j+1)
				if (nums.get(k) == 1) {
					if (i >= 1) {
						stack.add((i - 1) * n + j);
					}
					if (i < n - 1) {
						stack.add((i + 1) * n + j);
					}
					if (j >= 1) {
						stack.add(i * n + j - 1);
					}
					if (j < n - 1) {
						stack.add(i * n + j + 1);
					}
				}
			}
			while (!stack.empty()) {
				nums.set(stack.pop(), 1);
			}
			System.out.println(nums.toString());
		}
		System.out.println(days);
	}

}
