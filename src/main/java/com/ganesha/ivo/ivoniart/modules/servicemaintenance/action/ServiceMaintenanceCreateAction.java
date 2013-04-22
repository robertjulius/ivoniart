package com.ganesha.ivo.ivoniart.modules.servicemaintenance.action;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.modules.servicemaintenance.ServiceMaintenanceForm;

public class ServiceMaintenanceCreateAction extends ServiceMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public ServiceMaintenanceCreateAction() throws AppException {
		super();
	}

	public String executeCreate() throws AppException {
		// TODO Auto-generated method stub
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		ServiceMaintenanceForm form = getForm();
		String newPictureId = form.getNewPictureId();
		String newTitle = form.getNewTitle();
		String newContent = form.getNewContent();
		getBL().create(newPictureId, newTitle, newContent, user.getId(),
				CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}

	public String prepareCreate() throws AppException {
		// TODO Auto-generated method stub
		ServiceMaintenanceForm form = getForm();
		form.clearForm("new");

		form.setSelectedId(null);
		return SUCCESS;
	}

	public String validateCreate() throws AppException {
		// TODO Auto-generated method stub
		if (validateForm()) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
