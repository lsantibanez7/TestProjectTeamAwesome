package com.proj2.model;

public class Works {

	private int id;
	private int apiId;
	private String comment;
	private int userId;
	
	
	public Works(int id, int apiId, String comment, int userId) {
		this.id = id;
		this.apiId = apiId;
		this.comment = comment;
		this.userId = userId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getApiId() {
		return apiId;
	}


	public void setApiId(int apiId) {
		this.apiId = apiId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + id;
		result = prime * result + apiId;
		result = prime * result + userId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Works other = (Works) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id != other.id)
			return false;
		if (apiId != other.apiId)
			return false; 
		if (userId != other.userId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Works [id=" + id + ", url=" + apiId + ", comment=" + comment + ", userId=" + userId + "]";
	}
	
}
