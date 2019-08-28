package cn.newshome.test.Dao;

import java.util.Vector;
import cn.newshome.Dao.CommentDao;

public class testCommentDao {
	public static void main(String[] args){
		CommentDao cd = new CommentDao();
		Vector<Vector<Object>> res = cd.selectByUid("6");
		for(int i = 0; i < res.size(); i++)
			for(int j = 0; j < res.elementAt(i).size(); j++)
				System.out.println(res.elementAt(i).elementAt(j));
		cd.deleteByCommentid("2");
	}
}
