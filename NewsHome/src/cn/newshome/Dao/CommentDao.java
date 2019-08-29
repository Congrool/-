package cn.newshome.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.catalina.User;

import cn.newshome.Dao.ex.CommentDaoException;
import cn.newshome.Dao.ex.NewsDaoException;
import cn.newshome.Entity.CommentEntity;
import cn.newshome.Util.DBUtils;

/**
 * 包含评论的查找：
 * 按用户查找：selectByUID
 * 按新闻查找：selectByNewsid
 * 
 * 评论的删除：
 * 按commnet_id删除：deleteByCommentid
 * 
 * 评论的添加：
 * ：insert
 * 
 * @author 张逸飞
 *
 */
public class CommentDao {
	/**
	 * 根据uid查找comment
	 * @param uid
	 * @return Vector二维数组
	 * @throws NewsDaoException
	 */
	public Vector<Vector<Object>> selectByUid(Integer uid) {
		String sql = "select * from comment_info where uid=?";
		Vector<Vector<Object>> res = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,uid);
			
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
	/**
	 * 根据newsid,查找所有comment
	 * @param newsid
	 * @return
	 * @throws NewsDaoException
	 */
	public Vector<Vector<Object>> selectByNewsid(int newsid){
		String sql = "select * from comment_info where news_id=?";
		Vector<Vector<Object>> res = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,newsid);
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
	/**
	 * 根据commentid删除某条comment信息
	 * @param commentid
	 * @return
	 * @throws NewsDaoException
	 */
	public int deleteByCommentid(Integer commentid){
		String sql = "delete from comment_info where comment_id=?;";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, commentid);
			
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
	/**
	 * 插入Comment信息
	 * @param comm
	 * @return 影响数据库表单的行数
	 */
	public int insert(CommentEntity comm) {
		String sql = "insert into comment_info ("
				+ "uid,news_id,comment_text,created_time)"
				+ "values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, comm.getUID());
			stmt.setInt(2, comm.getNewsID());
			stmt.setString(3, comm.getCommentText());
			stmt.setTimestamp(4, comm.getCreated_time());
			
			int num = stmt.executeUpdate();
			return num;
		}catch(SQLException se) {
			se.printStackTrace();
			throw new CommentDaoException("Exception occured when insert comment data",se);
		}finally {
			DBUtils.close(conn);
			DBUtils.close(stmt);
		}
	}
	public Object[] selectByCommentid(Integer commentid) {
		String sql = "select * from comment_info where comment_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Object[] res = null;
 		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, commentid);
			
			rs = stmt.executeQuery();
			res = new Object[5];
			if(rs.next()) {
				for(int i = 1; i <= 5; i++) {
					res[i-1] = rs.getObject(i);
				}
			}
			return res;
		}catch(SQLException se) {
			se.printStackTrace();
			throw new CommentDaoException("Exception occured when select by comment_id",se);
		}finally {
			DBUtils.close(conn);
			DBUtils.close(stmt);
			DBUtils.close(rs);
		}
	}
}
