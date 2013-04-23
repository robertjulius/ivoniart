package com.ganesha.ivo.ivoniart.modules.menuhomemaintenance.action;

import java.util.List;

import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.modules.menuhomemaintenance.MenuHomeMaintenanceBL;
import com.ganesha.ivo.ivoniart.modules.menuhomemaintenance.MenuHomeMaintenanceForm;
import com.ganesha.struts2.FormAction;

public class MenuHomeMaintenanceAction extends
		FormAction<MenuHomeMaintenanceForm, MenuHomeMaintenanceBL> {

	private static final long serialVersionUID = 1L;

	private List<String> listPictures;

	public MenuHomeMaintenanceAction() throws AppException {
		super(MenuHomeMaintenanceForm.class, MenuHomeMaintenanceBL.class);
	}

	public List<String> getListPictures() {
		return listPictures;
	}

	public void setListPictures(List<String> listPictures) {
		this.listPictures = listPictures;
	}
}
