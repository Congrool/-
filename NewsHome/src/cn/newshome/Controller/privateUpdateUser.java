package cn.newshome.Controller;

import javax.servlet.http.HttpSession;

import cn.newshome.Entity.UserEntity;

public class privateUpdateUser {
	public static void updateSessionUser(UserEntity user, HttpSession sess) { 
		sess.setAttribute("user", user);
		sess.setAttribute("username", user.getUsername());
		sess.setAttribute("password", user.getPassword());
		sess.setAttribute("phone", user.getPhone());
		sess.setAttribute("email", user.getEmail());
		sess.setAttribute("gender", user.getGender());
	}

}
