package com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.ivo.ivoniart.model.menuservices.MenuServices;
import com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.MenuServicesMaintenanceForm;
import com.ganesha.core.exception.AppException;

public class MenuServicesMaintenanceMainAction extends MenuServicesMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuServicesMaintenanceMainAction() throws AppException {
		super();
	}
	
	public String initial() throws AppException {
		// TODO Auto-generated method stub
		MenuServicesMaintenanceForm form = getForm();
		
		form.setPagination(new Pagination(10));
		
		return SUCCESS;
	}
	
	public String prepareDetail() throws AppException {
		// TODO Auto-generated method stub
		MenuServicesMaintenanceForm form = getForm();
		String selectedId = form.getSelectedId();

		MenuServices menuServices = getBL().getDetail(selectedId);
		form.setOld(menuServices);

		return SUCCESS;
	}
	
	public String search() throws AppException {
		// TODO Auto-generated method stub
		MenuServicesMaintenanceForm form = getForm();
		
		String searchTitle = form.getSearchTitle();
		String searchContent = form.getSearchContent();

		Pagination pagination = getForm().getPagination();
		List<MenuServices> menuServicess = getBL().search(searchTitle, searchContent, pagination);
		form.setSearchResult(menuServicess);
		
		return SUCCESS;
	}
}
