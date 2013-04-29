package com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance;

import java.util.List;

import com.ganesha.basicweb.model.FormBean;
import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuservices.MenuServices;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.service.Service;
import com.opensymphony.xwork2.ActionSupport;

public class MenuServicesMaintenanceForm extends FormBean {

	private static final long serialVersionUID = 1L;

	private Pagination pagination;
	private List<MenuServices> searchResult;

	private MenuServices old;

	private String newPictureId;
	private String newPictureTitle;
	private String newTitle;
	private String newContent;
	private List<Service> newServices;

	private List<Picture> selectListPicture;
	private List<Service> selectListService;

	public String getNewContent() {
		return newContent;
	}

	public String getNewPictureId() {
		return newPictureId;
	}

	public String getNewPictureTitle() {
		return newPictureTitle;
	}

	public List<Service> getNewServices() {
		return newServices;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public MenuServices getOld() {
		return old;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public List<MenuServices> getSearchResult() {
		return searchResult;
	}

	public List<Picture> getSelectListPicture() {
		return selectListPicture;
	}

	public List<Service> getSelectListService() {
		return selectListService;
	}

	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}

	public void setNewPictureId(String newPictureId) {
		this.newPictureId = newPictureId;
	}

	public void setNewPictureTitle(String newPictureTitle) {
		this.newPictureTitle = newPictureTitle;
	}

	public void setNewServices(List<Service> newServices) {
		this.newServices = newServices;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public void setOld(MenuServices old) {
		this.old = old;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setSearchResult(List<MenuServices> searchResult) {
		this.searchResult = searchResult;
	}

	public void setSelectListPicture(List<Picture> selectListPicture) {
		this.selectListPicture = selectListPicture;
	}

	public void setSelectListService(List<Service> selectListService) {
		this.selectListService = selectListService;
	}

	@Override
	public void validate(ActionSupport action) throws AppException {
		// TODO Auto-generated method stub
		super.validate(action);
	}
}
