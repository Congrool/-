package cn.newshome.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.newshome.Entity.NewsEntity;
import cn.newshome.Service.NewsService;
import cn.newshome.Service.ex.NewsDoesNotExist;

public class PageGenerate extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		Integer newsid = Integer.parseInt(req.getParameter("news_id"));
		
		NewsService ns = new NewsService();
		
		try {
			NewsEntity news = ns.getNewsByNewsid(newsid);
			String news_content = news.getNewsbody();
			String news_title = news.getTitle();
			req.setAttribute("news_content", news_content);
			req.setAttribute("news_title", news_title);
			
			//TODO: page jsp path
			req.getRequestDispatcher("").forward(req,resp);
			
		}catch (NewsDoesNotExist ndne) {
			// TODO: impossible
			ndne.printStackTrace();
		}
		
		
	}
}
