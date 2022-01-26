package org.example.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * <p>logback日志练习</p>
 *
 * @author 数据组-雨叶
 * @created 2022-01-26 11:03
 */
public class LogBackTest {

	private static final Logger logger = LoggerFactory.getLogger(LogBackTest.class);

	public static void main(String[] args) {
		logger.debug("这是一个debug类型的日志");
		logger.info("这是一个info类型的日志");
		logger.warn("这是一个warn类型的日志");
		logger.error("这是一个error类型的日志");

		try {
			Integer.parseInt("abc");
		} catch (NumberFormatException e) {
			// 打印获得异常的名称, java.lang.NumberFormatException: For input string: "abc"
			logger.error("错误信息：e.getMessage() = {}", e.getMessage());
			// 打印错误输出内容的样式, java.lang.NumberFormatException: For input string: "abc"
			logger.error("错误信息：e.toString() = {}", e.toString());
			// 获取的StackTraceElement[]数组
			logger.error("错误信息：e.getStackTrace() = {}", Arrays.toString(e.getStackTrace()));
			// 打印异常堆栈信息
			e.printStackTrace();
		}

	}


}
