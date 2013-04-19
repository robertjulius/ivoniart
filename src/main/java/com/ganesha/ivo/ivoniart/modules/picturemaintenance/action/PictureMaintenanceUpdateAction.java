package com.ganesha.ivo.ivoniart.modules.picturemaintenance.action;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.ivo.ivoniart.modules.picturemaintenance.PictureMaintenanceForm;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;

public class PictureMaintenanceUpdateAction extends PictureMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public PictureMaintenanceUpdateAction() throws AppException {
		super();
	}
	
	public String executeUpdate() throws AppException {
		// TODO Auto-generated method stub
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		PictureMaintenanceForm form = getForm();
		String newDescription = form.getNewDescription();
		String newComment = form.getNewComment();
		getBL().update(form.getSelectedId(), newDescription, newComment, user.getId(), CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}
	
	public String prepareUpdate() throws AppException {
		// TODO Auto-generated method stub
		PictureMaintenanceForm form = getForm();
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
