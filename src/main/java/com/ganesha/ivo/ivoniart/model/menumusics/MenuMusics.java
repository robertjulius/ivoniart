package com.ganesha.ivo.ivoniart.model.menumusics;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ganesha.basicweb.model.Trackable;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.song.Song;

@Entity
@Table(name = "ms_menu_musics")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class MenuMusics extends Trackable {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "picture_id")
	private Picture picture;

	private String title;
	private String content;

	@ManyToMany
	@JoinTable(name = "ms_song_list", joinColumns = @JoinColumn(name = "musics_id"), inverseJoinColumns = @JoinColumn(name = "song_id"))
	private List<Song> songs;

	public String getContent() {
		return content;
	}

	public String getId() {
		return id;
	}

	public Picture getPicture() {
		return picture;
	}

	public List<Song> getSongs() {
		return songs;
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

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
