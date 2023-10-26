package huaweiOd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 数仓开发-雨叶
 * @description boss的收入
 * 一个boss，其有若干一级分销，一级分销又有若干二级分销，每个分销只有唯一的上级分销。
 * 规定，每个月，下级分销需要将自己的总收入（自己的+下级交的）每满100元上交15元给自己的上级。
 * 现给出一组分销关系和每个分销的收入，请找出boss并计算出这个boss的收入。
 * 输入：第1行 为关系的总数量
 * 第二行开始 为 分销id 上级分销id 收入
 * 输出：boss id 和 总收入
 * @case 5
 * 1 0 100
 * 2 0 199
 * 3 0 200
 * 4 0 200
 * 5 0 200
 * return：0 120
 * @created 2023-10-26 17:33
 */
//5
//1 0 100
//2 0 199
//3 0 200
//4 0 200
//5 0 200
public class incomeOfBoss {

	private static Map<Integer, List<Integer>> graphMap = new HashMap<>();
	private static Map<Integer, Integer> moneyMap = new HashMap<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		Set<Integer> set = new HashSet<>();
		while (n > 0) {
			String[] strArr = in.nextLine().split(" ");
			// 直接上下级关系
			int lstId = Integer.parseInt(strArr[1]);
			int id = Integer.parseInt(strArr[0]);
			List<Integer> tmpList = graphMap.getOrDefault(lstId, new ArrayList<>());
			tmpList.add(id);
			graphMap.put(lstId, tmpList);
			// 收入关系
			moneyMap.put(id, Integer.parseInt(strArr[2]));
			// 所有下级
			set.add(id);

			n--;
		}
		//System.out.println(graphMap.toString());
		//System.out.println(moneyMap.toString());

		// 找boss
		int bossId = -1;
		for (Integer id : graphMap.keySet()) {
			if (!set.contains(id)) {
				bossId = id;
				System.out.print(id + " ");
			}
		}
		// 计算收入
		System.out.println(getMoney(bossId));
	}

	private static int getMoney(int bossId) {
		// 终止条件
		if (!graphMap.containsKey(bossId)) {
			//System.out.println(moneyMap.getOrDefault(bossId,0) / 100 * 15);
			return moneyMap.getOrDefault(bossId, 0) / 100 * 15;
		}
		// 计算 自己的+下级交的
		int income = moneyMap.getOrDefault(bossId, 0);
		List<Integer> list = graphMap.get(bossId);
		for (Integer id : list) {
			income = income + getMoney(id);
			//System.out.println("income=" + income);
		}
		return income;
	}
}
