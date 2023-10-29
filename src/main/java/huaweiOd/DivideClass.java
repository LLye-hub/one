package huaweiOd;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author 数仓开发-雨叶
 * @description 分班
 * 幼儿园两个班的小朋友混在了一起，每位小朋友都知道自己是否与前面的一位小朋友是否同班，请帮忙把同班的小朋友找出来。
 * 小朋友编号为整数，与前一位小朋友同班用Y表示，不同班用N表示
 * @case 1/N 2/Y 3/N 4/Y
 * return: 1 2
 * 3 4
 * @created 2023-10-29 19:15
 */
public class DivideClass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(" ");

		Map<Integer, List<Integer>> classMap = new HashMap<>();
		classMap.put(1, new ArrayList<>());
		classMap.put(2, new ArrayList<>());

		String[] kid;
		int curClass = 1;
		for (int i = 0; i < strs.length; i++) {
			kid = strs[i].split("/");
			List<Integer> kids;
			if (i == 0 || StringUtils.equals(kid[1], "Y")) {
				// 第一个小朋友确定班级
				kids = classMap.get(curClass);
				kids.add(Integer.parseInt(kid[0]));
				classMap.put(curClass, kids);
			} else if (StringUtils.equals(kid[1], "N")) {
				curClass = curClass == 1 ? 2 : 1;
				kids = classMap.get(curClass);
				kids.add(Integer.parseInt(kid[0]));
				classMap.put(curClass, kids);
			}
		}

		// 输出结果
		//classMap.get(1).stream().forEach(System.out::print);
		System.out.println(classMap.get(1).stream().map(String::valueOf).collect(Collectors.joining(" ")));
		System.out.println(classMap.get(2).stream().map(String::valueOf).collect(Collectors.joining(" ")));

	}
}
