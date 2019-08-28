package cn.newshome.Entity;

import java.sql.Date;

public class NewsEntity {
	private String newsID;
	private String keywords;
	private String newsbody;
	private Date created_time;
	public NewsEntity(String newsID, String keywords, String newsbody, Date created_time) {
		super();
		this.newsID = newsID;
		this.keywords = keywords;
		this.newsbody = newsbody;
		this.created_time = created_time;
	}
	public String getNewsID() {
		return newsID;
	}
	public void setNewsID(String newsID) {
		this.newsID = newsID;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getNewsbody() {
		return newsbody;
	}
	public void setNewsbody(String newsbody) {
		this.newsbody = newsbody;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	
}
