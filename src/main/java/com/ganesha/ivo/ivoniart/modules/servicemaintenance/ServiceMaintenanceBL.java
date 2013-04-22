package com.ganesha.ivo.ivoniart.modules.servicemaintenance;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.basicweb.modules.BusinessLogic;
import com.ganesha.basicweb.utility.GeneralConstants;
import com.ganesha.basicweb.utility.GeneralConstants.ActionType;
import com.ganesha.basicweb.utility.PropertiesConstants;
import com.ganesha.core.exception.AppException;
import com.ganesha.core.exception.UserException;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.service.Service;

public class ServiceMaintenanceBL extends BusinessLogic {

	public void create(String newPictureId, String newTitle, String newContent,
			String createBy, Timestamp createDate) throws AppException {

		beginTransaction();

		/*
		 * TODO Auto-generated method stub Define your own object
		 */
		Service service = new Service();
		service.setTitle(newTitle);
		service.setContent(newContent);
		service.setCreateBy(createBy);
		service.setCreateDate(createDate);
		service.setUpdateBy(createBy);
		service.setUpdateDate(createDate);
		service.setRecStatus(GeneralConstants.REC_STATUS_ACTIVE);

		Picture picture = (Picture) getSession().load(Picture.class,
				newPictureId);
		service.setPicture(picture);

		getSession().save(service);
		saveActivityLog(ActionType.CREATE, service);

		commit();
	}

	public void delete(String id, String updateBy, Timestamp updateDate)
			throws UserException, AppException {

		beginTransaction();

		/*
		 * TODO Auto-generated method stub Define your own object
		 */
		Service service = (Service) getSession().load(Service.class, id);
		service.setUpdateBy(updateBy);
		service.setUpdateDate(updateDate);
		service.setRecStatus(GeneralConstants.REC_STATUS_NONACTIVE);

		getSession().update(service);
		saveActivityLog(ActionType.DELETE,
				"Delete com.ganesha.ivo.ivoniart.model.service.Service with id "
						+ id); // TODO Define your own description

		commit();
	}

	public List<Picture> getAllPictures() throws AppException {
		Criteria criteria = getSession().createCriteria(Picture.class);
		criteria.add(Restrictions.eq("recStatus",
				GeneralConstants.REC_STATUS_ACTIVE));

		@SuppressWarnings("unchecked")
		List<Picture> pictures = criteria.list();
		return pictures;
	}

	public Service getDetail(String id) throws AppException {
		if (id == null || id.trim().isEmpty()) {
			throw new AppException(
					PropertiesConstants.ERROR_PRIMARY_KEY_REQUIRED);
		}

		/*
		 * TODO Auto-generated method stub Define your own criteria
		 */
		Criteria criteria = getSession().createCriteria(Service.class);
		criteria.add(Restrictions.eq("id", id));
		criteria.add(Restrictions.eq("recStatus",
				GeneralConstants.REC_STATUS_ACTIVE));

		return (Service) criteria.uniqueResult();
	}

	public List<Service> search(String searchTitle, String searchContent,
			Pagination pagination) throws AppException {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Service.class);

		if (searchTitle != null && !searchTitle.trim().isEmpty()) {
			criteria.add(Restrictions.like("title", "%" + searchTitle + "%"));
		}

		if (searchContent != null && !searchContent.trim().isEmpty()) {
			criteria.add(Restrictions
					.like("content", "%" + searchContent + "%"));
		}

		criteria.setFirstResult((pagination.getPageNumber() - 1)
				* pagination.getRowsPerPage());
		criteria.setMaxResults(pagination.getRowsPerPage());

		criteria.add(Restrictions.eq("recStatus",
				GeneralConstants.REC_STATUS_ACTIVE));

		@SuppressWarnings("unchecked")
		List<Service> services = criteria.list();

		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		int rowCount = (int) criteria.setProjection(Projections.rowCount())
				.uniqueResult();
		pagination.setRowCount(rowCount);

		return services;
	}

	public void update(String id, String newPictureId, String newTitle,
			String newContent, String updateBy, Timestamp updateDate)
			throws AppException {

		beginTransaction();

		/*
		 * TODO Auto-generated method stub Define your own object
		 */
		Service service = (Service) getSession().load(Service.class, id);
		service.setTitle(newTitle);
		service.setContent(newContent);
		service.setUpdateBy(updateBy);
		service.setUpdateDate(updateDate);

		Picture picture = (Picture) getSession().load(Picture.class,
				newPictureId);
		service.setPicture(picture);

		getSession().save(service);
		saveActivityLog(ActionType.UPDATE, service);

		commit();
	}
}
