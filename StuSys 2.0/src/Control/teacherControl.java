package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import Modle.*;
import View.ErrorPopup;

public class teacherControl {
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	private String username;
	private String password;
	private GetConnection connection;
	public teacherControl(String usname,String passwd) {
		username = usname; password = passwd;
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
		if(connection != null) {
			connection.closed(pstm, conn);
		}
	}
	
	public  void updateClass(String newclass,String subject,String teacher) {
		String sql = "update teacher set 授课班级 ='"+newclass+"' where 课程 ='"+subject+"' and 任课教师='"+teacher+"'";
		update(sql);
	}
	public  void updateTeacher(String cl,String subject,String newteacher) {
		String sql = "update teacher set 任课教师 ='"+newteacher+"' where 课程 ='"+subject+"' and 授课班级='"+cl+"'";
		update(sql);
	}
	public void updateSubject(String cl,String newsubject,String teacher) {
		String sql = "update teacher set 课程 ='"+newsubject+"' where 授课班级 ='"+cl+"' and 任课教师='"+teacher+"'";
		update(sql);
	}
	public  List<teacherModle> selectAll(){
		String sql = "select * from teacher";
		rs = select(sql);
		List<teacherModle> list = new ArrayList<teacherModle>();
		try {
			while(rs.next()) {
				String cla = rs.getString("授课班级");
				String sub = rs.getString("课程");
				String tea = rs.getString("任课教师");
				teacherModle tmp = new teacherModle(cla,sub,tea);
				list.add(tmp);
			}
		}catch(SQLException se) {
			new ErrorPopup("Get teacher info failed");
		}finally {
			closeConnection();
		}
		return list;
	}
	public  List<teacherModle> selectAccrodingtoTeacherName(String teachername){
		String sql = "select * from teacher where 任课教师='"+teachername+"'";
		rs = select(sql);
		List<teacherModle> list = new ArrayList<teacherModle>();
		try {
			while(rs.next()) {
				String cla = rs.getString("授课班级");
				String sub = rs.getString("课程");
				String tea = rs.getString("任课教师");
				teacherModle tmp = new teacherModle(cla,sub,tea);
				list.add(tmp);
			}
		}catch(SQLException se) {
			new ErrorPopup("Get teacher info failed");
		}finally {
			closeConnection();
		}
		return list;
	}
	public int getColumnNum() {
		return teacherModle.getColumnNum();
	}
	public String[] getColumnName() {
		return teacherModle.getColumnName();
	}
	public void insert(String cla,String sub,String teach) {
		String sql = "insert into teacher values('"+cla+"','"+sub+"','"+teach+"')";
		update(sql);
	}
}
