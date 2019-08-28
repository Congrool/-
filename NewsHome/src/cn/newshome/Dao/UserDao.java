package cn.newshome.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import cn.newshome.Dao.ex.UserDaoException;
import cn.newshome.Entity.UserEntity;
import cn.newshome.Util.DBUtils;

/**
 * 用户数据库操作类，包含以下方法
 * 使用uid查找用户数据的方法：searchByUid
 * 使用用户名查找用户数据的方法：searchByUsername
 * 插入用户数据的方法：insert
 * 修改用户数据的方法：update
 * 注销用户的方法：delete
 * 
 * 注意数据的合法性应该由上层调用保证！！
 * 
 * @author 张逸飞
 *
 */
public class UserDao {
	/**
	 * 通过uid查找User用户数据,当查询不到时返回null
	 * @param uid
	 * @return Object[]包含一行数据 or null 
	 */
	public Object[] SelectByUid(String uid) throws UserDaoException{
		String sql = "select * from user_info where uid=?;";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Object[] res = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, uid);
			
			rs = stmt.executeQuery();
			res = new Object[11];
			while(rs.next()) {
				for(int i = 1; i <= 11; i++)
					res[i] = rs.getObject(i);
			}
			return res;
		}catch(SQLException se) {
			se.printStackTrace();
			throw new UserDaoException("Exception occured when SearchByUid",se);
		}finally {
			DBUtils.close(conn);
			DBUtils.close(stmt);
			DBUtils.close(rs);
		}
	}
	/**
	 * 通过username查找User用户数据,当查询不到时返回null
	 * @param username
	 * @return Object[]包含一行数据 or null 
	 */
	public Object[] SelectByUsername(String username) throws UserDaoException{
		String sql = "select * from user_info where username=?;";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Object[] res = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			
			rs = stmt.executeQuery();
			res = new Object[11];
			while(rs.next()) {
				for(int i = 1; i <= 11; i++)
					res[i] = rs.getObject(i);
			}
			return res;
		}catch(SQLException se) {
			se.printStackTrace();
			throw new UserDaoException("Exception occured when SearchByUid",se);
		}finally {
			DBUtils.close(conn);
			DBUtils.close(stmt);
			DBUtils.close(rs);
		}
	}
	//TODO:Insert
	/**
	 * 插入用户数据
	 * 此函数不检查是否已存在重复用户名
	 * 检查交由上层调用select方法检查
	 * @param user
	 * @return 影响的行数
	 */
	public int Insert(UserEntity user) throws UserDaoException{
		String sql = "insert into user_info("
				+ "username,password,phone,email,gender,avatar,created_user,created_time,modified_user,modified_time)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getPhone());
			stmt.setString(4, user.getEmail());
			stmt.setObject(5, user.getGender());
			stmt.setString(6, user.getAvadar());
			stmt.setString(7, user.getCreated_user());
			Timestamp ts = user.getCreated_time()==null?null:new Timestamp(user.getCreated_time().getTime());
			stmt.setTimestamp(8, ts);
			stmt.setString(9,user.getModified_user());
			ts = user.getModified_time()==null?null:new Timestamp(user.getModified_time().getTime());
			
			int num = stmt.executeUpdate();
			return num;
		}catch(SQLException se) {
			se.printStackTrace();
			throw new UserDaoException("Exception occured when insert user data",se);
		}finally {
			DBUtils.close(conn);
			DBUtils.close(stmt);
		}
	}
	//TODO:Delete
	/**
	 * 根据用户id删除数据
	 * @param uid
	 * @return 影响的行数
	 */
	public int Delete(String uid) throws UserDaoException{
		String sql = "delete from user_info where uid=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			
			int num = stmt.executeUpdate();
			return num;
		}catch(SQLException se) {
			se.printStackTrace();
			throw new UserDaoException("Exception occured when delete user data",se);
		}finally {
			DBUtils.close(conn);
			DBUtils.close(stmt);
		}
	}
	//TODO:Update
	/**
	 * 更新用户密码
	 * @param value是密码字符串
	 * @return 修改的行数
	 */
	public int UpdatePassword(String value,String uid) throws UserDaoException{
		return Update("password",value,uid);
	}
	/**
	 * 更新用户手机号码
	 * @param value是手机号字符串
	 * @return 修改的行数
	 */
	public int UpdatePhone(String value,String uid) throws UserDaoException{
		return Update("phone",value,uid);
	}
	/**
	 * 更新用户邮箱
	 * @param value是邮箱字符串
	 * @return 修改的行数
	 */
	public int UpdateEmail(String value,String uid) throws UserDaoException{
		return Update("email",value,uid);
	}
	/**
	 * 更新用户性别
	 * @param value是性别
	 * @return 修改的行数
	 */
	public int UpdateGender(int value,String uid) throws UserDaoException{
		return Update("gender",value,uid);
	}
	/**
	 * 更新用户头像
	 * @param value是头像字符串
	 * @return 修改的行数
	 */
	public int UpdateAvatar(String value,String uid) throws UserDaoException{
		return Update("avatar",value,uid);
	}
	/**
	 * 更新创建用户的用户
	 * @param value是用户名字符串
	 * @return 修改的行数
	 */
	public int UpdateCreated_user(String value,String uid) throws UserDaoException {
		return Update("created_user",value,uid);
	}
	/**
	 * 更新修改用户数据的用户
	 * @param value是用户名字符串
	 * @return 修改的行数
	 */
	public int UpdateModified_user(String value,String uid) throws UserDaoException{
		return Update("modified_user",value,uid);
	}
	/**
	 * 更新用户创建时间
	 * @param value是Date类型
	 * @return 修改的行数
	 */
	public int UpdateCreated_time(Date value,String uid) throws UserDaoException {
		return Update("created_time",value,uid);
	}
	/**
	 * 更新用户数据修改时间
	 * @param value是Date类型
	 * @return 修改的行数
	 */
	public int UpdateModified_time(Date value,String uid) throws UserDaoException {
		return Update("modified_time",value,uid);
	}
	/**
	 * 私有update方法
	 * @param columnName
	 * @param value
	 * @param uid
	 * @return
	 * @throws UserDaoException
	 */
	private int Update(String columnName, Object value,String uid) throws UserDaoException {
		String sql = "update user_info set ? = ? where uid = ?"; 
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, columnName);
			stmt.setString(2, (String)value);
			stmt.setString(3, (String)uid);
			
			int num = stmt.executeUpdate();
			return num;
		}catch(NullPointerException nulle) {
			nulle.printStackTrace();
			throw new UserDaoException("data import is null",nulle);
		}catch(SQLException se) {
			se.printStackTrace();
			throw new UserDaoException("Exception occured when update"+columnName,se);
		}finally {
			DBUtils.close(conn);
			DBUtils.close(stmt);
		}
	}
}
