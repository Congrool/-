package cn.newshome.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.newshome.Entity.UserEntity;
import cn.newshome.Service.UserService;
import cn.newshome.Service.ex.PasswordEmptyException;
import cn.newshome.Service.ex.PasswordErrorException;
import cn.newshome.Service.ex.UserDoesNotExistException;
import cn.newshome.Service.ex.UsernameEmptyException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String usname = req.getParameter("username");
		String psword = req.getParameter("password");
		
		req.setAttribute("username", usname);
		UserService userService = new UserService();

		
		try {
			UserEntity user = userService.Login(usname, psword);
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("./userdata.html");
		}catch(PasswordErrorException pee) {
			req.setAttribute("Message", "密码错误");
			//TODO: login path
			req.getRequestDispatcher("").forward(req,resp);
		}catch(UserDoesNotExistException udnee) {
			req.setAttribute("Message", "用户名不存在");
			//TODO: login path
			req.getRequestDispatcher("").forward(req,resp);
		}catch(UsernameEmptyException uee) {
			req.setAttribute("Message", "用户名为空");
			//TODO: login path
			req.getRequestDispatcher("").forward(req,resp);
		}catch(PasswordEmptyException pee) {
			req.setAttribute("Message", "密码为空");
			//TODO: login path
			req.getRequestDispatcher("").forward(req,resp);
		}
	}
}
