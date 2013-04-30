package com.ganesha.ivo.ivoniart.model.menuabout;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ganesha.ivo.ivoniart.model.BasicWebsiteMenu;

@Entity
@Table(name = "ms_menu_about")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class MenuAbout extends BasicWebsiteMenu {

	private static final long serialVersionUID = -1218882314919256632L;

}
