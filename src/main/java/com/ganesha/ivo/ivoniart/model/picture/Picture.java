package com.ganesha.ivo.ivoniart.model.picture;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ganesha.basicweb.model.Trackable;

@Entity
@Table(name = "ms_picture")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Picture extends Trackable {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String description;
	private String comment;

	public String getComment() {
		return comment;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}
}
