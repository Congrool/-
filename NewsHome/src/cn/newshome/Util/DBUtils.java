package cn.newshome.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtils {
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String pwd = null;
	private static int initialSize = 0;
	private static int maxTotal = 0;
	private static long maxWaitMillis = 0;
	
	private static BasicDataSource ds = null;
	
	static {
		try {
			Properties props = new Properties();
			props.load(DBUtils.class.getClassLoader().getResourceAsStream("db.properties"));
			
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("user");
			pwd = props.getProperty("pwd");
			initialSize = Integer.parseInt(
					props.getProperty("initialSize"));
			maxTotal = Integer.parseInt(
					props.getProperty("maxTotal"));
			maxWaitMillis = Integer.parseInt(
					props.getProperty("maxWaitMillis"));
			
			ds = new BasicDataSource(); //实例化连接池对象
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			ds.setInitialSize(initialSize);
			ds.setMaxTotal(maxTotal);
			ds.setMaxWaitMillis(maxWaitMillis);
		}catch(IOException e){
			e.printStackTrace();
			throw new RuntimeException("load config file error",e);
		}
	}
	public static Connection getConnection() throws SQLException{
		if(ds != null) {
			return ds.getConnection();
		}else {
			throw new RuntimeException("fail to get a connection object from connection pool");
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn!=null) {conn.close();}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Exception occured when close the connection!",e);		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null) {stmt.close();}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Exception occured when close the statement!", e);
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs!=null) {rs.close();}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Exception occured when close the ResultSet",e);
		}
	}
	
	//the main funtion was created for test
	public static void main(String[] args) throws SQLException{
		System.out.println("开始测试获得数据库连接：");
		Connection conn = DBUtils.getConnection();
		System.out.println("连接的类型：" + conn.getClass().getName());
		System.out.println("连接测试1: " + conn);
		System.out.println("连接测试2: " + DBUtils.getConnection());
		
	}
}
