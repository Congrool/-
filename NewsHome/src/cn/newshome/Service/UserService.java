package cn.newshome.Service;

import java.sql.Timestamp;

import cn.newshome.Dao.UserDao;
import cn.newshome.Entity.UserEntity;
import cn.newshome.Service.ex.GenderValueException;
import cn.newshome.Service.ex.PasswordEmptyException;
import cn.newshome.Service.ex.PasswordErrorException;
import cn.newshome.Service.ex.StringEmptyException;
import cn.newshome.Service.ex.UserDoesNotExistException;
import cn.newshome.Service.ex.UsernameContainsillegalCharacterException;
import cn.newshome.Service.ex.UsernameEmptyException;
import cn.newshome.Service.ex.UsernameIsUsedException;

public class UserService {
	private UserDao ud = new UserDao();
	/**
	 * 没有检查两次密码输入是否相同
	 * @param user
	 * @throws UsernameIsUsedException
	 * @throws UsernameEmptyException
	 * @throws PasswordEmptyException
	 * @throws UsernameContainsillegalCharacterException
	 */
	public void Regist(UserEntity user) throws UsernameIsUsedException, UsernameEmptyException, PasswordEmptyException, UsernameContainsillegalCharacterException {
		if(user.getUsername() == null) {
			throw new UsernameEmptyException("用户名为空");
		}
		if(user.getPassword() == null) {
			throw new PasswordEmptyException("密码为空");
		}
		Object[] repeat = ud.SelectByUsername(user.getUsername());
		if(repeat != null) {
			throw new UsernameIsUsedException("用户名已被使用");
		}
		//用户名特殊字符检查
		String username = user.getUsername();
		for(int i = 0 ; i < username.length(); i++) {
			if('a' <= username.charAt(i) && username.charAt(i) <= 'z' &&
					'A' <= username.charAt(i) && username.charAt(i) <= 'Z' &&
					'0' <= username.charAt(i) && username.charAt(i) <= '9')
				continue;
			else throw new UsernameContainsillegalCharacterException("用户名包含非法字符");
		}
		
		ud.Insert(user);
	}
	/**
	 * 登陆成功返回用户实体
	 * @param username
	 * @param password
	 * @return
	 * @throws UserDoesNotExistException
	 * @throws PasswordErrorException
	 */
	public UserEntity Login(String username,String password) throws UserDoesNotExistException, PasswordErrorException, UsernameEmptyException, PasswordEmptyException {
		if(username == null) {
			throw new UsernameEmptyException("用户名为空");
		}
		if(password == null) {
			throw new PasswordEmptyException("密码为空");
		}
		Object[] searchRes = ud.SelectByUsername(username);
		if(searchRes == null) {
			throw new UserDoesNotExistException("用户不存在");
		}
		String pwd = (String)searchRes[2];
			
		if(!password.equals(pwd)) {
			throw new PasswordErrorException("密码错误");
		}
		UserEntity user = new UserEntity();
		user.setUID((Integer)searchRes[0]);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone((String)searchRes[3]);
		user.setEmail((String)searchRes[4]);
		user.setGender((int)searchRes[5]);
		user.setAvadar((String)searchRes[6]);
		user.setCreated_user((String)searchRes[7]);
		user.setCreated_time((Timestamp)searchRes[8]);
		user.setModified_user((String)searchRes[9]);
		user.setModified_time((Timestamp)searchRes[10]);
		return user;
	}
	public void modifiedPhone(String newphone,Integer uid) throws StringEmptyException {
		if(newphone == null) {
			throw new StringEmptyException("手机号码为空");
		}
		ud.UpdatePhone(newphone, uid);
	}
	public void modifiedEmail(String newmail,Integer uid) throws StringEmptyException {
		if(newmail == null) {
			throw new StringEmptyException("邮箱为空");
		}
		ud.UpdatePhone(newmail, uid);
	}
	public void modifiedPassword(String newpassword, Integer uid) throws PasswordEmptyException {
		if(newpassword == null) {
			throw new PasswordEmptyException("密码为空");
		}
		ud.UpdatePassword(newpassword, uid);
	}
	public void modifiedGender(int gender, Integer uid) throws GenderValueException{
		if(gender != 0 && gender != 1) {
			throw new GenderValueException("性别数值错误");
		}
		ud.UpdateGender(gender, uid);
	}
	public UserEntity searchUserInfoByUID(Integer uid) {
		Object[] meta = ud.SelectByUid(uid);
		UserEntity user = null;	
		user.setUID((int)meta[0]);
		user.setUsername((String)meta[1]);
		user.setPassword((String)meta[2]);
		user.setPhone((String)meta[3]);
		user.setEmail((String)meta[4]);
		user.setGender((int)meta[5]);
		user.setAvadar((String)meta[6]);
		user.setCreated_user((String)meta[7]);
		user.setCreated_time((Timestamp)meta[8]);
		user.setModified_user((String)meta[9]);
		user.setModified_time((Timestamp)meta[10]);
		return user;
	}
}
