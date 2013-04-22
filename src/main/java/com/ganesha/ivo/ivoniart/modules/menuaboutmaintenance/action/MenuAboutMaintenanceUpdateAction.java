package com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.action;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.MenuAboutMaintenanceForm;

public class MenuAboutMaintenanceUpdateAction extends
		MenuAboutMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuAboutMaintenanceUpdateAction() throws AppException {
		super();
	}

	public String executeUpdate() throws AppException {
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		MenuAboutMaintenanceForm form = getForm();
		String newPictureId = form.getNewPictureId();
		String newTitle = form.getNewTitle();
		String newContent = form.getNewContent();
		getBL().update(newPictureId, newTitle, newContent, user.getId(),
				CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}

	public String prepareUpdate() throws AppException {
		MenuAboutMaintenanceForm form = getForm();

		form.clearForm("new");
		form.assignFromEntity("new", form.getOld());

		form.setNewPictureId(form.getOld().getPicture().getId());
		form.setNewPictureTitle(form.getOld().getPicture().getTitle());

		return SUCCESS;
	}
}
