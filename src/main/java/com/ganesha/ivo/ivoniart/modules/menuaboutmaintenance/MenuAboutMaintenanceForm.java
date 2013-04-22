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

	private String searchTitle;
	private String searchContent;

	private Pagination pagination;
	private List<MenuAbout> searchResult;

	private String selectedId;
	private MenuAbout old;

	private Picture newPicture;
	private String newTitle;
	private String newContent;

	public String getNewContent() {
		return newContent;
	}

	public Picture getNewPicture() {
		return newPicture;
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

	public String getSearchContent() {
		return searchContent;
	}

	public List<MenuAbout> getSearchResult() {
		return searchResult;
	}

	public String getSearchTitle() {
		return searchTitle;
	}

	public String getSelectedId() {
		return selectedId;
	}

	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}

	public void setNewPicture(Picture newPicture) {
		this.newPicture = newPicture;
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

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public void setSearchResult(List<MenuAbout> searchResult) {
		this.searchResult = searchResult;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}

	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}

	@Override
	public void validate(ActionSupport action) throws AppException {
		// TODO Auto-generated method stub
		super.validate(action);
	}
}
