package huaweiOd;

import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description 经典屏保
 * DVD机在视频输出时，为了保护电视显像管，在待机状态会显示“屏保动画”，如下图所示，DVD Logo在屏幕内来回运动，碰到边缘会反弹:
 * 请根据如下要求，实现屏保Logo坐标的计算算法
 * 1、屏幕是一个800*600像素的矩形，规定屏幕的左上角点坐标原点，沿横边向右方向为X轴，沿竖边向下方向为Y轴
 * 2、Logo是一个50*25像素的矩形，初始状态下，左上角点坐标记做(x，)，它在X和Y方向上均以1像素/秒的速度开始运动;
 * 3、遇到屏幕四个边缘后，会发生镜面反弹，即以45°碰撞边缘，再改变方向以45°弹出:
 * 当Logo和四个角碰撞时，两个边缘同时反弹的效果是Logo会原路返回。
 * 请编码实现，t秒后Logo左上角点的坐标
 * <p>
 * 输入描述:输入3个数字，以空格分隔:x y t
 * 第一个数字表示Logo左上角点的初始X坐标
 * 第二个数字表示Logo左上角点的初始Y坐标:
 * 第三个数字表示时间t，题目要求即求t秒后Logo左上角点的位置
 * 输出描述：输出2个数字，以空格分隔:x y
 * 第一个数字表示t秒后，Logo左上角点的X坐标第二个数字表示t秒后，Logo左上角点的Y坐标
 * @case 0 0 10
 * return: 10 10
 * 500 570 10
 * return: 510 570
 * @created 2023-11-01 17:57
 */
public class CoordinatesOfLogo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt(); // x 在[0,750]区间
		int y = in.nextInt(); // y 在[0,575]区间
		int t = in.nextInt();
		//System.out.println("x=" + x + "y=" + y + "t=" + t);

		// 初始化遍历方向
		int nextX = 1; // 1向右-1向左
		int nextY = 1; // 1向下-1向上
		// 遍历时间
		while (t > 0) {
			// 判断logo是否碰到边缘
			// 左上(x,y)，左下(x,y+25)，右上(x+50,y)，右下(x+50,y+25)
			if ((x == 0 && y == 0) || (x == 0 && y == 575) || (x == 750 && y == 0) || (x == 750 && y == 575)) {
				// 碰到四个角
			} else if (x == 0 || x == 750) {
				// 仅碰到左边或右边
				nextX = (nextX == 1) ? -1 : 1;
			} else if (y == 0 || y == 575) {
				// 仅碰到上边或下边
				nextY = (nextY == 1) ? -1 : 1;

			}
			// 下一时刻logo坐标
			x += nextX;
			y += nextY;
			t--;
		}
		System.out.println(x + " " + y);
	}
}
