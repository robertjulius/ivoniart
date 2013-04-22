package com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.action;

import java.util.List;

import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.MenuServicesMaintenanceBL;
import com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.MenuServicesMaintenanceForm;
import com.ganesha.struts2.FormAction;

public class MenuServicesMaintenanceAction extends
		FormAction<MenuServicesMaintenanceForm, MenuServicesMaintenanceBL> {

	private static final long serialVersionUID = 1L;

	private List<String> listServices;

	public MenuServicesMaintenanceAction() throws AppException {
		super(MenuServicesMaintenanceForm.class,
				MenuServicesMaintenanceBL.class);
	}

	public List<String> getListServices() {
		return listServices;
	}

	public void setListServices(List<String> listServices) {
		this.listServices = listServices;
	}
}
