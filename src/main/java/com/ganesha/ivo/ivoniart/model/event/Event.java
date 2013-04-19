package com.ganesha.ivo.ivoniart.model.event;

import java.sql.Timestamp;

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
@Table(name = "ms_event")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Event extends Trackable {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String title;
	private String content;
	private String location;

	@Column(name = "event_date")
	private Timestamp eventDate;

	@ManyToOne
	@JoinColumn(name = "picture_id")
	private Picture picture;

	public String getContent() {
		return content;
	}

	public Timestamp getEventDate() {
		return eventDate;
	}

	public String getId() {
		return id;
	}

	public String getLocation() {
		return location;
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

	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
