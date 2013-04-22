package com.ganesha.ivo.ivoniart.model.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ganesha.basicweb.model.Trackable;
import com.ganesha.ivo.ivoniart.model.picture.Picture;

@Entity
@Table(name = "ms_service")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Service extends Trackable {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@ManyToOne
	@JoinColumn(name = "picture_id")
	private Picture picture;

	private String title;

	@Column(length = 1024)
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
