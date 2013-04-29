package com.ganesha.ivo.ivoniart.model.menucontact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ganesha.basicweb.model.Trackable;

@Entity
@Table(name = "ms_menu_contact")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class MenuContact extends Trackable {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	private String id;

	private String title;
	private String address;
	private String phone;
	private String email;

	@Column(length = 10240)
	private String content;

	public String getAddress() {
		return address;
	}

	public String getContent() {
		return content;
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	public String getTitle() {
		return title;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}