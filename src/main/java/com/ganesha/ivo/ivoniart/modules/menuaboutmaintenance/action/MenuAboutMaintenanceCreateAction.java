package com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.action;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.MenuAboutMaintenanceForm;

public class MenuAboutMaintenanceCreateAction extends
		MenuAboutMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuAboutMaintenanceCreateAction() throws AppException {
		super();
	}

	public String executeCreate() throws AppException {
		// TODO Auto-generated method stub
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		MenuAboutMaintenanceForm form = getForm();
		Picture newPicture = form.getNewPicture();
		String newTitle = form.getNewTitle();
		String newContent = form.getNewContent();
		getBL().create(newPicture, newTitle, newContent, user.getId(),
				CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}

	public String prepareCreate() throws AppException {
		// TODO Auto-generated method stub
		MenuAboutMaintenanceForm form = getForm();
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
