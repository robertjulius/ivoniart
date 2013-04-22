package com.ganesha.ivo.ivoniart.modules.menuaboutmaintenance;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ganesha.basicweb.modules.BusinessLogic;
import com.ganesha.basicweb.utility.GeneralConstants;
import com.ganesha.basicweb.utility.GeneralConstants.ActionType;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuabout.MenuAbout;
import com.ganesha.ivo.ivoniart.model.picture.Picture;

public class MenuAboutMaintenanceBL extends BusinessLogic {

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

	public void update(String newPictureId, String newTitle, String newContent,
			String updateBy, Timestamp updateDate) throws AppException {

		beginTransaction();

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
