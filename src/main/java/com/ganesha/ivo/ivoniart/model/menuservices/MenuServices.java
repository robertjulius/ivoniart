package com.ganesha.ivo.ivoniart.model.menuservices;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ganesha.ivo.ivoniart.model.BasicWebsiteMenu;
import com.ganesha.ivo.ivoniart.model.service.Service;

@Entity
@Table(name = "ms_menu_services")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class MenuServices extends BasicWebsiteMenu {

	private static final long serialVersionUID = -1218882314919256632L;

	@ManyToMany
	@JoinTable(name = "ms_service_list", joinColumns = @JoinColumn(name = "home_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	private List<Service> services;

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
}
