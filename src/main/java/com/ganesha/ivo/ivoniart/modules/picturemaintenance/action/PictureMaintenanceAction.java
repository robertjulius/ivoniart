package com.ganesha.ivo.ivoniart.modules.picturemaintenance.action;

import com.ganesha.ivo.ivoniart.modules.picturemaintenance.PictureMaintenanceBL;
import com.ganesha.ivo.ivoniart.modules.picturemaintenance.PictureMaintenanceForm;
import com.ganesha.core.exception.AppException;
import com.ganesha.struts2.FormAction;

public class PictureMaintenanceAction extends
		FormAction<PictureMaintenanceForm, PictureMaintenanceBL> {

	private static final long serialVersionUID = 1L;

	public PictureMaintenanceAction() throws AppException {
		super(PictureMaintenanceForm.class, PictureMaintenanceBL.class);
	}
}
