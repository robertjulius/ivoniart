package com.ganesha.ivo.ivoniart.modules.menuhomemaintenance;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ganesha.basicweb.modules.BusinessLogic;
import com.ganesha.basicweb.utility.GeneralConstants;
import com.ganesha.basicweb.utility.GeneralConstants.ActionType;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.menuhome.MenuHome;
import com.ganesha.ivo.ivoniart.model.picture.Picture;

public class MenuHomeMaintenanceBL extends BusinessLogic {

	public List<Picture> getAllPictures() throws AppException {
		Criteria criteria = getSession().createCriteria(Picture.class);
		criteria.add(Restrictions.eq("recStatus",
				GeneralConstants.REC_STATUS_ACTIVE));

		@SuppressWarnings("unchecked")
		List<Picture> pictures = criteria.list();
		return pictures;
	}

	public MenuHome getDetail() throws AppException {
		Criteria criteria = getSession().createCriteria(MenuHome.class);
		return (MenuHome) criteria.uniqueResult();
	}

	public Picture getPicture(String id) throws AppException {
		Picture picture = (Picture) getSession().load(Picture.class, id);
		return picture;
	}

	public void update(List<Picture> newPictures, String newQuickLink1,
			String newQuickLink2, String updateBy, Timestamp updateDate)
			throws AppException {

		beginTransaction();

		MenuHome menuHome = (MenuHome) getSession().createCriteria(
				MenuHome.class).uniqueResult();
		menuHome.setQuickLink1(newQuickLink1);
		menuHome.setQuickLink2(newQuickLink2);
		menuHome.setUpdateBy(updateBy);
		menuHome.setUpdateDate(updateDate);

		menuHome.getPictures().clear();
		for (Picture picture : newPictures) {
			menuHome.getPictures().add(picture);
		}

		getSession().save(menuHome);
		saveActivityLog(ActionType.UPDATE, menuHome);

		commit();
	}
}
