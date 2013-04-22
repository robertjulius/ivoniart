package com.ganesha.ivo.ivoniart.modules.menuservicesmaintenance;

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
import com.ganesha.ivo.ivoniart.model.menuservices.MenuServices;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.service.Service;

public class MenuServicesMaintenanceBL extends BusinessLogic {

	public void create(String newPictureId, String newTitle, String newContent,
			List<Service> newServices, String createBy, Timestamp createDate)
			throws AppException {

		beginTransaction();

		/*
		 * TODO Auto-generated method stub Define your own object
		 */
		MenuServices menuServices = new MenuServices();
		menuServices.setTitle(newTitle);
		menuServices.setContent(newContent);
		menuServices.setServices(newServices);
		menuServices.setCreateBy(createBy);
		menuServices.setCreateDate(createDate);
		menuServices.setUpdateBy(createBy);
		menuServices.setUpdateDate(createDate);
		menuServices.setRecStatus(GeneralConstants.REC_STATUS_ACTIVE);

		Picture picture = (Picture) getSession().load(Picture.class,
				newPictureId);
		menuServices.setPicture(picture);

		getSession().save(menuServices);
		saveActivityLog(ActionType.CREATE, menuServices);

		commit();
	}

	public void delete(String id, String updateBy, Timestamp updateDate)
			throws UserException, AppException {

		beginTransaction();

		/*
		 * TODO Auto-generated method stub Define your own object
		 */
		MenuServices menuServices = (MenuServices) getSession().load(
				MenuServices.class, id);
		menuServices.setUpdateBy(updateBy);
		menuServices.setUpdateDate(updateDate);
		menuServices.setRecStatus(GeneralConstants.REC_STATUS_NONACTIVE);

		getSession().update(menuServices);
		saveActivityLog(ActionType.DELETE,
				"Delete com.ganesha.ivo.ivoniart.model.menuservices.MenuServices with id "
						+ id); // TODO Define your own description

		commit();
	}

	public MenuServices getDetail(String id) throws AppException {
		if (id == null || id.trim().isEmpty()) {
			throw new AppException(
					PropertiesConstants.ERROR_PRIMARY_KEY_REQUIRED);
		}

		/*
		 * TODO Auto-generated method stub Define your own criteria
		 */
		Criteria criteria = getSession().createCriteria(MenuServices.class);
		criteria.add(Restrictions.eq("id", id));
		criteria.add(Restrictions.eq("recStatus",
				GeneralConstants.REC_STATUS_ACTIVE));

		return (MenuServices) criteria.uniqueResult();
	}

	public List<MenuServices> search(String searchTitle, String searchContent,
			Pagination pagination) throws AppException {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(MenuServices.class);

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
		List<MenuServices> menuServicess = criteria.list();

		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		int rowCount = (int) criteria.setProjection(Projections.rowCount())
				.uniqueResult();
		pagination.setRowCount(rowCount);

		return menuServicess;
	}

	public void update(String id, String newPictureId, String newTitle,
			String newContent, List<Service> newServices, String updateBy,
			Timestamp updateDate) throws AppException {

		beginTransaction();

		/*
		 * TODO Auto-generated method stub Define your own object
		 */
		MenuServices menuServices = (MenuServices) getSession().load(
				MenuServices.class, id);
		menuServices.setTitle(newTitle);
		menuServices.setContent(newContent);
		menuServices.setServices(newServices);
		menuServices.setUpdateBy(updateBy);
		menuServices.setUpdateDate(updateDate);

		Picture picture = (Picture) getSession().load(Picture.class,
				newPictureId);
		menuServices.setPicture(picture);

		getSession().save(menuServices);
		saveActivityLog(ActionType.UPDATE, menuServices);

		commit();
	}
}
