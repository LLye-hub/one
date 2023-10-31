package huaweiOdAC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 数据组-雨叶
 * @description 找出通过车辆最多颜色 (AC)
 * 在一个狭小的路口，每秒只能通过一辆车，假如车辆的颜色有三种，找出N秒内经过最多颜色的车辆数量。三种颜色编号为0，1，2
 * @case 0 1 2 1
 * 3
 * return：2
 * @case 0 1 2 1
 * 2
 * return：1
 * @case 0 1 2 1 2 2 1 0 0
 * 4
 * return：3
 * @created 2023-10-09 20:06
 */
public class FindMostTimesPassCar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> cars = new ArrayList<>();
		while (in.hasNext()) {
			cars.add(in.nextInt());
		}
		int len = cars.get(cars.size() - 1);
		System.out.println("len=" + len);
		// 初始化长度为3的数组，用于存放窗口内各颜色出现次数
		int[] counts = new int[]{0, 0, 0};
		int res = 0;
		for (int i = 0; i < cars.size() - 1; i++) {
			// 根据当前车辆颜色在数组指定位置+1
			counts[cars.get(i)]++;
			// 根据当前窗口前一车辆颜色在数组指定位置-1
			if (i >= len) {
				counts[cars.get(i - len)]--;
			}
			// 输出当前时间窗口内各颜色车辆数目
			System.out.println(Arrays.toString(counts));
			int max = Arrays.stream(counts).max().getAsInt();
			res = Math.max(res, max);
		}
		System.out.println("指定时间窗内经过最多颜色车辆数为：" + res);
	}

}

