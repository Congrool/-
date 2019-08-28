package cn.newshome.test.Dao;

import java.sql.Date;

import cn.newshome.Dao.UserDao;
import cn.newshome.Entity.UserEntity;

public class testUserDao {
	UserDao ud = new UserDao();
	private void SelectByUidTest(String uid) {
		Object[] res = ud.SelectByUid(uid);
		for(int i = 0; i < res.length; i++)
			System.out.println(res[i]);
	}
	private void SelectByUsernameTest(String username) {
		Object[] res = ud.SelectByUsername(username);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	private void InsertTest(UserEntity user) {
		ud.Insert(user);
	}
	private void DeleteTest(String uid) {
		ud.Delete(uid);
	}
	private void updatePasswordTest(String value,String uid) {
		ud.UpdatePassword(value, uid);
	}
	public static void main(String[] args) {
		testUserDao tud = new testUserDao();
//		tud.SelectByUidTest("13");
		
//		tud.SelectByUsernameTest("qweqwe");
		
//		Date date = new Date(189228);
//		UserEntity user = new UserEntity("15", "lj", "123123", "123456", "ff@ff.com", 0, null, null, date, "fff", date);
//		tud.InsertTest(user);
		
		tud.updatePasswordTest("555","100");
	}
}
