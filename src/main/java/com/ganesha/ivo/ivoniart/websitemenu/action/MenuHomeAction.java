package com.ganesha.ivo.ivoniart.websitemenu.action;

import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuhome.MenuHome;
import com.ganesha.ivo.ivoniart.websitemenu.WebsiteMenuAction;

public class MenuHomeAction extends WebsiteMenuAction<MenuHome> {
	private static final long serialVersionUID = -2767499531394717306L;

	public MenuHomeAction() throws AppException {
		super(MenuHome.class);
	}
}
