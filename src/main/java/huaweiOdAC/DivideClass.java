package huaweiOdAC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author 数仓开发-雨叶
 * @description 分班
 * 幼儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友是否同班，请你帮忙把同班的小朋友找出来。
 * 小朋友的编号为整数，与前一位小朋友同班用Y表示，不同班用N表示。
 * 输出：两行，每一行记录一个班小朋友的编号，编号用空格分开。 且:
 * 1. 编号需要按照大小升序排列，分班记录中第一个编号小的排在第一行；
 * 2. 若只有一个班的小朋友，第二行为空行；
 * 3. 若输入不符合要求，则直接输出字符串ERROR。
 * @case 1/N 2/Y 3/N 4/Y
 * return: 1 2
 * 3 4
 * @created 2023-10-29 19:15
 */
public class DivideClass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(" ");

		// 验证输入是否符合要求
		if (strs == null || strs.length == 0) {
			System.out.println("ERROR");
			return;
		}

		Map<Integer, List<Integer>> classMap = new HashMap<>();
		classMap.put(1, new ArrayList<>());
		classMap.put(2, new ArrayList<>());

		String[] kid;
		int curClass = 1;
		int num;
		for (int i = 0; i < strs.length; i++) {
			kid = strs[i].split("/");
			// 验证输入是否符合要求
			if (kid == null || kid.length == 0) {
				System.out.println("ERROR");
				return;
			}

			try {
				num = Integer.parseInt(kid[0]);
			} catch (NumberFormatException e) {
				System.out.println("ERROR");
				return;
			}
			List<Integer> kids;
			if (i == 0 || "Y".equals(kid[1])) {
				// 第一个小朋友确定班级
				kids = classMap.get(curClass);
				kids.add(num);
				classMap.put(curClass, kids);
			} else if ("N".equals(kid[1])) {
				curClass = curClass == 1 ? 2 : 1;
				kids = classMap.get(curClass);
				kids.add(num);
				classMap.put(curClass, kids);
			} else {
				System.out.println("ERROR");
				return;
			}
		}

		// 输出结果
		List<Integer> class1 = classMap.get(1);
		Collections.sort(class1);
		List<Integer> class2 = classMap.get(2);
		Collections.sort(class2);
		if (!class2.isEmpty() && class2.get(0) < class1.get(0)) {
			List<Integer> tmp = class1;
			class1 = class2;
			class2 = tmp;
		}
		System.out.println(class1.stream().map(String::valueOf).collect(Collectors.joining(" ")));
		System.out.println(class2.stream().map(String::valueOf).collect(Collectors.joining(" ")));

	}
}
