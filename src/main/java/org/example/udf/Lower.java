package org.example.udf;

import com.aliyun.odps.udf.UDF;

public class Lower extends UDF {
	// TODO define parameters and return type, e.g:  public String evaluate(String a, String b)
	public String evaluate(String s) {
		if (s == null) {
			return null;
		}
		return s.toLowerCase();
	}


	//public static void main(String[] args) {
	//	Lower lower = new Lower();
	//
	//	System.out.println("output: "+lower.evaluate("Hello"));
	//
	//}
}