package com.ganesha.ivo.ivoniart.modules.picturemaintenance;

import java.io.File;
import java.util.List;

import com.ganesha.basicweb.model.FormBean;
import com.ganesha.basicweb.model.Pagination;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.opensymphony.xwork2.ActionSupport;

public class PictureMaintenanceForm extends FormBean {

	private static final long serialVersionUID = 1L;

	private String searchTitle;
	private String searchComment;

	private Pagination pagination;
	private List<Picture> searchResult;

	private String selectedId;
	private Picture old;

	private String newTitle;
	private String newComment;

	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;

	public File getFileUpload() {
		return fileUpload;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public String getNewComment() {
		return newComment;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public Picture getOld() {
		return old;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public String getSearchComment() {
		return searchComment;
	}

	public List<Picture> getSearchResult() {
		return searchResult;
	}

	public String getSearchTitle() {
		return searchTitle;
	}

	public String getSelectedId() {
		return selectedId;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public void setNewComment(String newComment) {
		this.newComment = newComment;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public void setOld(Picture old) {
		this.old = old;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setSearchComment(String searchComment) {
		this.searchComment = searchComment;
	}

	public void setSearchResult(List<Picture> searchResult) {
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
