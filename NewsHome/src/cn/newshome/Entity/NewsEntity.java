package cn.newshome.Entity;

import java.sql.Timestamp;

public class NewsEntity {
	private String newsID;
	private String keywords;
	private String newsbody;
	private Timestamp created_time;
	
	public NewsEntity(String newsID, String keywords, String newsbody, Timestamp created_time) {
		super();
		this.newsID = newsID;
		this.keywords = keywords;
		this.newsbody = newsbody;
		this.created_time = created_time;
	}
	public NewsEntity() {}
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
	public Timestamp getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}

}
