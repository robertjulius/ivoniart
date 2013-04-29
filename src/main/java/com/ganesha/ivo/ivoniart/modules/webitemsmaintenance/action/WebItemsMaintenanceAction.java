package com.ganesha.ivo.ivoniart.modules.webitemsmaintenance.action;

import com.ganesha.ivo.ivoniart.modules.webitemsmaintenance.WebItemsMaintenanceBL;
import com.ganesha.ivo.ivoniart.modules.webitemsmaintenance.WebItemsMaintenanceForm;
import com.ganesha.core.exception.AppException;
import com.ganesha.struts2.FormAction;

public class WebItemsMaintenanceAction extends
		FormAction<WebItemsMaintenanceForm, WebItemsMaintenanceBL> {

	private static final long serialVersionUID = 1L;

	public WebItemsMaintenanceAction() throws AppException {
		super(WebItemsMaintenanceForm.class, WebItemsMaintenanceBL.class);
	}
}
