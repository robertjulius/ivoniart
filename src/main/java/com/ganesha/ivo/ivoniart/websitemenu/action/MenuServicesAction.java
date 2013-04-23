package com.ganesha.ivo.ivoniart.websitemenu.action;

import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuservices.MenuServices;
import com.ganesha.ivo.ivoniart.websitemenu.WebsiteMenuAction;

public class MenuServicesAction extends WebsiteMenuAction<MenuServices> {
	private static final long serialVersionUID = -2767499531394717306L;

	public MenuServicesAction() throws AppException {
		super(MenuServices.class);
	}
}
