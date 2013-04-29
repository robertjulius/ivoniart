package com.ganesha.ivo.ivoniart.websitemenu.action;

import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuhome.MenuHome;
import com.ganesha.ivo.ivoniart.websitemenu.WebsiteMenuAction;

public class MenuHomeAction extends WebsiteMenuAction {
	private static final long serialVersionUID = -2767499531394717306L;

	private MenuHome menuHome;

	public MenuHomeAction() throws AppException {
		menuHome = (MenuHome) getDBSession().createCriteria(MenuHome.class)
				.uniqueResult();
	}

	public MenuHome getMenuHome() {
		return menuHome;
	}
}
