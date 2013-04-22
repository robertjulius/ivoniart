package com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.ivo.ivoniart.model.menuabout.MenuAbout;
import com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance.MenuAboutMaintenanceForm;
import com.ganesha.core.exception.AppException;

public class MenuAboutMaintenanceMainAction extends MenuAboutMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuAboutMaintenanceMainAction() throws AppException {
		super();
	}
	
	public String initial() throws AppException {
		// TODO Auto-generated method stub
		MenuAboutMaintenanceForm form = getForm();
		
		form.setPagination(new Pagination(10));
		
		return SUCCESS;
	}
	
	public String prepareDetail() throws AppException {
		// TODO Auto-generated method stub
		MenuAboutMaintenanceForm form = getForm();
		String selectedId = form.getSelectedId();

		MenuAbout menuAbout = getBL().getDetail(selectedId);
		form.setOld(menuAbout);

		return SUCCESS;
	}
	
	public String search() throws AppException {
		// TODO Auto-generated method stub
		MenuAboutMaintenanceForm form = getForm();
		
		String searchTitle = form.getSearchTitle();
		String searchContent = form.getSearchContent();

		Pagination pagination = getForm().getPagination();
		List<MenuAbout> menuAbouts = getBL().search(searchTitle, searchContent, pagination);
		form.setSearchResult(menuAbouts);
		
		return SUCCESS;
	}
}
