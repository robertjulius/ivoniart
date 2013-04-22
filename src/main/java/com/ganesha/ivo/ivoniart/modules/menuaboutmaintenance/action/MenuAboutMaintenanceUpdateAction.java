package com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.action;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.MenuAboutMaintenanceForm;

public class MenuAboutMaintenanceUpdateAction extends
		MenuAboutMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuAboutMaintenanceUpdateAction() throws AppException {
		super();
	}

	public String executeUpdate() throws AppException {
		// TODO Auto-generated method stub
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		MenuAboutMaintenanceForm form = getForm();
		Picture newPicture = form.getNewPicture();
		String newTitle = form.getNewTitle();
		String newContent = form.getNewContent();
		getBL().update(form.getSelectedId(), newPicture, newTitle, newContent,
				user.getId(), CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}

	public String prepareUpdate() throws AppException {
		// TODO Auto-generated method stub
		MenuAboutMaintenanceForm form = getForm();
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
