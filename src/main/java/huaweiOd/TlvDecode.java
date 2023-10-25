package huaweiOd;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @author 数仓开发-雨叶
 * @description TLV解码
 * @case 31
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * return：32 33
 * 需要解析的信元tag是31，从码流起始处开始匹配，tag为32的信元长度为1（01 00，小端序表示1）；
 * 第二个信元的tag是90，长度为2；
 * 第三个信元的tag是30，长度为3；
 * 第四个信元的tag是31，长度为2（02 00），所以返回长度后面的两个字节 32 33
 * @created 2023-10-25 23:42
 */
public class TlvDecode {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String tag = in.nextLine();
		String[] vals = in.nextLine().split(" ");
		int len = vals.length;
		int i = 0;
		String val;
		int length = 0;
		while (i < len) {
			val = vals[i];
			length = Integer.parseInt(vals[i + 2] + vals[i + 1], 16);
			i += 3;
			if (StringUtils.equals(val, tag)) {
				break;
			}
			i += length;
		}
		System.out.print("待解信元以16进制表示的value为：");
		while (length > 0) {
			System.out.print(vals[i] + " ");
			i++;
			length--;
		}

	}
}
