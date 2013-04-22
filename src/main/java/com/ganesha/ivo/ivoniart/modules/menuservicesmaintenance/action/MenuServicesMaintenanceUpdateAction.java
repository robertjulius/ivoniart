package com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.service.Service;
import com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.MenuServicesMaintenanceForm;

public class MenuServicesMaintenanceUpdateAction extends
		MenuServicesMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuServicesMaintenanceUpdateAction() throws AppException {
		super();
	}

	public String executeUpdate() throws AppException {
		// TODO Auto-generated method stub
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		MenuServicesMaintenanceForm form = getForm();
		String newPictureId = form.getNewPictureId();
		String newTitle = form.getNewTitle();
		String newContent = form.getNewContent();
		List<Service> newServices = form.getNewServices();
		getBL().update(form.getSelectedId(), newPictureId, newTitle,
				newContent, newServices, user.getId(),
				CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}

	public String prepareUpdate() throws AppException {
		// TODO Auto-generated method stub
		MenuServicesMaintenanceForm form = getForm();
		form.clearForm("new");
		form.assignFromEntity("new", form.getOld());

		return SUCCESS;
	}

	public String validateUpdate() throws AppException {
		// TODO Auto-generated method stub
		if (validateForm()) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
