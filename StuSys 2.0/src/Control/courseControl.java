package Control;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modle.*;
import View.ErrorPopup;
public class courseControl {
	private  Connection conn;
	private  PreparedStatement pstm;
	private  ResultSet rs;
	private String username;
	private String password;
	private GetConnection connection;
	public courseControl(String uname, String pwd) {
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
			connection.closed(pstm,conn);
		}
	}
	private  ResultSet select(String sql) {
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
			connection.closed(pstm, conn);
		}
	}
	public  courseModle selectWithID(String ID) {
		String sql = "select * from course where 学号='"+ID+"'";
		rs = select(sql);
		courseModle course = null;
		try {
			while(rs.next()) {
				String id = rs.getString("学号");
				boolean ge = rs.getBoolean("地理");
				boolean cu = rs.getBoolean("人文");
				boolean hi = rs.getBoolean("历史");
				boolean po = rs.getBoolean("政治");
				boolean bi = rs.getBoolean("生物");
				boolean ch = rs.getBoolean("化学");
				boolean ph = rs.getBoolean("物理");
				course = new courseModle(id,ge,cu,hi,po,bi,ch,ph);
			}
		}catch(SQLException se) {
			new ErrorPopup("Get course info failed!");
		}finally {
			closeConnection();
		}
		return course;
	}
	public  List<courseModle> selectAll(){
		String sql = "select * from course";
		List<courseModle> list = new ArrayList<courseModle>();
		rs = select(sql);
		try {
			while(rs.next()) {
				String id = rs.getString("学号");
				boolean ge = rs.getBoolean("地理");
				boolean cu = rs.getBoolean("人文");
				boolean hi = rs.getBoolean("历史");
				boolean po = rs.getBoolean("政治");
				boolean bi = rs.getBoolean("生物");
				boolean ch = rs.getBoolean("化学");
				boolean ph = rs.getBoolean("物理");
				courseModle course = new courseModle(id,ge,cu,hi,po,bi,ch,ph);
				list.add(course);
			}
		}catch(SQLException se) {
			new ErrorPopup("Get course info failed!");
		}finally {
			closeConnection();
		}
		return list;
	}
	public void insert(String id, boolean ge, boolean cu, boolean hi, boolean po,boolean bi,boolean ch,boolean ph) {
		String sql = "insert into course values ('"+id+"','"+ge+"','"+cu+"','"+hi+"','"+po+"','"+bi+"','"+ch+"','"+ph+"')";
		update(sql);
	}
	public void updateGeography(boolean val, String ID) {
		String sql = "update curse set 地理="+val+" where 学号  ='"+ID+"'";
		update(sql);
	}
	public void updateCulture(boolean val, String ID) {
		String sql = "update curse set 人文="+val+" where 学号  ='"+ID+"'";
		update(sql);
	}
	public void updateHistory(boolean val, String ID) {
		String sql = "update curse set 历史="+val+" where 学号  ='"+ID+"'";
		update(sql);
	}
	public void updatePolitical(boolean val, String ID) {
		String sql = "update curse set 政治="+val+" where 学号  ='"+ID+"'";
		update(sql);
	}
	public void updateBiology(boolean val, String ID) {
		String sql = "update curse set 生物="+val+" where 学号  ='"+ID+"'";
		update(sql);
	}
	public void updateChemistry(boolean val, String ID) {
		String sql = "update curse set 化学="+val+" where 学号  ='"+ID+"'";
		update(sql);
	}
	public void updatePhysics(boolean val, String ID) {
		String sql = "update curse set 物理="+val+" where 学号  ='"+ID+"'";
		update(sql);
	}
	public void deleteWithID(String ID) {
		String sql = "delete from course where 学号 = '"+ID+"'";
		update(sql);
	}
}
