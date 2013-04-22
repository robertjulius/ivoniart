package com.ganesha.ivo.ivoniart.model.picture;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ganesha.basicweb.model.Trackable;

@Entity
@Table(name = "ms_picture")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Picture extends Trackable {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	private String id;

	private String title;
	private String comment;

	public String getComment() {
		return comment;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
