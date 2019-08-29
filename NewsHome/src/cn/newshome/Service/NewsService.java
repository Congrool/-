package cn.newshome.Service;

import java.sql.Timestamp;

import cn.newshome.Dao.NewsDao;
import cn.newshome.Entity.NewsEntity;
import cn.newshome.Service.ex.NewsDoesNotExist;

public class NewsService {
	public NewsEntity getNewsByNewsid(Integer newsid) throws NewsDoesNotExist{
		NewsDao nd = new NewsDao();
		Object[] res = nd.selectByNewsid(newsid);
		if(res == null) {
			throw new NewsDoesNotExist("新闻不存在");
		}
		
		NewsEntity news = new NewsEntity();
		news.setNewsID((int)res[0]);
		news.setNews_keywords((String)res[1]);
		news.setTitle((String)res[2]);
		news.setNewsbody((String)res[3]);
		news.setCreated_time((Timestamp)res[4]);
		
		return news;
	}
}
