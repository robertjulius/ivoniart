package com.ganesha.ivo.ivoniart.modules.picturemaintenance.action;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.ivo.ivoniart.modules.picturemaintenance.PictureMaintenanceForm;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;

public class PictureMaintenanceCreateAction extends PictureMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public PictureMaintenanceCreateAction() throws AppException {
		super();
	}
	
	public String executeCreate() throws AppException {
		// TODO Auto-generated method stub
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		PictureMaintenanceForm form = getForm();
		String newDescription = form.getNewDescription();
		String newComment = form.getNewComment();
		getBL().create(newDescription, newComment, user.getId(), CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}
	
	public String prepareCreate() throws AppException {
		// TODO Auto-generated method stub
		PictureMaintenanceForm form = getForm();
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