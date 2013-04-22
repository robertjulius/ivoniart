package com.ganesha.ivo.ivoniart.modules.servicemaintenance.action;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.modules.servicemaintenance.ServiceMaintenanceForm;

public class ServiceMaintenanceUpdateAction extends ServiceMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public ServiceMaintenanceUpdateAction() throws AppException {
		super();
	}

	public String executeUpdate() throws AppException {
		// TODO Auto-generated method stub
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		ServiceMaintenanceForm form = getForm();
		String newPictureId = form.getNewPictureId();
		String newTitle = form.getNewTitle();
		String newContent = form.getNewContent();
		getBL().update(form.getSelectedId(), newPictureId, newTitle,
				newContent, user.getId(), CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}

	public String prepareUpdate() throws AppException {
		// TODO Auto-generated method stub
		ServiceMaintenanceForm form = getForm();

		form.clearForm("new");
		form.assignFromEntity("new", form.getOld());

		form.setNewPictureId(form.getOld().getPicture().getId());
		form.setNewPictureTitle(form.getOld().getPicture().getTitle());

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
