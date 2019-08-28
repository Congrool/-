package cn.newshome.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.newshome.Dao.ex.CommentDaoException;
import cn.newshome.Util.DBUtils;

/**
 * 包含评论的查找：
 * 按用户查找：selectByUID
 * 按新闻查找：selectByNewsid
 * 
 * 评论的删除：
 * 按commnet_id删除：deleteByCommentid
 * @author 张逸飞
 *
 */
public class CommentDao {
	public Vector<Vector<Object>> selectByUid(String uid){
		String sql = "select * from comment_info where uid=?";
		Vector<Vector<Object>> res = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,uid);
			
			rs = stmt.executeQuery();
			
			res = new Vector<Vector<Object>>();
			
			while(rs.next()) {
				Vector<Object> tmp = new Vector<Object>();
				for(int i = 1; i <= 5; i++) {
					tmp.add(rs.getObject(i));
				}
				res.add(tmp);
			}
			return res;
		}catch(SQLException se) {
			se.printStackTrace();
			throw new CommentDaoException("Exception occured when select comments by uid",se);
		}finally {
			DBUtils.close(conn);
			DBUtils.close(stmt);
			DBUtils.close(rs);
		}
	}
	public Vector<Vector<Object>> selectByNewsid(String newsid){
		String sql = "select * from comment_info where news_id=?";
		Vector<Vector<Object>> res = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,newsid);
			rs = stmt.executeQuery();
			
			res = new Vector<Vector<Object>>();
			
			while(rs.next()) {
				Vector<Object> tmp = new Vector<Object>();
				for(int i = 1; i <= 5; i++) {
					tmp.add(rs.getObject(i));
				}
				res.add(tmp);
			}
			return res;
		}catch(SQLException se) {
			se.printStackTrace();
			throw new CommentDaoException("Exception occured when select comments by newsid",se);
		}finally {
			DBUtils.close(conn);
			DBUtils.close(stmt);
			DBUtils.close(rs);
		}
	}
	public int deleteByCommentid(String commentid) {
		String sql = "delete from comment_info where comment_id=?;";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, commentid);
			
			int num = stmt.executeUpdate();
			return num;
		}catch(SQLException se) {
			se.printStackTrace();
			throw new CommentDaoException("Exception occured when delete by comment_id",se);
		}finally {
			DBUtils.close(conn);
			DBUtils.close(stmt);
		}
	}
}
