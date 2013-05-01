package com.ganesha.ivo.ivoniart.modules.menucontactmaintenance.action;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.modules.menucontactmaintenance.MenuContactMaintenanceForm;

public class MenuContactMaintenanceUpdateAction extends
		MenuContactMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuContactMaintenanceUpdateAction() throws AppException {
		super();
	}

	public String executeUpdate() throws AppException {
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		MenuContactMaintenanceForm form = getForm();

		String newPictureId = form.getNewPictureId();
		String newTitle = form.getNewTitle();
		String newContent = form.getNewContent();
		String newAddress = form.getNewAddress();
		String newPhone = form.getNewPhone();
		String newEmail = form.getNewEmail();
		getBL().update(newPictureId, newTitle, newContent, newAddress,
				newPhone, newEmail, user.getId(),
				CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}

	public String prepareUpdate() throws AppException {
		MenuContactMaintenanceForm form = getForm();

		form.clearForm("new");
		form.assignFromEntity("new", form.getOld());

		form.setNewPictureId(form.getOld().getPicture().getId());

		return SUCCESS;
	}
}
