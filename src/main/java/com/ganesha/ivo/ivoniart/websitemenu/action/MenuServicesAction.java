package com.ganesha.ivo.ivoniart.websitemenu.action;

import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuservices.MenuServices;
import com.ganesha.ivo.ivoniart.websitemenu.WebsiteMenuAction;

public class MenuServicesAction extends WebsiteMenuAction {
	private static final long serialVersionUID = -2767499531394717306L;

	private MenuServices websiteMenu;

	public MenuServicesAction() throws AppException {
		websiteMenu = (MenuServices) getDBSession().createCriteria(
				MenuServices.class).uniqueResult();
	}

	public MenuServices getWebsiteMenu() {
		return websiteMenu;
	}
}
