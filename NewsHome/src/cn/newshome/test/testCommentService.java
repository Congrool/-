package cn.newshome.test;

import java.util.Vector;

import cn.newshome.Entity.CommentEntity;
import cn.newshome.Service.CommentService;
import cn.newshome.Service.ex.CommentBodyEmptyException;
import cn.newshome.Service.ex.CommentNotExistException;
import cn.newshome.Service.ex.NewsDoesNotExistException;
import cn.newshome.Service.ex.UserDoesNotExistException;

public class testCommentService {
	CommentService cs = new CommentService();
	public void testinsert(CommentEntity comm) {
		try {
			cs.commentInsert(comm);
		} catch (CommentBodyEmptyException e) {
			e.printStackTrace();
		}
	}
	public void testdelete(Integer commentid) {
		try {
			cs.commentDelete(commentid);
		} catch (CommentNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testsearchByuid(Integer uid) {
		Vector<Vector<Object>> res;
		try {
			res = cs.searchByuid(uid);
			for(int i = 0; i < res.size(); i++)
				for(int j = 0; j < res.elementAt(i).size(); j++)
					System.out.println(res.elementAt(i).elementAt(j));
		} catch (UserDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CommentNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void testsearchBynewsid(Integer newsid) {
		CommentEntity[] res;
		try {
			res = cs.searchBynewsid(newsid);

		} catch (NewsDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CommentNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		testCommentService cs = new testCommentService();
		
//		CommentEntity comm = new CommentEntity(3, 4, "wdnmd", new Timestamp(System.currentTimeMillis()));
//		cs.testinsert(comm);
		
//		cs.testsearchBynewsid(4);
		
//		cs.testsearchByuid(3);
		
		cs.testdelete(17);
	}
}
