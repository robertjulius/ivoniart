package com.ganesha.ivo.ivoniart.modules.webitemsmaintenance;

import java.util.List;

import com.ganesha.basicweb.model.FormBean;
import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.webitems.WebItems;
import com.opensymphony.xwork2.ActionSupport;

public class WebItemsMaintenanceForm extends FormBean {

	private static final long serialVersionUID = 1L;

	private Pagination pagination;
	private List<WebItems> searchResult;

	private WebItems old;

	private String newLogoImageId;
	private String newLogoImageTitle;
	private String newCopyright;
	private String newBackgroundImageId;
	private String newBackgroundImageTitle;

	private List<Picture> selectListLogoImage;
	private List<Picture> selectListBackgroundImage;

	public String getNewBackgroundImageId() {
		return newBackgroundImageId;
	}

	public String getNewBackgroundImageTitle() {
		return newBackgroundImageTitle;
	}

	public String getNewCopyright() {
		return newCopyright;
	}

	public String getNewLogoImageId() {
		return newLogoImageId;
	}

	public String getNewLogoImageTitle() {
		return newLogoImageTitle;
	}

	public WebItems getOld() {
		return old;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public List<WebItems> getSearchResult() {
		return searchResult;
	}

	public List<Picture> getSelectListBackgroundImage() {
		return selectListBackgroundImage;
	}

	public List<Picture> getSelectListLogoImage() {
		return selectListLogoImage;
	}

	public void setNewBackgroundImageId(String newBackgroundImageId) {
		this.newBackgroundImageId = newBackgroundImageId;
	}

	public void setNewBackgroundImageTitle(String newBackgroundImageTitle) {
		this.newBackgroundImageTitle = newBackgroundImageTitle;
	}

	public void setNewCopyright(String newCopyright) {
		this.newCopyright = newCopyright;
	}

	public void setNewLogoImageId(String newLogoImageId) {
		this.newLogoImageId = newLogoImageId;
	}

	public void setNewLogoImageTitle(String newLogoImageTitle) {
		this.newLogoImageTitle = newLogoImageTitle;
	}

	public void setOld(WebItems old) {
		this.old = old;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setSearchResult(List<WebItems> searchResult) {
		this.searchResult = searchResult;
	}

	public void setSelectListBackgroundImage(
			List<Picture> selectListBackgroundImage) {
		this.selectListBackgroundImage = selectListBackgroundImage;
	}

	public void setSelectListLogoImage(List<Picture> selectListLogoImage) {
		this.selectListLogoImage = selectListLogoImage;
	}

	@Override
	public void validate(ActionSupport action) throws AppException {
		// TODO Auto-generated method stub
		super.validate(action);
	}
}
