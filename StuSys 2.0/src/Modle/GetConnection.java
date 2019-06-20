package Modle;
import java.sql.*;
import View.ErrorPopup;

public class GetConnection {
	private String classname = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://DESKTOP-YI\\SQLEXPRESS:1433;DatabaseName=StuData";
	private String username;
	private String passwd;
	public GetConnection(String uname,String pwd) {
		username = uname; passwd = pwd;
	}
	public Connection getConnection() {
		Connection conn;
		try {
			Class.forName(classname);
			conn = DriverManager.getConnection(url, username, passwd);
		}catch(Exception e) {
			new ErrorPopup("Connection Error!");
			conn = null;
			e.printStackTrace();
		}
		return conn;
	}	
	public void closed(PreparedStatement pstm,Connection conn) {
		if(pstm == null) return;
		try {
			pstm.close();
		}catch(SQLException se) {
			new ErrorPopup("Statement Closing Error!");
			se.printStackTrace();
		}
		if(conn == null) return;
		try {
			conn.close();
		}catch(SQLException se){
			new ErrorPopup("Connection Closing Error!");
			se.printStackTrace();
		}
	}
	public static void main(String[] args) {
		GetConnection conn = new GetConnection("ys","0051486464600");
		conn.getConnection();
		System.out.println("done");
	}
}