package com.ganesha.ivo.ivoniart.modules.servicemaintenance;

import java.util.List;

import com.ganesha.basicweb.model.FormBean;
import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.service.Service;
import com.opensymphony.xwork2.ActionSupport;

public class ServiceMaintenanceForm extends FormBean {

	private static final long serialVersionUID = 1L;

	private String searchTitle;
	private String searchContent;

	private Pagination pagination;
	private List<Service> searchResult;

	private String selectedId;
	private Service old;

	private String newPictureId;
	private String newPictureTitle;
	private String newTitle;
	private String newContent;

	private List<Picture> selectListPicture;

	public String getNewContent() {
		return newContent;
	}

	public String getNewPictureId() {
		return newPictureId;
	}

	public String getNewPictureTitle() {
		return newPictureTitle;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public Service getOld() {
		return old;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public List<Service> getSearchResult() {
		return searchResult;
	}

	public String getSearchTitle() {
		return searchTitle;
	}

	public String getSelectedId() {
		return selectedId;
	}

	public List<Picture> getSelectListPicture() {
		return selectListPicture;
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

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public void setOld(Service old) {
		this.old = old;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public void setSearchResult(List<Service> searchResult) {
		this.searchResult = searchResult;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}

	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}

	public void setSelectListPicture(List<Picture> selectListPicture) {
		this.selectListPicture = selectListPicture;
	}

	@Override
	public void validate(ActionSupport action) throws AppException {
		// TODO Auto-generated method stub
		super.validate(action);
	}
}
