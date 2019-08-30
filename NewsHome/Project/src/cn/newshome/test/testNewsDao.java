package cn.newshome.test;

import cn.newshome.Dao.NewsDao;

public class testNewsDao {

	public static void main(String[] args) {
		NewsDao nd = new NewsDao();
		Object[] res = nd.selectByNewsid(1);
		for(int i = 0; i < res.length; i++)
			System.out.println(res[i]);
	}

}
