package huaweiOd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 数仓开发-雨叶
 * @description 告警抑制
 * 高优先级告警抑制低优先级告警的规则。高优先级告警产生后，低优先级告警不再产生。请根据原始告警列表和告警抑制关系，给出实际产生的告警列表。
 * 输入：第一行数字n，表示告警抑制关系个数
 * 接下来n行，表示告警一种关系。如：A B，表示 A 抑制 B，告警id的格式为大写字母+0或1个数字
 * 最后一行为告警产生列表
 * @case 2
 * A B
 * B C
 * A B C D E
 * return：A D E。A抑制了B，B抑制了C
 * 4
 * F G
 * C B
 * A G
 * A0 A
 * A B C D E
 * return：A C D E。C抑制了B
 * @created 2023-10-29 21:01
 */
public class TrueAlarmList {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		// 告警抑制关系
		String[][] rules = new String[n][2];
		for (int i = 0; i < n; i++) {
			rules[i] = in.nextLine().split(" ");
		}
		// 原始告警列表
		String[] alarmList = in.nextLine().split(" ");
		Set<String> alarmSet = new HashSet<>(Arrays.asList(alarmList));

		// 被抑制告警
		Set<String> deleteSet = new HashSet<>();
		// 遍历告警规则，汇总原始列表中会被抑制的告警
		for (String[] rule : rules) {
			String highAlarm = rule[0];
			String lowAlarm = rule[1];
			if (alarmSet.contains(highAlarm)) {
				deleteSet.add(lowAlarm);
			}
		}
		// 遍历原始告警列表，剔除被抑制的告警
		for (String alarm : alarmList) {
			if (deleteSet.contains(alarm)) {
				continue;
			}
			System.out.print(alarm + " ");
		}
	}
}
