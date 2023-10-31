package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 数据组-雨叶
 * @Description
 * @created 2022-01-25 15:47
 */
public class HelloWorld {

	public static void main(String[] args) {

		String[] array = {"apple", "banana", "orange"};
		// 使用 Arrays.asList() 将数组转换为列表
		List<String> list1 = new ArrayList<>(Arrays.asList(array));
		// 使用流和 Collectors.toList() 将数组转换为列表
		List<String> list2 = Arrays.stream(array).collect(Collectors.toList());


		//String str = "Hello World !";
		//System.out.println(str.substring(0, -1));

		//System.out.println("Hello World !");
		//
		//System.out.println(Objects.equals(null, 1));
		//
		//String a = "hello";
		//String b = "hel lo";
		//System.out.println(a == b);

		//System.out.println((1<<(1-1))-1);

		//String strs = "A 1 0 1 1150175017(&^%&$vabovbaoadd 123#$%#%#O";
		//String strs1 =strs.replace("1","");
		//System.out.println(strs1);

		// 字母大小写转换
		//System.out.println((char) ('h' - 'a' + 'A'));
		//System.out.println((char) ('h' - 'A' + 'a'));
		//System.out.println((char) ('h' - 32));
		//System.out.println('h' - 'H');
		//System.out.println('H' - 'h');
		//System.out.println((char) 72);


		//System.out.println(2 << 1);

		//int[][] arr2 = new int[][]{{0,1},{1,2},{3,0}};
		//System.out.println(Arrays.toString(arr2[0]));

		//List<Integer> arr = new ArrayList<>();
		//arr.add(1);
		//arr.add(2);
		//arr.add(3);
		//Collections.sort(arr);
		//System.out.println(arr.toString());


	}

}
