package cn.newshome.Service;

import java.util.Vector;

import cn.newshome.Dao.CommentDao;
import cn.newshome.Dao.UserDao;
import cn.newshome.Entity.CommentEntity;
import cn.newshome.Service.ex.CommentBodyEmptyException;
import cn.newshome.Service.ex.CommentNotExistException;
import cn.newshome.Service.ex.UserDoesNotExistException;

/**
 * Comment insert
 * delete
 * selectByuid
 * selectBynewsid
 * @author 张逸飞
 *
 */
public class CommentService {
	public int commentInsert(CommentEntity comm) throws CommentBodyEmptyException{
		if(comm.getCommentText() == null) {
			throw new CommentBodyEmptyException("评论为空");
		}
		CommentDao cd = new CommentDao();
		
		int num = cd.insert(comm);
		return num;		
	}
	public int commentDelete(Integer commentid) throws CommentNotExistException {
		CommentDao cd = new CommentDao();
		Object[] tmp = cd.selectByCommentid(commentid);
		if(tmp == null) {
			throw new CommentNotExistException("评论不存在");
		}
		int num = cd.deleteByCommentid(commentid);
		return num;
	}
	public Vector<Vector<Object>> searchByuid(Integer uid) throws UserDoesNotExistException, CommentNotExistException{
		CommentDao cd = new CommentDao();
		UserDao ud = new UserDao();
		if(ud.SelectByUid(uid) == null) {
			throw new UserDoesNotExistException("用户不存在");
		}
		
		Vector<Vector<Object> > res = cd.selectByUid(uid);
		if(res == null) {
			throw new CommentNotExistException("没有评论");
		}
		return res;
	}
	public Vector<Vector<Object>> searchBynewsid(Integer newsid)throws UserDoesNotExistException,CommentNotExistException{
		
		CommentDao cd = new CommentDao();
		UserDao ud = new UserDao();
		if(cd.selectByNewsid(newsid) == null) {
			throw new UserDoesNotExistException("新闻不存在");
		}
		
		Vector<Vector<Object> > res = cd.selectByNewsid(newsid);
		if(res == null) {
			throw new CommentNotExistException("没有评论");
		}
		return res;
	}
}
