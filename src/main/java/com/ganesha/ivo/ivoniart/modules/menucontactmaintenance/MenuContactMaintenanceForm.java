package com.ganesha.ivo.ivoniart.modules.menucontactmaintenance;

import java.util.List;

import com.ganesha.basicweb.model.FormBean;
import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menucontact.MenuContact;
import com.opensymphony.xwork2.ActionSupport;

public class MenuContactMaintenanceForm extends FormBean {

	private static final long serialVersionUID = 1L;

	private Pagination pagination;
	private List<MenuContact> searchResult;

	private MenuContact old;

	private String newTitle;
	private String newContent;
	private String newAddress;
	private String newPhone;
	private String newEmail;

	public String getNewAddress() {
		return newAddress;
	}

	public String getNewContent() {
		return newContent;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public String getNewPhone() {
		return newPhone;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public MenuContact getOld() {
		return old;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public List<MenuContact> getSearchResult() {
		return searchResult;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}

	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public void setNewPhone(String newPhone) {
		this.newPhone = newPhone;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public void setOld(MenuContact old) {
		this.old = old;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setSearchResult(List<MenuContact> searchResult) {
		this.searchResult = searchResult;
	}

	@Override
	public void validate(ActionSupport action) throws AppException {
		// TODO Auto-generated method stub
		super.validate(action);
	}
}
