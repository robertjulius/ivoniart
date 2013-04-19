package com.ganesha.ivo.ivoniart.modules.picturemaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.modules.picturemaintenance.PictureMaintenanceForm;
import com.ganesha.core.exception.AppException;

public class PictureMaintenanceMainAction extends PictureMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public PictureMaintenanceMainAction() throws AppException {
		super();
	}
	
	public String initial() throws AppException {
		// TODO Auto-generated method stub
		PictureMaintenanceForm form = getForm();
		
		form.setPagination(new Pagination(10));
		
		return SUCCESS;
	}
	
	public String prepareDetail() throws AppException {
		// TODO Auto-generated method stub
		PictureMaintenanceForm form = getForm();
		String selectedId = form.getSelectedId();

		Picture picture = getBL().getDetail(selectedId);
		form.setOld(picture);

		return SUCCESS;
	}
	
	public String search() throws AppException {
		// TODO Auto-generated method stub
		PictureMaintenanceForm form = getForm();
		
		String searchDescription = form.getSearchDescription();
		String searchComment = form.getSearchComment();

		Pagination pagination = getForm().getPagination();
		List<Picture> pictures = getBL().search(searchDescription, searchComment, pagination);
		form.setSearchResult(pictures);
		
		return SUCCESS;
	}
}
