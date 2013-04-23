package com.ganesha.ivo.ivoniart.modules.menucontactmaintenance;

import java.sql.Timestamp;

import org.hibernate.Criteria;

import com.ganesha.basicweb.modules.BusinessLogic;
import com.ganesha.basicweb.utility.GeneralConstants.ActionType;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menucontact.MenuContact;

public class MenuContactMaintenanceBL extends BusinessLogic {

	public MenuContact getDetail() throws AppException {
		Criteria criteria = getSession().createCriteria(MenuContact.class);
		return (MenuContact) criteria.uniqueResult();
	}

	public void update(String newTitle, String newContent, String newAddress,
			String newPhone, String newEmail, String updateBy,
			Timestamp updateDate) throws AppException {

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

		getSession().save(menuContact);
		saveActivityLog(ActionType.UPDATE, menuContact);

		commit();
	}
}
