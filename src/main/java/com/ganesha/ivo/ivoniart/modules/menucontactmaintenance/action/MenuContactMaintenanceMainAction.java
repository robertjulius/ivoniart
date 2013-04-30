package com.ganesha.ivo.ivoniart.modules.menucontactmaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menucontact.MenuContact;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.modules.menucontactmaintenance.MenuContactMaintenanceForm;

public class MenuContactMaintenanceMainAction extends
		MenuContactMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuContactMaintenanceMainAction() throws AppException {
		super();
	}

	public String initial() throws AppException {
		MenuContactMaintenanceForm form = getForm();

		List<Picture> pictures = getBL().getAllPictures();
		pictures.add(0, new Picture());

		form.setSelectListPicture(pictures);
		form.setPagination(new Pagination(10));

		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		MenuContactMaintenanceForm form = getForm();

		MenuContact menuContact = getBL().getDetail();
		form.setOld(menuContact);

		return SUCCESS;
	}
}
