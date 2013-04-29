package com.ganesha.ivo.ivoniart.modules.webitemsmaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.webitems.WebItems;
import com.ganesha.ivo.ivoniart.modules.webitemsmaintenance.WebItemsMaintenanceForm;

public class WebItemsMaintenanceMainAction extends WebItemsMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public WebItemsMaintenanceMainAction() throws AppException {
		super();
	}

	public String initial() throws AppException {
		WebItemsMaintenanceForm form = getForm();

		List<Picture> pictures = getBL().getAllPictures();
		pictures.add(0, new Picture());

		form.setSelectListLogoImage(pictures);
		form.setSelectListBackgroundImage(pictures);
		form.setPagination(new Pagination(10));

		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		WebItemsMaintenanceForm form = getForm();

		WebItems webItems = getBL().getDetail();
		form.setOld(webItems);

		return SUCCESS;
	}
}
