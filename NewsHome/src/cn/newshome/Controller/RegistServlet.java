package cn.newshome.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.newshome.Entity.UserEntity;
import cn.newshome.Service.UserService;
import cn.newshome.Service.ex.PasswordEmptyException;
import cn.newshome.Service.ex.UsernameContainsillegalCharacterException;
import cn.newshome.Service.ex.UsernameEmptyException;
import cn.newshome.Service.ex.UsernameIsUsedException;

public class RegistServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String usname = req.getParameter("username");
		String psword = req.getParameter("password");
		String psword_again = req.getParameter("password_again");
		String email = req.getParameter("email");
		
		if(psword_again == null || psword == null) {
			req.setAttribute("Message", "密码不能为空");
			req.setAttribute("username", usname);
			//TODO:jsp path
			req.getRequestDispatcher("");
			return;
		}
		if(!psword.equals(psword_again)) {
			req.setAttribute("Message", "两次密码不一致!");
			req.setAttribute("username", usname);
			req.getRequestDispatcher("./jsp/Register.jsp").forward(req,resp);
			return;
		}		
		UserEntity user = new UserEntity();
		user.setPassword(psword);
		user.setUsername(usname);
		user.setEmail(email);
		req.setAttribute("username", usname);
		
		UserService userService = new UserService();
		try {
			userService.Regist(user);
			//TODO:to login path
			resp.sendRedirect("");
		}catch(UsernameIsUsedException uue) {
			req.setAttribute("Message", "用户名已存在");
			//TODO:regist jsp path
			req.getRequestDispatcher("").forward(req, resp);
		}catch(UsernameEmptyException uee) {
			req.setAttribute("Message", "用户名为空");
			//TODO:regist jsp path
			req.getRequestDispatcher("").forward(req, resp);
		}catch(PasswordEmptyException pee) {
			//TODO:regist jsp path
			req.getRequestDispatcher("").forward(req, resp);
		}catch(UsernameContainsillegalCharacterException ucce) {
			//TODO:regist jsp path
			req.getRequestDispatcher("").forward(req, resp);
		}
	}
}
