package cn.newshome.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.newshome.Entity.CommentEntity;
import cn.newshome.Entity.NewsEntity;
import cn.newshome.Entity.UserEntity;
import cn.newshome.Service.CommentService;
import cn.newshome.Service.NewsService;
import cn.newshome.Service.UserService;
import cn.newshome.Service.ex.CommentNotExistException;
import cn.newshome.Service.ex.NewsDoesNotExistException;

public class PageGenerate extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		Integer newsid = Integer.parseInt(req.getParameter("news_id"));
		
		NewsService ns = new NewsService();
		CommentService cs = new CommentService();
		UserService us = new UserService();
		try {
			NewsEntity news = ns.getNewsByNewsid(newsid);
			String news_content = news.getNewsbody();
			String news_title = news.getTitle();
			req.setAttribute("news_content", news_content);
			req.setAttribute("news_title", news_title);				
			
			//获得评论数组
			CommentEntity[] comm = cs.searchBynewsid(newsid);
			
			//获得uid对应用户名
			String[] username = new String[comm.length];
			for(int i = 0; i < comm.length; i++) {
				UserEntity user = us.searchUserInfoByUID(comm[i].getUID());
				if(user != null) { 
					username[i] = user.getUsername();
				}
			}
			
			//评论和用户名拼接，前面时评论，后面是用户名
			String[][] commentAndUsername = new String[comm.length][6];
 			for(int i = 0; i < commentAndUsername.length; i++) {
 				commentAndUsername[i][0] = comm[i].getCommentID().toString();
 				commentAndUsername[i][1] = comm[i].getUID().toString();
 				commentAndUsername[i][2] = comm[i].getNewsID().toString();
 				commentAndUsername[i][3] = comm[i].getCommentText();
 				commentAndUsername[i][4] = comm[i].getCreated_time().toString();
 				commentAndUsername[i][5] = username[i];
 			}
			
 			req.setAttribute("commentAndUsername", commentAndUsername);
			//TODO: page jsp path
			req.getRequestDispatcher("").forward(req,resp);
			
		}catch(NewsDoesNotExistException nnee) {
			// impossible
			nnee.printStackTrace();
		}catch(CommentNotExistException cnee){
			System.out.println("没有评论");
		}	
	}
}
