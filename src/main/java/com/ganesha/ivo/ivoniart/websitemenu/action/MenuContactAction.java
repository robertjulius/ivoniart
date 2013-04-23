package com.ganesha.ivo.ivoniart.websitemenu.action;

import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menucontact.MenuContact;
import com.ganesha.ivo.ivoniart.websitemenu.WebsiteMenuAction;

public class MenuContactAction extends WebsiteMenuAction<MenuContact> {
	private static final long serialVersionUID = -2767499531394717306L;

	public MenuContactAction() throws AppException {
		super(MenuContact.class);
	}
}
