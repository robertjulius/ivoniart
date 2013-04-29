package com.ganesha.ivo.ivoniart.modules.menuhomemaintenance;

import java.util.List;

import com.ganesha.basicweb.model.FormBean;
import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuhome.MenuHome;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.opensymphony.xwork2.ActionSupport;

public class MenuHomeMaintenanceForm extends FormBean {

	private static final long serialVersionUID = 1L;

	private Pagination pagination;
	private List<MenuHome> searchResult;

	private MenuHome old;

	private List<Picture> newPictures;
	private String newQuickLink1;
	private String newQuickLink2;

	private List<Picture> selectListPicture;

	public List<Picture> getNewPictures() {
		return newPictures;
	}

	public String getNewQuickLink1() {
		return newQuickLink1;
	}

	public String getNewQuickLink2() {
		return newQuickLink2;
	}

	public MenuHome getOld() {
		return old;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public List<MenuHome> getSearchResult() {
		return searchResult;
	}

	public List<Picture> getSelectListPicture() {
		return selectListPicture;
	}

	public void setNewPictures(List<Picture> newPictures) {
		this.newPictures = newPictures;
	}

	public void setNewQuickLink1(String newQuickLink1) {
		this.newQuickLink1 = newQuickLink1;
	}

	public void setNewQuickLink2(String newQuickLink2) {
		this.newQuickLink2 = newQuickLink2;
	}

	public void setOld(MenuHome old) {
		this.old = old;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setSearchResult(List<MenuHome> searchResult) {
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
