package com.ganesha.ivo.ivoniart.modules.servicemaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.service.Service;
import com.ganesha.ivo.ivoniart.modules.servicemaintenance.ServiceMaintenanceForm;

public class ServiceMaintenanceMainAction extends ServiceMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public ServiceMaintenanceMainAction() throws AppException {
		super();
	}

	public String initial() throws AppException {
		// TODO Auto-generated method stub
		ServiceMaintenanceForm form = getForm();

		List<Picture> pictures = getBL().getAllPictures();
		pictures.add(0, new Picture());

		form.setSelectListPicture(pictures);
		form.setPagination(new Pagination(10));

		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		// TODO Auto-generated method stub
		ServiceMaintenanceForm form = getForm();
		String selectedId = form.getSelectedId();

		Service service = getBL().getDetail(selectedId);
		form.setOld(service);

		return SUCCESS;
	}

	public String search() throws AppException {
		// TODO Auto-generated method stub
		ServiceMaintenanceForm form = getForm();

		String searchTitle = form.getSearchTitle();
		String searchContent = form.getSearchContent();

		Pagination pagination = getForm().getPagination();
		List<Service> services = getBL().search(searchTitle, searchContent,
				pagination);
		form.setSearchResult(services);

		return SUCCESS;
	}
}
