package com.ganesha.ivo.ivoniart.model.menumusics;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ganesha.ivo.ivoniart.model.BasicWebsiteMenu;
import com.ganesha.ivo.ivoniart.model.song.Song;

@Entity
@Table(name = "ms_menu_musics")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class MenuMusics extends BasicWebsiteMenu {

	private static final long serialVersionUID = -1218882314919256632L;

	@ManyToMany
	@JoinTable(name = "ms_song_list", joinColumns = @JoinColumn(name = "musics_id"), inverseJoinColumns = @JoinColumn(name = "song_id"))
	private List<Song> songs;

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
}
