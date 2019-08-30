package cn.newshome.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.newshome.Entity.UserEntity;
import cn.newshome.Service.UserService;
import cn.newshome.Service.ex.GenderValueException;
import cn.newshome.Service.ex.StringEmptyException;

@WebServlet("/userprofile")
public class ProfileModifiedServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		int gender = req.getParameter("gender").equals("m")?1:0;
		System.out.println(gender);
		
		HttpSession session = req.getSession();
		UserEntity user = (UserEntity)session.getAttribute("user");

		Integer uid = user.getUID();
		
		UserService us = new UserService();
		
		if(phone != null && !phone.equals(user.getPhone())) {
			try {
				us.modifiedPhone(phone, uid);
				UserEntity newuser = us.searchUserInfoByUID(uid);
				privateUpdateUser.updateSessionUser(newuser, req.getSession());
				req.getRequestDispatcher("userdata.jsp").forward(req,resp);
				/* req.getRequestDispatcher( "userdata.jsp").forward(req, resp); */
			}catch(StringEmptyException see) {
				//TODO: user_profile path
				req.getRequestDispatcher("userdata.jsp").forward(req,resp);
			}
		}
		
		if(email != null &&!email.equals(user.getEmail())) {
			try {
				us.modifiedEmail(email, uid);
				UserEntity newuser = us.searchUserInfoByUID(uid);
				privateUpdateUser.updateSessionUser(newuser, req.getSession());
				
				req.getRequestDispatcher("userdata.jsp").forward(req,resp);
			}catch(StringEmptyException see) {
				//TODO: user_profile path
				req.getRequestDispatcher("userdata.jsp").forward(req,resp);
			}
		}
		if(gender != user.getGender()) {
			try {
				us.modifiedGender(gender,uid);
				UserEntity newuser = us.searchUserInfoByUID(uid);
				privateUpdateUser.updateSessionUser(newuser, req.getSession());
				req.getRequestDispatcher("userdata.jsp").forward(req,resp);
			}catch(GenderValueException gve) {
				//TODO: user_profile path
				req.getRequestDispatcher("userdata.jsp").forward(req,resp);
			}
			req.getRequestDispatcher("userdata.jsp").forward(req,resp);
		}
	}
}
