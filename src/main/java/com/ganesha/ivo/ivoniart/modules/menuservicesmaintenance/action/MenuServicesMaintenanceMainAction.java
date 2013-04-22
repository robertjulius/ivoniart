package com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuservices.MenuServices;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.service.Service;
import com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.MenuServicesMaintenanceForm;

public class MenuServicesMaintenanceMainAction extends
		MenuServicesMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuServicesMaintenanceMainAction() throws AppException {
		super();
	}

	public String initial() throws AppException {
		MenuServicesMaintenanceForm form = getForm();

		List<Picture> pictures = getBL().getAllPictures();
		pictures.add(0, new Picture());

		List<Service> services = getBL().getAllServices();
		services.add(0, new Service());

		form.setSelectListPicture(pictures);
		form.setSelectListService(services);
		form.setPagination(new Pagination(10));

		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		MenuServicesMaintenanceForm form = getForm();

		MenuServices menuServices = getBL().getDetail();
		form.setOld(menuServices);

		return SUCCESS;
	}
}
