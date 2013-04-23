package com.ganesha.ivo.ivoniart.websitemenu.action;

import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuabout.MenuAbout;
import com.ganesha.ivo.ivoniart.websitemenu.WebsiteMenuAction;

public class MenuAboutAction extends WebsiteMenuAction<MenuAbout> {
	private static final long serialVersionUID = -2767499531394717306L;

	public MenuAboutAction() throws AppException {
		super(MenuAbout.class);
	}
}
