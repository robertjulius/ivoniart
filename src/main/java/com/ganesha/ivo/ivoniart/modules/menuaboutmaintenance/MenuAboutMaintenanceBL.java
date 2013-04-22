package com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.basicweb.modules.BusinessLogic;
import com.ganesha.basicweb.utility.GeneralConstants;
import com.ganesha.basicweb.utility.GeneralConstants.ActionType;
import com.ganesha.core.exception.AppException;
import com.ganesha.core.exception.UserException;
import com.ganesha.ivo.ivoniart.model.menuabout.MenuAbout;
import com.ganesha.ivo.ivoniart.model.picture.Picture;

public class MenuAboutMaintenanceBL extends BusinessLogic {

	public void create(String newPictureId, String newTitle, String newContent,
			String createBy, Timestamp createDate) throws AppException {

		beginTransaction();

		/*
		 * TODO Auto-generated method stub Define your own object
		 */
		MenuAbout menuAbout = new MenuAbout();
		menuAbout.setTitle(newTitle);
		menuAbout.setContent(newContent);
		menuAbout.setCreateBy(createBy);
		menuAbout.setCreateDate(createDate);
		menuAbout.setUpdateBy(createBy);
		menuAbout.setUpdateDate(createDate);
		menuAbout.setRecStatus(GeneralConstants.REC_STATUS_ACTIVE);

		Picture picture = (Picture) getSession().load(Picture.class,
				newPictureId);
		menuAbout.setPicture(picture);

		getSession().save(menuAbout);
		saveActivityLog(ActionType.CREATE, menuAbout);

		commit();
	}

	public void delete(String id, String updateBy, Timestamp updateDate)
			throws UserException, AppException {

		beginTransaction();

		/*
		 * TODO Auto-generated method stub Define your own object
		 */
		MenuAbout menuAbout = (MenuAbout) getSession()
				.load(MenuAbout.class, id);
		menuAbout.setUpdateBy(updateBy);
		menuAbout.setUpdateDate(updateDate);
		menuAbout.setRecStatus(GeneralConstants.REC_STATUS_NONACTIVE);

		getSession().update(menuAbout);
		saveActivityLog(ActionType.DELETE,
				"Delete com.ganesha.ivo.ivoniart.model.menuabout.MenuAbout with id "
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

	public MenuAbout getDetail() throws AppException {
		Criteria criteria = getSession().createCriteria(MenuAbout.class);
		return (MenuAbout) criteria.uniqueResult();
	}

	public List<MenuAbout> search(String searchTitle, String searchContent,
			Pagination pagination) throws AppException {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(MenuAbout.class);

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
		List<MenuAbout> menuAbouts = criteria.list();

		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		int rowCount = (int) criteria.setProjection(Projections.rowCount())
				.uniqueResult();
		pagination.setRowCount(rowCount);

		return menuAbouts;
	}

	public void update(String newPictureId, String newTitle, String newContent,
			String updateBy, Timestamp updateDate) throws AppException {

		beginTransaction();

		/*
		 * TODO Auto-generated method stub Define your own object
		 */
		MenuAbout menuAbout = (MenuAbout) getSession().createCriteria(
				MenuAbout.class).uniqueResult();
		menuAbout.setTitle(newTitle);
		menuAbout.setContent(newContent);
		menuAbout.setUpdateBy(updateBy);
		menuAbout.setUpdateDate(updateDate);

		Picture picture = (Picture) getSession().load(Picture.class,
				newPictureId);
		menuAbout.setPicture(picture);

		getSession().save(menuAbout);
		saveActivityLog(ActionType.UPDATE, menuAbout);

		commit();
	}
}
