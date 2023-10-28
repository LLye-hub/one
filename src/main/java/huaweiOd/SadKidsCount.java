package huaweiOd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 不开心的小朋友
 * 每辆摇摇车同时只能有一个小朋友使用，没有空余的需等候或直接离开，最后没玩上的小朋友会非常不开心。
 * 请根据今天小朋友的来取情况，统计不开心的小朋友数量。
 * @case 1
 * 1 2 1 2
 * return: 0
 * <p>
 * 1
 * 1 2 2 3 1 3
 * return: 1
 * @created 2023-10-28 21:46
 */
public class SadKidsCount {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String[] strs = in.nextLine().split(" ");
		int[] kids = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

		List<Integer> play = new ArrayList<>();
		Queue<Integer> wait = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < kids.length; i++) {
			int kid = kids[i];
			if (play.contains(kid)) {
				// i 小朋友已经在玩，说明当前是离开
				play.remove(Integer.valueOf(kid));
				// 同时第一个等待的小朋友开始玩
				if (!wait.isEmpty()) {
					play.add(wait.poll());
				}
			} else if (wait.contains(kid)) {
				// i 小朋友已经在等待，说明当前是离开，不开心小朋友+1
				wait.poll();
				cnt++;
			} else if (play.size() < n) {
				// 有空余的摇摇车，i小朋友可以玩
				play.add(kid);
			} else {
				// 没有空余的摇摇车，i小朋友需要等候
				wait.add(kid);

			}
		}
		System.out.println("不开心的小朋友数量 = " + cnt);
	}

}
