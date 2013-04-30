package com.ganesha.ivo.ivoniart.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ganesha.basicweb.model.Trackable;
import com.ganesha.ivo.ivoniart.model.picture.Picture;

@MappedSuperclass
public abstract class BasicWebsiteMenu extends Trackable {

	private static final long serialVersionUID = -490441473844263342L;

	@Id
	private String id;

	private String title;

	@ManyToOne
	@JoinColumn(name = "picture_id")
	private Picture picture;

	@Column(length = 10240)
	private String content;

	public String getContent() {
		return content;
	}

	public String getId() {
		return id;
	}

	public Picture getPicture() {
		return picture;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
