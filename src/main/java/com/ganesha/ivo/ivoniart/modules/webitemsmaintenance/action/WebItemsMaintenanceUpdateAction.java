package com.ganesha.ivo.ivoniart.modules.webitemsmaintenance.action;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.modules.webitemsmaintenance.WebItemsMaintenanceForm;

public class WebItemsMaintenanceUpdateAction extends WebItemsMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public WebItemsMaintenanceUpdateAction() throws AppException {
		super();
	}

	public String executeUpdate() throws AppException {
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		WebItemsMaintenanceForm form = getForm();

		String newLogoImage = form.getNewLogoImageId();
		String newCopyright = form.getNewCopyright();
		String newBackgroundImage = form.getNewBackgroundImageId();

		getBL().update(newLogoImage, newCopyright, newBackgroundImage,
				user.getId(), CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}

	public String prepareUpdate() throws AppException {
		WebItemsMaintenanceForm form = getForm();

		form.clearForm("new");
		form.assignFromEntity("new", form.getOld());

		form.setNewLogoImageId(form.getOld().getLogoImage().getId());
		form.setNewBackgroundImageId(form.getOld().getBackgroundImage().getId());

		return SUCCESS;
	}
}
