package com.ganesha.ivo.ivoniart.websitemenu.action;

import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuabout.MenuAbout;
import com.ganesha.ivo.ivoniart.websitemenu.WebsiteMenuAction;

public class MenuAboutAction extends WebsiteMenuAction {
	private static final long serialVersionUID = -2767499531394717306L;

	private MenuAbout websiteMenu;

	public MenuAboutAction() throws AppException {
		websiteMenu = (MenuAbout) getDBSession()
				.createCriteria(MenuAbout.class).uniqueResult();
	}

	public MenuAbout getWebsiteMenu() {
		return websiteMenu;
	}
}
