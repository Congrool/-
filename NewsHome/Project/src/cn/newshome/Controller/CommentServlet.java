package cn.newshome.Controller;


import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.newshome.Entity.CommentEntity;
import cn.newshome.Entity.UserEntity;
import cn.newshome.Service.CommentService;
import cn.newshome.Service.ex.CommentBodyEmptyException;

/**
 * 用户评论时触发
 * 提交评论记录
 * @author 张逸飞
 */
@WebServlet("/commentservice")
public class CommentServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String comment = req.getParameter("comment_text");
		String news_path = req.getParameter("news_path");
		String news_id =req.getParameter("newsid");
		
		System.out.println(comment);
		
		//news_id="101";
		req.setAttribute("newsid", news_id);
		
		UserEntity user = (UserEntity)(req.getSession().getAttribute("user"));
		
		/* System.out.printn(user.getUsername()); */
		
		//检测是否登陆
		if(user == null) {
			//TODO:news_path jsp path
			req.setAttribute("Message", "请先登陆");
			req.getRequestDispatcher("").forward(req, resp);
			return;
		}
		
		//评论栏为空
		if(comment == null || comment.equals("")) {
			//TODO: news_path jsp path
			req.setAttribute("Message", "评论不能为空");
			req.getRequestDispatcher("").forward(req,resp);
			return;
		}
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		CommentEntity comm = new CommentEntity();
		comm.setCreated_time(ts);
		comm.setCommentText(comment);
		comm.setNewsID(Integer.parseInt(news_id));
		comm.setUID(user.getUID());
		
		CommentService cs = new CommentService();
		try {
			System.out.println("do");
			cs.commentInsert(comm);
			
			System.out.println("done");
			req.getRequestDispatcher("/NewsDetail?newsid="+news_id).forward(req, resp);
			
		}catch(CommentBodyEmptyException cbee) {
			//TODO: news_path jsp path
			System.out.println("Exception");
			
			req.setAttribute("Message", "评论不能为空");
			req.getRequestDispatcher("/Newsdtail.jsp").forward(req,resp);
		}
	}
}
