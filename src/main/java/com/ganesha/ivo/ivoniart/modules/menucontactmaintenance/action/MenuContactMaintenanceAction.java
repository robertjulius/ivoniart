package com.ganesha.ivo.ivoniart.modules.menucontactmaintenance.action;

import com.ganesha.ivo.ivoniart.modules.menucontactmaintenance.MenuContactMaintenanceBL;
import com.ganesha.ivo.ivoniart.modules.menucontactmaintenance.MenuContactMaintenanceForm;
import com.ganesha.core.exception.AppException;
import com.ganesha.struts2.FormAction;

public class MenuContactMaintenanceAction extends
		FormAction<MenuContactMaintenanceForm, MenuContactMaintenanceBL> {

	private static final long serialVersionUID = 1L;

	public MenuContactMaintenanceAction() throws AppException {
		super(MenuContactMaintenanceForm.class, MenuContactMaintenanceBL.class);
	}
}
