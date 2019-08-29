package cn.newshome.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.newshome.Entity.UserEntity;
import cn.newshome.Service.GenderValueException;
import cn.newshome.Service.UserService;
import cn.newshome.Service.ex.StringEmptyException;

@WebServlet("/user_profile")
public class ProfileModifiedServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		req.setCharacterEncoding("utf-8");
		
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		int gender = Integer.parseInt(req.getParameter("gender"));
		
		HttpSession session = req.getSession();
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer uid = user.getUID();
		
		UserService us = new UserService();
		
		if(!phone.equals(user.getPhone())) {
			try {
				us.modifiedPhone(phone, uid);
			}catch(StringEmptyException see) {
				//TODO: user_profile path
				req.getRequestDispatcher("").forward(req,resp);
			}
		}
		
		if(!email.equals(user.getEmail())) {
			try {
				us.modifiedEmail(email, uid);
			}catch(StringEmptyException see) {
				//TODO: user_profile path
				req.getRequestDispatcher("").forward(req,resp);
			}
		}
		if(gender != user.getGender()) {
			try {
				us.modifiedGender(gender,uid);
			}catch(GenderValueException gve) {
				//TODO: user_profile path
				req.getRequestDispatcher("").forward(req,resp);
			}
		}
	}
}
