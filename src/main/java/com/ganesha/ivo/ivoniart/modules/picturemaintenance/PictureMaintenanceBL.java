package com.ganesha.ivo.ivoniart.modules.picturemaintenance;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ganesha.basicweb.model.Pagination;
import com.ganesha.basicweb.model.systemsetting.SystemSetting;
import com.ganesha.basicweb.modules.BusinessLogic;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.basicweb.utility.GeneralConstants;
import com.ganesha.basicweb.utility.GeneralConstants.ActionType;
import com.ganesha.basicweb.utility.PropertiesConstants;
import com.ganesha.core.exception.AppException;
import com.ganesha.core.exception.UserException;
import com.ganesha.ivo.ivoniart.model.picture.Picture;

public class PictureMaintenanceBL extends BusinessLogic {

	public void create(File fileUpload, String newTitle, String newComment,
			String createBy, Timestamp createDate) throws AppException {

		try {
			beginTransaction();

			/*
			 * TODO Auto-generated method stub Define your own object
			 */
			Picture picture = new Picture();
			picture.setId(String.valueOf(CommonUtils.getCurrentTimestamp()
					.getTime()));
			picture.setTitle(newTitle);
			picture.setComment(newComment);
			picture.setCreateBy(createBy);
			picture.setCreateDate(createDate);
			picture.setUpdateBy(createBy);
			picture.setUpdateDate(createDate);
			picture.setRecStatus(GeneralConstants.REC_STATUS_ACTIVE);

			getSession().save(picture);
			saveActivityLog(ActionType.CREATE, picture);

			File newFile = new File(
					new StringBuilder(
							SystemSetting
									.getProperty(PropertiesConstants.SYSTEM_DIRECTORY_FILE_IMAGES))
							.append(File.separator).append(picture.getId())
							.toString());

			if (!newFile.getParentFile().exists()) {
				FileUtils.forceMkdir(newFile.getParentFile());
			}
			FileUtils.copyFile(fileUpload, newFile);

			commit();
		} catch (IOException e) {
			rollback();
			throw new AppException(e);
		}
	}

	public void delete(String id, String updateBy, Timestamp updateDate)
			throws UserException, AppException {

		try {
			beginTransaction();

			/*
			 * TODO Auto-generated method stub Define your own object
			 */
			Picture picture = (Picture) getSession().load(Picture.class, id);
			picture.setUpdateBy(updateBy);
			picture.setUpdateDate(updateDate);
			picture.setRecStatus(GeneralConstants.REC_STATUS_NONACTIVE);

			getSession().update(picture);
			saveActivityLog(ActionType.DELETE,
					"Delete com.ganesha.ivo.ivoniart.model.picture.Picture with id "
							+ id); // TODO Define your own description

			File file = new File(
					new StringBuilder(
							SystemSetting
									.getProperty(PropertiesConstants.SYSTEM_DIRECTORY_FILE_IMAGES))
							.append(File.separator).append(picture.getId())
							.toString());
			FileUtils.forceDelete(file);

			commit();
		} catch (IOException e) {
			rollback();
			throw new AppException(e);
		}
	}

	public Picture getDetail(String id) throws AppException {
		if (id == null || id.trim().isEmpty()) {
			throw new AppException(
					PropertiesConstants.ERROR_PRIMARY_KEY_REQUIRED);
		}

		/*
		 * TODO Auto-generated method stub Define your own criteria
		 */
		Criteria criteria = getSession().createCriteria(Picture.class);
		criteria.add(Restrictions.eq("id", id));
		criteria.add(Restrictions.eq("recStatus",
				GeneralConstants.REC_STATUS_ACTIVE));

		return (Picture) criteria.uniqueResult();
	}

	public List<Picture> search(String searchTitle, String searchComment,
			Pagination pagination) throws AppException {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Picture.class);

		if (searchTitle != null && !searchTitle.trim().isEmpty()) {
			criteria.add(Restrictions.like("title", "%" + searchTitle + "%"));
		}

		if (searchComment != null && !searchComment.trim().isEmpty()) {
			criteria.add(Restrictions
					.like("comment", "%" + searchComment + "%"));
		}

		criteria.setFirstResult((pagination.getPageNumber() - 1)
				* pagination.getRowsPerPage());
		criteria.setMaxResults(pagination.getRowsPerPage());

		criteria.add(Restrictions.eq("recStatus",
				GeneralConstants.REC_STATUS_ACTIVE));

		@SuppressWarnings("unchecked")
		List<Picture> pictures = criteria.list();

		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		int rowCount = (Integer) criteria.setProjection(Projections.rowCount())
				.uniqueResult();
		pagination.setRowCount(rowCount);

		return pictures;
	}

	public void update(String id, String newTitle, String newComment,
			String updateBy, Timestamp updateDate) throws AppException {

		beginTransaction();

		/*
		 * TODO Auto-generated method stub Define your own object
		 */
		Picture picture = (Picture) getSession().load(Picture.class, id);
		picture.setTitle(newTitle);
		picture.setComment(newComment);
		picture.setUpdateBy(updateBy);
		picture.setUpdateDate(updateDate);

		getSession().save(picture);
		saveActivityLog(ActionType.UPDATE, picture);

		commit();
	}
}
