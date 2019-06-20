package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import View.ErrorPopup;
import java.util.*;

import Modle.*;

public class gradeControl {
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	private String username;
	private String password;
	private GetConnection connection;
	public gradeControl(String uname,String pwd) {
		username = uname; password = pwd;
		connection = new GetConnection(username,password);
	}
	private void update(String sql) {
		conn = connection.getConnection();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.execute();
		}catch(SQLException se) {
			new ErrorPopup("Update failed");
			se.printStackTrace();
		}finally {
			connection.closed(pstm, conn);
		}
	}
	private ResultSet select(String sql) {
		conn = connection.getConnection();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			return rs;
		}catch(SQLException se) {
			new ErrorPopup("select error");
			se.printStackTrace();
		}
		return null;
	}
	private void closeConnection() {
		if(connection != null) {
			connection.closed(pstm,conn);
		}
	}
	public void updateChinese(int newgrade,String ID) {
		String sql = "update grade set 语文='"+newgrade+"' where 学号='"+ID+"'";
		update(sql);
	}
	public void updateMaths(int newgrade,String ID) {
		String sql = "update grade set 数学='"+newgrade+"' where 学号='"+ID+"'";
		update(sql);
	}
	public void updateEnglish(int newgrade,String ID) {
		String sql = "update grade set 英语='"+newgrade+"' where 学号='"+ID+"'";
		update(sql);
	}
	public gradeModle selectWithID(String ID) {
		String sql = "select * from grade where 学号='"+ID+"'";
		rs = select(sql);
		gradeModle grade = null;
		try {
			while(rs.next()) {
				String id = rs.getString("学号");
				int ch = rs.getInt("语文");
				int ma = rs.getInt("数学");
				int en = rs.getInt("英语");
				int sum = ch+ma+en;
				grade = new gradeModle(id,ch,ma,en,sum);
			}
		}catch(SQLException se) {
			new ErrorPopup("Get grade info failed!");
		}finally {
			closeConnection();
		}
		return grade;
	}
	public List<gradeModle> selectAll(){
		String sql = "select * from grade";
		rs = select(sql);
		List<gradeModle> list = new ArrayList<gradeModle>();
		try {
			while(rs.next()) {
				String id = rs.getString("学号");
				int ch = rs.getInt("语文");
				int ma = rs.getInt("数学");
				int en = rs.getInt("英语");
				int sum = ch+ma+en;
				gradeModle grade = new gradeModle(id,ch,ma,en,sum);
				list.add(grade);
			}
		}catch(SQLException se) {
			new ErrorPopup("Get grade info failed!");
		}finally {
			closeConnection();
		}
		return list;
	}
	public void insert(String id,int ch,int ma,int en) {
		String sql = "insert into grade values ('"+id+"','"+ch+"','"+ma+"','"+en+"')";
		update(sql);
	}
	public void deleteWithID(String id) {
		String sql = "delete from grade where 学号 ='" + id + "'";
		update(sql);
	}
}
