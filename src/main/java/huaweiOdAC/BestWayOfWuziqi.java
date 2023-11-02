package huaweiOdAC;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 五子棋迷 AC
 * 张兵和王武是五子棋迷，工作之余经常切磋棋艺。这不，这会儿又下起来了。走了一会儿，轮张兵了，对着一条线思考起来了，这条线上的棋子分布如下
 * 用数组表示：-1 0 1 1 1 0 1 0 1 1
 * 棋子分布说明：
 * 1. -1代表白子，0代表空位，1 代表黑子
 * 2. 数组长度L，满足1 < L < 40，且L为奇数
 * 你得帮他写一个程序，算出最有利的出子位置。
 * 最有利定义：
 * 1. 找到一个空位(0)，用棋子(1/-1)填充该位置，可以使得当前子的最大连续长度变大
 * 2. 如果存在多个符合要求的位置，返回最靠近中间的较小的那个坐标；
 * 3. 如果不存在可行位置，直接返回-1:
 * 4. 连续长度不能超过5个(五字棋约束)
 * @case 1
 * -1 0 1 1 1 0 1 0 1 -1 1
 * return：5
 * @created 2023-11-01 22:21
 */
public class BestWayOfWuziqi {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cur = Integer.parseInt(in.nextLine());
		int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = nums.length;
		int mid = n / 2 + 1;

		int minIdx = -1;
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			if (num != 0) {
				continue;
			}
			// 当前位置为0，可以放置，判断前后一样的棋子数量
			int cnt = 1;
			int l = i - 1;
			while (l >= 0 && nums[l] == cur) {
				cnt++;
				l--;
			}
			int r = i + 1;
			while (r <= n - 1 && nums[r] == cur) {
				cnt++;
				r++;
			}
			// 更新最大连续长度的棋子坐标
			//System.out.println(i + " " + cnt + "===" + minIdx + " " + maxLen);
			if (cnt > 5) {
				continue;
			}
			if (cnt > maxLen) {
				// 更大连续长度 或 最靠近中间的较小的那个坐标
				minIdx = i;
				maxLen = cnt;
			} else if (cnt == maxLen && Math.abs(i - mid) < Math.abs(minIdx - mid)) {
				minIdx = i;
			}
		}
		System.out.println(minIdx);
	}
}
