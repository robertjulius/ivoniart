package com.ganesha.ivo.ivoniart.model.webitems;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ganesha.basicweb.model.Trackable;
import com.ganesha.ivo.ivoniart.model.picture.Picture;

@Entity
@Table(name = "ms_web_items")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class WebItems extends Trackable {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "logo_img")
	private Picture logoImage;

	@Column(length = 1024)
	private String copyright;

	@ManyToOne
	@JoinColumn(name = "bg_img")
	private Picture backgroundImage;

	public Picture getBackgroundImage() {
		return backgroundImage;
	}

	public String getCopyright() {
		return copyright;
	}

	public String getId() {
		return id;
	}

	public Picture getLogoImage() {
		return logoImage;
	}

	public void setBackgroundImage(Picture backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLogoImage(Picture logoImage) {
		this.logoImage = logoImage;
	}
}
