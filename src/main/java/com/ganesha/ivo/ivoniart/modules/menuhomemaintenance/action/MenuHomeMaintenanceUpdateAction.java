package com.ganesha.ivo.ivoniart.modules.menuhomemaintenance.action;

import java.util.List;

import com.ganesha.basicweb.model.user.SimpleUser;
import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.modules.menuhomemaintenance.MenuHomeMaintenanceForm;

public class MenuHomeMaintenanceUpdateAction extends MenuHomeMaintenanceAction {

	private static final long serialVersionUID = 1L;

	public MenuHomeMaintenanceUpdateAction() throws AppException {
		super();
	}

	public String executeUpdate() throws AppException {
		SimpleUser user = (SimpleUser) getUserSession().getUser();

		MenuHomeMaintenanceForm form = getForm();
		List<Picture> newPictures = form.getNewPictures();

		newPictures.clear();
		List<String> listPictures = getListPictures();
		if (listPictures != null) {
			for (int i = 0; i < listPictures.size(); ++i) {
				String pictureId = listPictures.get(i);
				if (pictureId == null || pictureId.trim().isEmpty()) {
					continue;
				}
				Picture newPicture = getBL().getPicture(pictureId);
				newPictures.add(newPicture);
			}
		}

		String newQuickLink1 = form.getNewQuickLink1();
		String newQuickLink2 = form.getNewQuickLink2();
		getBL().update(newPictures, newQuickLink1, newQuickLink2, user.getId(),
				CommonUtils.getCurrentTimestamp());

		return SUCCESS;
	}

	public String prepareUpdate() throws AppException {
		MenuHomeMaintenanceForm form = getForm();

		form.clearForm("new");
		form.assignFromEntity("new", form.getOld());

		return SUCCESS;
	}
}
