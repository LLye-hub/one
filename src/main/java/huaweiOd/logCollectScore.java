package huaweiOd;

import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 日志采集系统
 * 日志上报成功一条，奖励1分；每条日志每延迟1秒，扣1分；累积日志达到100条，必须立即上报
 * 计算首次上报能获得的最多积分数。
 * 输入为按时序产生的日志条数T1,T2,……,Tn。
 * @case 1 98 1
 * return: 98 (=98+1-1)
 * @case 50 60 1
 * return: 50 (=100-50)
 * @created 2023-10-10 17:02
 */
public class logCollectScore {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cnt = 0, delay = 0;
		int res = 0;
		while (in.hasNext()) {
			// 总上报条数是否超出100
			if (cnt >= 100) {
				break;
			}
			int cur = in.nextInt();
			// 当前时刻是否超过100条
			if (cur + cnt < 100) {
				res = Math.max(res, cur + cnt - delay);
			} else {
				res = Math.max(res, 100 - delay);
			}
			cnt += cur;
			delay += cnt;
		}
		System.out.println("首次上报能获得的最多积分数 = " + res);


	}
}
