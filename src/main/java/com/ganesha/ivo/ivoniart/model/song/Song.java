package com.ganesha.ivo.ivoniart.model.song;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ganesha.basicweb.model.Trackable;

@Entity
@Table(name = "ms_song")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Song extends Trackable {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String title;
	private String artist;
	private long duration;
	private int size;
	private String description;

	public String getArtist() {
		return artist;
	}

	public String getDescription() {
		return description;
	}

	public long getDuration() {
		return duration;
	}

	public String getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public String getTitle() {
		return title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
