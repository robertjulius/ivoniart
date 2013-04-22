package com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuabout.MenuAbout;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.MenuAboutMaintenanceForm;

public class MenuAboutMaintenanceMainAction extends MenuAboutMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuAboutMaintenanceMainAction() throws AppException {
		super();
	}

	public String initial() throws AppException {
		MenuAboutMaintenanceForm form = getForm();

		List<Picture> pictures = getBL().getAllPictures();
		form.setSelectListPicture(pictures);
		form.setPagination(new Pagination(10));

		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		MenuAboutMaintenanceForm form = getForm();

		MenuAbout menuAbout = getBL().getDetail();
		form.setOld(menuAbout);

		return SUCCESS;
	}
}
