package org.example.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 数据组-雨叶
 * @description
 * @created 2022-02-16 11:14
 */
public class MysqlOperate {

	Connection connection;

	public static void main(String[] args) {

		MysqlOperate op = new MysqlOperate();

		System.out.println("hello_world表里的数据为");
		op.select();

		System.out.println("-------------------------------------");
		System.out.println("执行insert方法后，hello_world表里的数据为");
		op.insert();
		op.select();

		System.out.println("-------------------------------------");
		System.out.println("执行update方法后，hello_world表里的数据为");
		op.update();
		op.select();

		System.out.println("-------------------------------------");
		System.out.println("执行delete方法后，hello_world表里的数据为");
		op.delete();
		op.select();

	}

	public Connection getConnection() {

		try {
			//注册数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取数据连接
			String url = "jdbc:mysql://127.0.0.1:3306/one?characterEncoding=UTF-8";
			String user = "root";
			String password = "rootroot";
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insert() {
		Connection conn = null;
		Statement stmt = null;
		String sql = "insert into hello_world (id,words) values(1,\"Hello Worlds\"),(2,\"hello world\");";
		try {
			// 获取数据库连接
			conn = getConnection();

			// 获取发送sql指令执行sql对象
			stmt = conn.createStatement();

			// 执行sql，并返回结果，返回结果为插入数据条数
			System.out.println("insert方法执行sql = " + sql);
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 关闭数据源
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update() {
		Connection conn = null;
		Statement stmt = null;
		String sql = "update hello_world set words = \"Hello China\" where id=1";
		try {
			// 获取数据库连接
			conn = getConnection();

			// 获取发送sql指令执行sql对象
			stmt = conn.createStatement();

			// 执行sql，并返回结果，返回结果为插入数据条数
			System.out.println("insert方法执行sql = " + sql);
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 关闭数据源
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from hello_world";
		try {
			// 获取数据库连接
			conn = getConnection();

			// 获取发送sql指令执行sql对象
			stmt = conn.createStatement();

			// 执行sql，并返回结果，返回结果为插入数据条数
			System.out.println("select方法执行sql = " + sql);
			rs = stmt.executeQuery(sql);

			// 遍历结果集
			while (rs.next()) {
				System.out.println("id = " + rs.getString("id") + ", words = " + rs.getString("words"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 关闭数据源
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int delete() {
		Connection conn = null;
		Statement stmt = null;
		String sql = "delete from hello_world";
		try {
			// 获取数据库连接
			conn = getConnection();

			// 获取发送sql指令执行sql对象
			stmt = conn.createStatement();

			// 执行sql，并返回结果
			System.out.println("delete方法执行sql = " + sql);
			int result = stmt.executeUpdate(sql);

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;

		} finally {
			// 关闭数据源
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
