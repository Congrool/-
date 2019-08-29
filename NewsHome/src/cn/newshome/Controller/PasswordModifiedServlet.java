package cn.newshome.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import org.apache.catalina.User;

import cn.newshome.Entity.UserEntity;
import cn.newshome.Service.UserService;
import cn.newshome.Service.ex.PasswordEmptyException;

public class PasswordModifiedServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String newpwd = req.getParameter("new_password");
		String newpws_again = req.getParameter("new_password_again");
		String rawpwd = req.getParameter("raw_password");
		
		if(newpwd == null) {
			//TODO: user_password_modified path
			req.setAttribute("Message", "密码为空");
			req.getRequestDispatcher("").forward(req, resp);
			return;
		}
		if(!newpwd.equals(newpws_again)) {
			//TODO: user_password_modified path
			req.setAttribute("Message", "两次密码不一致");
			req.getRequestDispatcher("").forward(req,resp);
			return;
		}
		
		UserEntity user = (UserEntity)(req.getSession().getAttribute("user"));
		if(user == null) {
			//TODO: to login path
			resp.sendRedirect("./login.html");
			return;
		}
		if(!rawpwd.equals(user.getPassword())) {
			//TODO:user_password_modified path
			req.setAttribute("Message", "原密码错误");
			req.getRequestDispatcher("").forward(req,resp);
			return;
		}
		
		UserService us = new UserService();
		try {
			us.modifiedPassword(newpwd, user.getUID());
		} catch (PasswordEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("Message", "密码为空");
			req.getRequestDispatcher("").forward(req, resp);
		}
		
	}
}
