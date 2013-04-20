package com.ganesha.ivo.ivoniart.modules.picturemaintenance.action;

import java.io.File;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.modules.picturemaintenance.PictureMaintenanceForm;

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
		File fileUpload = form.getFileUpload();

		getBL().create(fileUpload, newDescription, newComment, user.getId(),
				CommonUtils.getCurrentTimestamp());

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
		PictureMaintenanceForm form = getForm();
		File uploadedFile = form.getFileUpload();
		CommonUtils.createTempFile(uploadedFile, form.getFileUploadFileName());

		if (validateForm()) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
