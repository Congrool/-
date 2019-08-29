package cn.newshome.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.newshome.Dao.ex.NewsDaoException;
import cn.newshome.Util.DBUtils;

/**
 * 包含的查找函数
 * 根据news_id查找：selectByNewsid
 * 根据关键字：selectByKeywords（用于搜索）未完成
 * @author 张逸飞
 *
 */
public class NewsDao {
	public Object[] selectByNewsid(String newsid) throws NewsDaoException {
		String sql="select * from news_info where news_id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Object[] res = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newsid);
			rs = stmt.executeQuery();
			res = new Object[5];
			if(rs.next()) {
				for(int i = 1; i <= 5; i++)
					res[i-1] = rs.getObject(i);
			}
			return res;
		}catch(SQLException se) {
			se.printStackTrace();
			throw new NewsDaoException("Exception occured when select by news_id",se);
		}finally {
			DBUtils.close(conn);
			DBUtils.close(rs);
			DBUtils.close(stmt);
		}
	}
	
//	/**
//	 * 
//	 * @param keywords 传入的keywords字符串,以空格分隔每个关键字
//	 * @return
//	 */
//	public Object[][] selectByKeywords(String keywords){
//		Vector<String> key = new Vector<String>();
//		for(String it:keywords.split(" ")) {
//			key.add(it);
//		}
//		
//		Object[][] res = null;
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		String sql = "select * from news_info where keywords like '%?%'";
//		
//		Vector<Vector<Object>> tmp = new Vector<>(); 
//		try {
//			conn = DBUtils.getConnection();
//			stmt = conn.prepareStatement(sql);
//			for(String item:key) {
//				stmt.setString(1, item);
//				rs = stmt.executeQuery(sql);
//				while(rs.next()) {
//					
//				}
//			}
//		}
//	}
}
