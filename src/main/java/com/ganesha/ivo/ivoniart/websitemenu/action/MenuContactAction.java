package com.ganesha.ivo.ivoniart.websitemenu.action;

import java.util.Map;

import com.ganesha.core.exception.AppException;
import com.ganesha.core.utils.MappingUtils;
import com.ganesha.ivo.ivoniart.model.menucontact.MenuContact;
import com.ganesha.ivo.ivoniart.websitemenu.WebsiteMenuAction;

public class MenuContactAction extends WebsiteMenuAction<MenuContact> {
	private static final long serialVersionUID = -2767499531394717306L;

	public MenuContactAction() throws AppException {
		super(MenuContact.class);
	}

	@Override
	public String execute() throws Exception {
		MenuContact menuContact = (MenuContact) getDBSession().createCriteria(
				MenuContact.class).uniqueResult();

		Map<String, Object> map = MappingUtils.pojoToMap(menuContact);
		MappingUtils.mapToPojo(map, getModel());

		return super.execute();
	}
}
