package cn.newshome.Entity;

import java.sql.Timestamp;

public class NewsEntity {
	private Integer newsID;
	private String news_keywords;
	private String title;
	private String newsbody;
	private Timestamp created_time;
	
	public NewsEntity() {}

	public NewsEntity(String news_keywords, String title, String newsbody, Timestamp created_time) {
		super();
		this.news_keywords = news_keywords;
		this.title = title;
		this.newsbody = newsbody;
		this.created_time = created_time;
	}

	public Integer getNewsID() {
		return newsID;
	}

	public void setNewsID(Integer newsID) {
		this.newsID = newsID;
	}

	public String getNews_keywords() {
		return news_keywords;
	}

	public void setNews_keywords(String news_keywords) {
		this.news_keywords = news_keywords;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNewsbody() {
		return newsbody;
	}

	public void setNewsbody(String newsbody) {
		this.newsbody = newsbody;
	}

	public Timestamp getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}
	
}
