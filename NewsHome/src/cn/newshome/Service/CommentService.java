package cn.newshome.Service;

import java.sql.Timestamp;
import java.util.Vector;

import cn.newshome.Dao.CommentDao;
import cn.newshome.Dao.UserDao;
import cn.newshome.Entity.CommentEntity;
import cn.newshome.Service.ex.CommentBodyEmptyException;
import cn.newshome.Service.ex.CommentNotExistException;
import cn.newshome.Service.ex.NewsDoesNotExistException;
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
	public CommentEntity[] searchByuid(Integer uid) throws UserDoesNotExistException, CommentNotExistException{
		CommentDao cd = new CommentDao();
		UserDao ud = new UserDao();
		if(ud.SelectByUid(uid) == null) {
			throw new UserDoesNotExistException("用户不存在");
		}
		
		Vector<Vector<Object> > res = cd.selectByUid(uid);
		if(res == null) {
			throw new CommentNotExistException("没有评论");
		}
		
		CommentEntity[] ret = new CommentEntity[res.size()];
		for(int i = 0; i < res.size(); i++) {
			CommentEntity tmp = new CommentEntity();
			tmp.setCommentID((int)res.elementAt(i).get(0));
			tmp.setUID((int)res.elementAt(i).get(1));
			tmp.setNewsID((int)res.elementAt(i).get(2));
			tmp.setCommentText((String)res.elementAt(i).get(3));
			tmp.setCreated_time((Timestamp)res.elementAt(i).get(4));
			ret[i] = tmp;
		}
		return ret;
	}
	public CommentEntity[] searchBynewsid(Integer newsid)throws NewsDoesNotExistException,CommentNotExistException{
		
		CommentDao cd = new CommentDao();
		if(cd.selectByNewsid(newsid) == null) {
			throw new NewsDoesNotExistException("新闻不存在");
		}
		
		Vector<Vector<Object> > res = cd.selectByNewsid(newsid);
		if(res == null) {
			throw new CommentNotExistException("没有评论");
		}
		
		CommentEntity[] ret = new CommentEntity[res.size()];
		
		for(int i = 0; i < res.size(); i++) {
			CommentEntity tmp = new CommentEntity();
			tmp.setCommentID((int)res.elementAt(i).get(0));
			tmp.setUID((int)res.elementAt(i).get(1));
			tmp.setNewsID((int)res.elementAt(i).get(2));
			tmp.setCommentText((String)res.elementAt(i).get(3));
			tmp.setCreated_time((Timestamp)res.elementAt(i).get(4));
			ret[i] = tmp;
		}
				
		return ret;
	}
}
