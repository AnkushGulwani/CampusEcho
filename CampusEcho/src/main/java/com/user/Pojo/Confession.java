package com.user.Pojo;

public class Confession {
	private int id;
	private String message;
	private String tag;
	private String timestamp;
	private String postedBy;
	private int likes;
	private int dislikes;
	private boolean isApproved;

	public Confession() {

	}

	public Confession(int id, String message, String tag, String timestamp, int likes, int dislikes, boolean isApproved,
			String postedBy) {
		super();
		this.id = id;
		this.message = message;
		this.tag = tag;
		this.timestamp = timestamp;
		this.likes = likes;
		this.dislikes = dislikes;
		this.isApproved = isApproved;
		this.postedBy = postedBy;
	}

	

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

}