package huaweiOd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author 数仓开发-雨叶
 * @description 计算堆栈中的剩余数字
 * 向一个空栈中依次存入正整数，假设入栈元素 n(1<=n=2^31-1)按顺序依次为 nx...n4、n3、n2、n1,
 * 每当元素入栈时，如果 n1=n2+...+ny(y 的范围[2,x]，1<=x<=1000)，则 n1~ny 全部元素出栈，重新入栈新元素 m(m=2*n1)
 * 如: 依次向栈存入 6、1、2、3, 当存入 6、 1、2 时，栈底至栈顶依次为[6、 1、2];
 * 当存入 3 时 3=2+1，3、2、1 全部出栈，重新入栈元素 6(6=2*3)，此时栈中有元素 6;
 * 因为 6=6，所以两个 6 全部出栈，存入 12，最终栈中只剩一个元素 12
 * <p>
 * 输入描述：使用单个空格隔开的正整数的字符串，如”5 6 7 8”，左边的数字先入栈，输入的正整数个数为,1<=X<=1000
 * 输出描述：最终栈中存留的元素值，元素值使用空格隔开，如”8 7 6 5”，栈顶数字在左边6 1 2 3
 * @case 5 10 20 50 85 1
 * return: 1 170。5+10+20+50=85，输入85时全部出栈，入栈170，入栈1
 * 6 7 8 13 9
 * return: 9 13 8 7 6
 * 1 2 5 7 9 1 2 2
 * return: 4 1 9 14 1
 * 1 14 2 5 7
 * return: 28 1
 * @created 2023-10-31 23:55
 */
public class ComputeOtherNumberOfStack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(" ");
		int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

		// 方法一有瑕疵，覆盖用例不全。还是应该用递归做法
		method1(nums);
		System.out.println();
		method2(nums);

	}

	public static void method1(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num == sum) {
				// 当前数字 = 栈内数字总和
				stack.clear();
				stack.add(num * 2);
			} else if (num > sum) {
				// 当前数字 > 栈内数字总和
				stack.add(num);
			} else {
				// 当前数字 < 栈内数字总和，num < sum
				if (ifExists(stack, num)) {
					// 存在栈顶元素之和 == 当前数字
					stack.add(num * 2);
				} else {
					stack.add(num);
				}
			}
			sum += num;
		}
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
		return;
	}

	public static boolean ifExists(Stack<Integer> stack, int num) {
		int sum = 0;
		Stack<Integer> tmpStack = new Stack<>();
		while (!stack.isEmpty()) {
			int tmp = stack.pop();
			tmpStack.add(tmp);
			sum += tmp;
			if (sum == num) {
				return true;
			}
		}
		while (!tmpStack.empty()) {
			stack.add(tmpStack.pop());
		}
		return false;
	}

	public static void method2(int[] nums) {
		List<Integer> stack = new ArrayList<>();
		stack.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			push(nums[i], stack);
			//System.out.println(stack.toString());
		}
		// 打印结果
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.print(stack.get(i) + " ");
		}
		return;
	}

	public static void push(int num, List<Integer> stack) {
		int sum = num;
		int len = stack.size();
		// 从栈顶依次计算求和能否 = num
		for (int i = len - 1; i >= 0; i--) {
			sum -= stack.get(i);
			// 判断是否满足条件 n1=n2+...+ny
			if (sum == 0) {
				// 满足条件，弹出栈顶元素
				stack.subList(i, len).clear();
				// num * 2 是新元素，也需要进行条件判断
				push(num * 2, stack);
				// 直接返回
				return;
			} else if (sum < 0) {
				// 不满足，跳出循环
				break;
			}
		}
		stack.add(num);
		return;
	}
}
