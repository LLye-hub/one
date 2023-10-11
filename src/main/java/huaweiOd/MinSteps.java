package huaweiOd;

import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 求最小步数
 * 求从坐标零点到坐标点n的最小步数，一次只能沿坐标轴向左或向右移动2或3
 * 途径的坐标点可以为负数
 * @case 4
 * return：2（向右两步）
 * @created 2023-10-11 15:04
 */
public class MinSteps {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int res;
		if (n % 3 == 0) {
			res = n / 3;
		} else if (n % 3 == 2) {
			res = n / 3 + 1;
		} else {
			if (n == 1) {
				res = 2;
			} else {
				res = n / 3 + 1;
			}
		}
		System.out.println("从坐标零点到坐标点" + n + "的最小步数为" + res);
	}
}
