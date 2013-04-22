package com.ganesha.ivo.ivoniart.modules.servicemaintenance.action;

import java.util.List;

import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.modules.servicemaintenance.ServiceMaintenanceBL;
import com.ganesha.ivo.ivoniart.modules.servicemaintenance.ServiceMaintenanceForm;
import com.ganesha.struts2.FormAction;

public class ServiceMaintenanceAction extends
		FormAction<ServiceMaintenanceForm, ServiceMaintenanceBL> {

	private static final long serialVersionUID = 1L;

	private List<String> listPictureTitles;

	public ServiceMaintenanceAction() throws AppException {
		super(ServiceMaintenanceForm.class, ServiceMaintenanceBL.class);
	}

	public List<String> getListPictureTitles() {
		return listPictureTitles;
	}

	public void setListPictureTitles(List<String> listPictureTitles) {
		this.listPictureTitles = listPictureTitles;
	}
}
