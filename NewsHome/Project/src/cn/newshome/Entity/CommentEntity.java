package cn.newshome.Entity;

import java.sql.Date;
import java.sql.Timestamp;

public class CommentEntity {
	private Integer commentID;
	private Integer UID;
	private Integer newsID;
	private String commentText;
	private Timestamp created_time;
	public CommentEntity(Integer uID, Integer newsID, String commentText, Timestamp created_time) {
		super();
		UID = uID;
		this.newsID = newsID;
		this.commentText = commentText;
		this.created_time = created_time;
	}
	public CommentEntity() {}
	public Integer getCommentID() {
		return commentID;
	}
	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}
	public Integer getUID() {
		return UID;
	}
	public void setUID(Integer uID) {
		UID = uID;
	}
	public Integer getNewsID() {
		return newsID;
	}
	public void setNewsID(Integer newsID) {
		this.newsID = newsID;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Timestamp getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}
}
