package org.example;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 数据组-雨叶
 * @description
 * @created 2023-06-25 15:59
 */
public class TestOfOrderOfMap {

	public static void main(String[] args) {
		TestOfOrderOfMap test = new TestOfOrderOfMap();

		HashMap hm1 = new HashMap();                   //第一组集合是用来测试int类型的key
		Hashtable ht1 = new Hashtable();
		TreeMap tm1 = new TreeMap();
		LinkedHashMap lhm1 = new LinkedHashMap();

		Integer a[] = new Integer[]{3, 2, 5, 1, 4};
		//Integer a[] = new Integer[]{13, 2, 5, 1, 4};
		//Integer a[] = new Integer[]{16, 2, 5, 1, 4};

		//测试Keyset中key为数字的排序
		System.out.println("这里是KeySet的测试：");
		test.testOfKeyset(hm1, a);
		test.testOfKeyset(ht1, a);
		test.testOfKeyset(tm1, a);
		test.testOfKeyset(lhm1, a);

		////测试Entryset中key为数字的排序
		//System.out.println();
		//System.out.println("这里是EntrySet的测试：");
		//test.testOfEntryset(hm1, a);
		//test.testOfEntryset(ht1, a);
		//test.testOfEntryset(tm1, a);
		//test.testOfEntryset(lhm1, a);

	}

	//测试Keyset的排序
	public void testOfKeyset(Map map, Object obj[]) {
		for (int i = 0; i < obj.length; i++) {
			map.put(obj[i], obj[i]);
		}

		if (map instanceof LinkedHashMap) {//LinkedHashMap也是一种HashMap，所以对其测试要放在前面
			System.out.println("LinkedHashMap" + ": " + map);
		} else if (map instanceof HashMap) {
			System.out.println("HashMap" + ": " + map);
		} else if (map instanceof Hashtable) {
			System.out.println("Hashtable" + ": " + map);
		} else if (map instanceof TreeMap) {
			System.out.println("TreeMap" + ": " + map);
		}

		System.out.print("key: ");
		Iterator it1 = map.keySet().iterator();
		while (it1.hasNext()) {
			Object key = it1.next();
			System.out.print(key + " " + map.get(key));
		}
	}

	//测试Entryset的排序
	//public void testOfEntryset(Map map, Object obj[]){
	//	for (int i = 0; i < obj.length; i++) {
	//		map.put(obj[i], obj[i]);
	//	}
	//
	//	if (map instanceof LinkedHashMap) {//LinkedHashMap也是一种HashMap，所以对其测试要放在前面
	//		System.out.println("LinkedHashMap" + ": " + map);
	//	} else if (map instanceof HashMap) {
	//		System.out.println("HashMap" + ": " + map);
	//	} else if (map instanceof Hashtable) {
	//		System.out.println("Hashtable" + ": " + map);
	//	} else if (map instanceof TreeMap) {
	//		System.out.println("TreeMap" + ": " + map);
	//	}
	//
	//	System.out.print("key: ");
	//	Iterator it2 = map.entrySet().iterator();
	//	while (it2.hasNext()) {
	//		Object key = it2.next();
	//		System.out.print(key + " " + map.get(key));
	//	}
	//}

}


