package com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.service.Service;
import com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance.MenuServicesMaintenanceForm;

public class MenuServicesMaintenanceUpdateAction extends
		MenuServicesMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuServicesMaintenanceUpdateAction() throws AppException {
		super();
	}

	public String executeUpdate() throws AppException {
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		MenuServicesMaintenanceForm form = getForm();
		List<Service> newServices = form.getNewServices();

		newServices.clear();
		List<String> listServices = getListServices();
		if (listServices != null) {
			for (int i = 0; i < listServices.size(); ++i) {
				String serviceId = listServices.get(i);
				if (serviceId == null || serviceId.trim().isEmpty()) {
					continue;
				}
				Service newService = getBL().getService(serviceId);
				newServices.add(newService);
			}
		}

		String newPictureId = form.getNewPictureId();
		String newTitle = form.getNewTitle();
		String newContent = form.getNewContent();
		getBL().update(newPictureId, newTitle, newContent, newServices,
				user.getId(), CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}

	public String prepareUpdate() throws AppException {
		MenuServicesMaintenanceForm form = getForm();

		form.clearForm("new");
		form.assignFromEntity("new", form.getOld());

		form.setNewPictureId(form.getOld().getPicture().getId());
		form.setNewPictureTitle(form.getOld().getPicture().getTitle());

		return SUCCESS;
	}
}
