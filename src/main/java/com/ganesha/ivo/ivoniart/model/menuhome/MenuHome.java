package com.ganesha.ivo.ivoniart.model.menuhome;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ganesha.basicweb.model.Trackable;
import com.ganesha.ivo.ivoniart.model.picture.Picture;

@Entity
@Table(name = "ms_menu_home")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class MenuHome extends Trackable {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	private String id;

	@ManyToMany
	@JoinTable(name = "ms_home_pictures", joinColumns = @JoinColumn(name = "home_id"), inverseJoinColumns = @JoinColumn(name = "picture_id"))
	private List<Picture> pictures;

	@Column(name = "quick_link1")
	private String quickLink1;

	@Column(name = "quick_link2")
	private String quickLink2;

	public String getId() {
		return id;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public String getQuickLink1() {
		return quickLink1;
	}

	public String getQuickLink2() {
		return quickLink2;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public void setQuickLink1(String quickLink1) {
		this.quickLink1 = quickLink1;
	}

	public void setQuickLink2(String quickLink2) {
		this.quickLink2 = quickLink2;
	}
}
