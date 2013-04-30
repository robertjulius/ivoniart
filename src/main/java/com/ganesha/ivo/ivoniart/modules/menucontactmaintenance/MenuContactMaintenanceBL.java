package com.ganesha.ivo.ivoniart.modules.menucontactmaintenance;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ganesha.basicweb.modules.BusinessLogic;
import com.ganesha.basicweb.utility.GeneralConstants;
import com.ganesha.basicweb.utility.GeneralConstants.ActionType;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menucontact.MenuContact;
import com.ganesha.ivo.ivoniart.model.picture.Picture;

public class MenuContactMaintenanceBL extends BusinessLogic {

	public List<Picture> getAllPictures() throws AppException {
		Criteria criteria = getSession().createCriteria(Picture.class);
		criteria.add(Restrictions.eq("recStatus",
				GeneralConstants.REC_STATUS_ACTIVE));

		@SuppressWarnings("unchecked")
		List<Picture> pictures = criteria.list();
		return pictures;
	}

	public MenuContact getDetail() throws AppException {
		Criteria criteria = getSession().createCriteria(MenuContact.class);
		return (MenuContact) criteria.uniqueResult();
	}

	public void update(String newPictureId, String newTitle, String newContent,
			String newAddress, String newPhone, String newEmail,
			String updateBy, Timestamp updateDate) throws AppException {

		beginTransaction();

		MenuContact menuContact = (MenuContact) getSession().createCriteria(
				MenuContact.class).uniqueResult();
		menuContact.setTitle(newTitle);
		menuContact.setContent(newContent);
		menuContact.setAddress(newAddress);
		menuContact.setPhone(newPhone);
		menuContact.setEmail(newEmail);
		menuContact.setUpdateBy(updateBy);
		menuContact.setUpdateDate(updateDate);

		Picture picture = (Picture) getSession().load(Picture.class,
				newPictureId);
		menuContact.setPicture(picture);

		getSession().save(menuContact);
		saveActivityLog(ActionType.UPDATE, menuContact);

		commit();
	}
}
