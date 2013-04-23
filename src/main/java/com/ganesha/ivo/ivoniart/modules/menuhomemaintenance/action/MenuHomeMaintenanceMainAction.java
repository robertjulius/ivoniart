package com.ganesha.ivo.ivoniart.modules.menuhomemaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuhome.MenuHome;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.modules.menuhomemaintenance.MenuHomeMaintenanceForm;

public class MenuHomeMaintenanceMainAction extends MenuHomeMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuHomeMaintenanceMainAction() throws AppException {
		super();
	}

	public String initial() throws AppException {
		MenuHomeMaintenanceForm form = getForm();

		List<Picture> pictures = getBL().getAllPictures();
		pictures.add(0, new Picture());

		form.setSelectListPicture(pictures);
		form.setPagination(new Pagination(10));

		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		MenuHomeMaintenanceForm form = getForm();

		MenuHome menuHome = getBL().getDetail();
		form.setOld(menuHome);

		return SUCCESS;
	}
}
