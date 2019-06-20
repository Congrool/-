package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modle.studentOrdered;
import Modle.GetConnection;
import View.ErrorPopup;

public class orderControl {
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	private String username;
	private String password;
	private GetConnection connection;
	public orderControl(String uname,String pwd) {
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
	public List<studentOrdered> orderedBySum(){
		String sql = "select row_number() over (order by 语文+数学+英语) as 名次 ,\r\n" + 
				"profile.学号,\r\n" + 
				"班级,\r\n" + 
				"姓名,\r\n" + 
				"语文,\r\n" + 
				"数学,\r\n" + 
				"英语,\r\n" + 
				"语文+数学+英语 as 总分\r\n" + 
				"from grade left join profile on (grade.学号 = profile.学号)\r\n";
		List<studentOrdered> list = new ArrayList<studentOrdered>();
		rs = select(sql);
		try {
			while(rs.next()) {
				int rank = rs.getInt("名次");
				String id = rs.getString("学号");
				String name = rs.getString("姓名");
				String cla = rs.getString("班级");
				int ch = rs.getInt("语文");
				int ma = rs.getInt("数学");
				int en = rs.getInt("英语");
				int sum = rs.getInt("总分");
				studentOrdered stu = new studentOrdered(rank, id, name, cla, ch, ma, en, sum);
				list.add(stu);
			}
		}catch(SQLException se) {
			new ErrorPopup("order failed");
			se.printStackTrace();
		}finally {
			closeConnection();
		}
		return list;
	}
	public String[] getOrderedColumnName() {
		return studentOrdered.getColumnName();
	}
	public int getColumnNum() {
		return studentOrdered.getColumnNum();
	}
}

