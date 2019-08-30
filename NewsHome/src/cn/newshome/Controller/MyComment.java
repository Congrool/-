package cn.newshome.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.newshome.Entity.CommentEntity;
import cn.newshome.Entity.UserEntity;
import cn.newshome.Service.CommentService;
import cn.newshome.Service.NewsService;
import cn.newshome.Service.ex.CommentNotExistException;
import cn.newshome.Service.ex.NewsDoesNotExistException;
import cn.newshome.Service.ex.UserDoesNotExistException;

public class MyComment extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		UserEntity user = (UserEntity)req.getSession().getAttribute("user");
		int uid = user.getUID();
		
		CommentService cs = new CommentService();
		NewsService ns = new NewsService();
		
		CommentEntity[] commArr = null;
		String[] newsTitle = null;
		String[][] res = null;
		
		try {
			commArr = cs.searchByuid(uid);
			newsTitle = new String[commArr.length];
			res = new String[commArr.length][2];
			for(int i = 0; i < commArr.length; i++) {
				int newsid = commArr[i].getNewsID();
				newsTitle[i] = ns.getNewsByNewsid(newsid).getTitle();
				res[i][0] = newsTitle[i];
				res[i][1] = commArr[i].getCommentText();
			}
			req.getSession().setAttribute("commentAndNewsTitle", res);
		}catch(UserDoesNotExistException udne) {
			udne.printStackTrace();
		}catch(NewsDoesNotExistException ndnee) {
			ndnee.printStackTrace();
		}catch(CommentNotExistException cnee) {
			cnee.printStackTrace();
		}		
	}
}
