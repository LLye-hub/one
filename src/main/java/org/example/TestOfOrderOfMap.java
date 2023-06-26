package org.example;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 数据组-雨叶
 * @description HashMap、Hashtable、TreeMap、LinkedHashMap的内部排序
 * 1) 当key的值不超过16时，HashMap的存取是按照从小到大的顺序来存取的
 * 2) 当key的个数不超过11且key的值不超过11时，Hashtable的存取是按照从大到小的顺序来存取的
 * @linked https://blog.csdn.net/wshi215/article/details/72860853
 * @created 2023-06-25 15:59
 */
public class TestOfOrderOfMap {

	public static void main(String[] args) {
		TestOfOrderOfMap test = new TestOfOrderOfMap();

		HashMap hm1 = new HashMap();
		Hashtable ht1 = new Hashtable();
		TreeMap tm1 = new TreeMap();
		LinkedHashMap lhm1 = new LinkedHashMap();

		Integer a[] = new Integer[]{3, 2, 5, 1, 4};
		Integer b[] = new Integer[]{13, 2, 5, 1, 4};
		Integer c[] = new Integer[]{16, 2, 5, 1, 4};

		//测试Keyset中key为数字的排序
		System.out.println("这里是KeySet的测试{3, 2, 5, 1, 4}：");
		test.testOfKeyset(hm1, a);
		test.testOfKeyset(ht1, a);
		test.testOfKeyset(tm1, a);
		test.testOfKeyset(lhm1, a);
		System.out.println();

		System.out.println("这里是KeySet的测试{13, 2, 5, 1, 4}：");
		test.testOfKeyset(hm1, b);
		test.testOfKeyset(ht1, b);
		test.testOfKeyset(tm1, b);
		test.testOfKeyset(lhm1, b);
		System.out.println();

		System.out.println("这里是KeySet的测试{16, 2, 5, 1, 4}：");
		test.testOfKeyset(hm1, c);
		test.testOfKeyset(ht1, c);
		test.testOfKeyset(tm1, c);
		test.testOfKeyset(lhm1, c);

	}

	//测试Keyset的排序
	public void testOfKeyset(Map map, Object obj[]) {
		for (int i = 0; i < obj.length; i++) {
			map.put(obj[i], obj[i]);
		}

		if (map instanceof LinkedHashMap) {//LinkedHashMap也是一种HashMap，所以对其测试要放在前面
			System.out.print("LinkedHashMap" + ": " + map);
		} else if (map instanceof HashMap) {
			System.out.print("HashMap" + ": " + map);
		} else if (map instanceof Hashtable) {
			System.out.print("Hashtable" + ": " + map);
		} else if (map instanceof TreeMap) {
			System.out.print("TreeMap" + ": " + map);
		}

		System.out.print("        key: ");
		Iterator it1 = map.keySet().iterator();
		while (it1.hasNext()) {
			Object key = it1.next();
			System.out.print(key + " ");
		}
		System.out.println();
	}
}


