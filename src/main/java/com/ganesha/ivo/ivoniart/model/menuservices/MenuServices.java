package com.ganesha.ivo.ivoniart.model.menuservices;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ganesha.basicweb.model.Trackable;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.service.Service;

@Entity
@Table(name = "ms_menu_services")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class MenuServices extends Trackable {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "picture_id")
	private Picture picture;

	private String title;

	@Column(length = 10240)
	private String content;

	@ManyToMany
	@JoinTable(name = "ms_service_list", joinColumns = @JoinColumn(name = "home_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	private List<Service> services;

	public String getContent() {
		return content;
	}

	public String getId() {
		return id;
	}

	public Picture getPicture() {
		return picture;
	}

	public List<Service> getServices() {
		return services;
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

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
