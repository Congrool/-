package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Modle.*;
import View.ErrorPopup;

public class profileControl {
	private  Connection conn;
	private  PreparedStatement pstm;
	private  ResultSet rs;
	private String username;
	private String password;
	private GetConnection connection;
	public profileControl(String uname, String pwd) {
		username = uname; password = pwd;
		connection = new GetConnection(username,password);
	}
	private  void update(String sql) {
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
	private  ResultSet select(String sql)  {
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
		if(connection != null){
			connection.closed(pstm,conn);
		}
	}
	public void updateName(String newname, String ID) {
		String sql = "update profile set 姓名 ='"+newname+"' where 学号 = '"+ID+"'";
		update(sql);
	}
	public  profileModle selectWithID(String ID) {
		String sql = "select * from profile where 学号='"+ID+"'";
		rs = select(sql);
		profileModle profile = null;
		try {
			while(rs.next()) {
				String id = rs.getString("学号");
				String name = rs.getString("姓名");
				String cl = rs.getString("班级");
				profile = new profileModle(id,name,cl);
			}
		}catch(SQLException se) {
			new ErrorPopup("Get profile info failed!");
		}finally {
			closeConnection();
		}
		return profile;
	}
	public  List<profileModle> selectAll(){
		String sql = "select * from profile";
		rs = select(sql);
		List<profileModle> list = new ArrayList<profileModle>();
		try {
			while(rs.next()) {
				String id = rs.getString("学号");
				String name = rs.getString("姓名");
				String cl = rs.getString("班级");
				profileModle profile = new profileModle(id,name,cl);
				list.add(profile);
			}
		}catch(SQLException se) {
			new ErrorPopup("Get profile info failed!");
			se.printStackTrace();
		}finally {
			closeConnection();
		}
		return list;
	}
	public  void insert(String id,String name,String cl) {
		String sql = "insert into profile values('"+id+"','"+name+"','"+cl+"')";
		update(sql);
	}
	public void deleteWithID(String id) {
		String sql = "delete from profile where 学号 ='" + id + "'";
		update(sql);
	}
}
