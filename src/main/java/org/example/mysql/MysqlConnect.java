package org.example.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 数据组-雨叶
 * @description
 * @created 2022-02-16 10:44
 */
public class MysqlConnect {

	Connection connection;

	public static void main(String[] args) {
		MysqlConnect conn = new MysqlConnect();
		conn.getConnection();
	}

	/**
	 * jdbc:mysql:               是指JDBC连接方式
	 * 127.0.0.1:                是指你的本机地址
	 * 3306                      SQL数据库的端口号
	 * one                       连接的数据库的名字
	 * characterEncoding         指定数据库连接的编码方式
	 * com.mysql.jdbc.Driver     注册数据库驱动(过时)
	 * com.mysql.cj.jdbc.Driver  新的数据库驱动
	 */
	public Connection getConnection() {

		//注册数据库驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("数据库驱动加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//获取数据连接
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/one?characterEncoding=UTF-8";
			String user = "root";
			String password = "rootroot";
			connection = DriverManager.getConnection(url, user, password);
//			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
