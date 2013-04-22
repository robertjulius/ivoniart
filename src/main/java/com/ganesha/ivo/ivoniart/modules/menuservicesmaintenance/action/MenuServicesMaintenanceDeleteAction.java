package com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.action;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.MenuServicesMaintenanceForm;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.core.exception.UserException;

public class MenuServicesMaintenanceDeleteAction extends MenuServicesMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuServicesMaintenanceDeleteAction() throws AppException {
		super();
	}
	
	public String executeDelete() throws AppException {
		// TODO Auto-generated method stub
		SimpleUser user = (SimpleUser) getUserSession().getUser();
		MenuServicesMaintenanceForm form = getForm();
		try {
			getBL().delete(form.getSelectedId(), user.getId(),
					CommonUtils.getCurrentTimestamp());
			return SUCCESS;
		} catch (UserException e) {
			addActionError(e.getMessageId());
			return ERROR;
		}
	}
}
