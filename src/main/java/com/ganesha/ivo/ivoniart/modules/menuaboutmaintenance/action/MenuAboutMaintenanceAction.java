package com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.action;

import java.util.List;

import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.MenuAboutMaintenanceBL;
import com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.MenuAboutMaintenanceForm;
import com.ganesha.struts2.FormAction;

public class MenuAboutMaintenanceAction extends
		FormAction<MenuAboutMaintenanceForm, MenuAboutMaintenanceBL> {

	private static final long serialVersionUID = 1L;

	private List<String> listPictureTitles;

	public MenuAboutMaintenanceAction() throws AppException {
		super(MenuAboutMaintenanceForm.class, MenuAboutMaintenanceBL.class);
	}

	public List<String> getListPictureTitles() {
		return listPictureTitles;
	}

	public void setListPictureTitles(List<String> listPictureTitles) {
		this.listPictureTitles = listPictureTitles;
	}
}
