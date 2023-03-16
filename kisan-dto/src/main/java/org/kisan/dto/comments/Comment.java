package org.kisan.dto.comments;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CompanyGen")
	@SequenceGenerator(name="CompanyGen", sequenceName="CompanySeq", allocationSize=1)
	private int id;
	private String comment;
	private String auther;
	private String date;
	private Comment comments;
	
	public Comment() {
		
		this.comments = null;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Comment getGapshap() {
		return comments;
	}
	public void setGapshap(Comment comments) {
		this.comments = comments;
	}
}
