package com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ganesha.basicweb.modules.BusinessLogic;
import com.ganesha.basicweb.utility.GeneralConstants;
import com.ganesha.basicweb.utility.GeneralConstants.ActionType;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuservices.MenuServices;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.service.Service;

public class MenuServicesMaintenanceBL extends BusinessLogic {

	public List<Picture> getAllPictures() throws AppException {
		Criteria criteria = getSession().createCriteria(Picture.class);
		criteria.add(Restrictions.eq("recStatus",
				GeneralConstants.REC_STATUS_ACTIVE));

		@SuppressWarnings("unchecked")
		List<Picture> pictures = criteria.list();
		return pictures;
	}

	public List<Service> getAllServices() throws AppException {
		Criteria criteria = getSession().createCriteria(Service.class);
		criteria.add(Restrictions.eq("recStatus",
				GeneralConstants.REC_STATUS_ACTIVE));

		@SuppressWarnings("unchecked")
		List<Service> services = criteria.list();
		return services;
	}

	public MenuServices getDetail() throws AppException {
		Criteria criteria = getSession().createCriteria(MenuServices.class);
		return (MenuServices) criteria.uniqueResult();
	}

	public Service getService(String id) throws AppException {
		Service service = (Service) getSession().load(Service.class, id);
		return service;
	}

	public void update(String newPictureId, String newTitle, String newContent,
			List<Service> newServices, String updateBy, Timestamp updateDate)
			throws AppException {

		beginTransaction();

		MenuServices menuServices = (MenuServices) getSession().createCriteria(
				MenuServices.class).uniqueResult();
		menuServices.setTitle(newTitle);
		menuServices.setContent(newContent);
		menuServices.setUpdateBy(updateBy);
		menuServices.setUpdateDate(updateDate);

		menuServices.getServices().clear();
		for (Service service : newServices) {
			menuServices.getServices().add(service);
		}

		Picture picture = (Picture) getSession().load(Picture.class,
				newPictureId);
		menuServices.setPicture(picture);

		getSession().save(menuServices);
		saveActivityLog(ActionType.UPDATE, menuServices);

		commit();
	}
}
