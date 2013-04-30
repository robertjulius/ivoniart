package com.ganesha.ivo.ivoniart.model.menucontact;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ganesha.ivo.ivoniart.model.BasicWebsiteMenu;

@Entity
@Table(name = "ms_menu_contact")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class MenuContact extends BasicWebsiteMenu {

	private static final long serialVersionUID = -1218882314919256632L;

	private String address;
	private String phone;
	private String email;

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}