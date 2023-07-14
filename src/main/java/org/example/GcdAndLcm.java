package org.example;

import java.util.Scanner;

/**
 * @author 数据组-雨叶
 * @description 输入两个正整数num1 和 num2，输出它们的最大公约数和最小公倍数
 * @created 2023-07-05 10:27
 */
public class GcdAndLcm {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num1 = in.nextInt();
		int num2 = in.nextInt();

		/* 暴力解法
		 * 遍历数字，能同时被i整除，i就是公约数
		 * */
		int gcd = 0;
		for (int i = 1; i <= Math.min(num1, num2); i++) {
			if (0 == num1 % i && 0 == num2 % i) {
				gcd = i;
			}
		}
		System.out.println(gcd + " " + num1 * num2 / gcd);


		/* 辗转相除法
		 * a % b = m
		 * 将 b 赋值给 a，m 赋值给 b，然后重复 a % b = m
		 * 当 b 为 0 时，a为最大公约数
		 * */
		//int lcm = num1*num2 / gcd(num1, num2);
		//System.out.println(gcd(num1, num2));
		//System.out.println(lcm);

	}

	public static int gcd(int num1, int num2) {
		if (num2 == 0) {
			return num1;
		}
		return gcd(num2, num1 % num2);
	}
}
