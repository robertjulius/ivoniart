package com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance;

import java.util.List;

import com.ganesha.basicweb.model.FormBean;
import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuabout.MenuAbout;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.opensymphony.xwork2.ActionSupport;

public class MenuAboutMaintenanceForm extends FormBean {

	private static final long serialVersionUID = 1L;

	private Pagination pagination;
	private List<MenuAbout> searchResult;

	private MenuAbout old;

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

	public MenuAbout getOld() {
		return old;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public List<MenuAbout> getSearchResult() {
		return searchResult;
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

	public void setOld(MenuAbout old) {
		this.old = old;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setSearchResult(List<MenuAbout> searchResult) {
		this.searchResult = searchResult;
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
