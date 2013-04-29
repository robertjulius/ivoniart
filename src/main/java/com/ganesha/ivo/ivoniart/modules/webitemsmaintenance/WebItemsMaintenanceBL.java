package com.ganesha.ivo.ivoniart.modules.webitemsmaintenance;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ganesha.basicweb.model.systemsetting.SystemSetting;
import com.ganesha.basicweb.modules.BusinessLogic;
import com.ganesha.basicweb.utility.GeneralConstants;
import com.ganesha.basicweb.utility.GeneralConstants.ActionType;
import com.ganesha.basicweb.utility.PropertiesConstants;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.picture.Picture;
import com.ganesha.ivo.ivoniart.model.webitems.WebItems;

public class WebItemsMaintenanceBL extends BusinessLogic {

	public List<Picture> getAllPictures() throws AppException {
		Criteria criteria = getSession().createCriteria(Picture.class);
		criteria.add(Restrictions.eq("recStatus",
				GeneralConstants.REC_STATUS_ACTIVE));

		@SuppressWarnings("unchecked")
		List<Picture> pictures = criteria.list();
		return pictures;
	}

	public WebItems getDetail() throws AppException {
		Criteria criteria = getSession().createCriteria(WebItems.class);
		return (WebItems) criteria.uniqueResult();
	}

	public void update(String newLogoImageId, String newCopyright,
			String newBackgroundImageId, String updateBy, Timestamp updateDate)
			throws AppException {
		try {
			beginTransaction();

			WebItems webItems = updateDatabase(newLogoImageId, newCopyright,
					newBackgroundImageId, updateBy, updateDate);

			updateSystemSetting(webItems);
			copyPictures(webItems);

			saveActivityLog(ActionType.UPDATE, webItems);
			commit();
		} catch (IOException e) {
			rollback();
			throw new AppException(e);
		}
	}

	private void copyPictures(WebItems webItems) throws IOException {
		File logoSource = new File(
				new StringBuilder(
						SystemSetting
								.getProperty(PropertiesConstants.SYSTEM_DIRECTORY_FILE_IMAGES))
						.append(File.separator)
						.append(webItems.getLogoImage().getId()).toString());
		File logoDestination = new File(
				new StringBuilder(
						SystemSetting
								.getProperty(PropertiesConstants.SYSTEM_DIRECTORY_FILE_IMAGES))
						.append(File.separator).append("logo").toString());
		FileUtils.copyFile(logoSource, logoDestination);

		File backgroundSource = new File(
				new StringBuilder(
						SystemSetting
								.getProperty(PropertiesConstants.SYSTEM_DIRECTORY_FILE_IMAGES))
						.append(File.separator)
						.append(webItems.getBackgroundImage().getId())
						.toString());
		File backgroundDestination = new File(
				new StringBuilder(
						SystemSetting
								.getProperty(PropertiesConstants.SYSTEM_DIRECTORY_FILE_IMAGES))
						.append(File.separator).append("background").toString());
		FileUtils.copyFile(backgroundSource, backgroundDestination);

	}

	private WebItems updateDatabase(String newLogoImageId, String newCopyright,
			String newBackgroundImageId, String updateBy, Timestamp updateDate)
			throws AppException {

		WebItems webItems = (WebItems) getSession().createCriteria(
				WebItems.class).uniqueResult();
		webItems.setCopyright(newCopyright);
		webItems.setUpdateBy(updateBy);
		webItems.setUpdateDate(updateDate);

		Picture newLogoImage = (Picture) getSession().load(Picture.class,
				newLogoImageId);
		webItems.setLogoImage(newLogoImage);

		Picture newBackgroundImage = (Picture) getSession().load(Picture.class,
				newBackgroundImageId);
		webItems.setBackgroundImage(newBackgroundImage);

		getSession().save(webItems);
		return webItems;
	}

	private void updateSystemSetting(WebItems webItems) throws AppException {

		SystemSetting systemSetting = null;

		/*
		 * Update logo image
		 */
		systemSetting = (SystemSetting) getSession().load(SystemSetting.class,
				PropertiesConstants.WEB_ITEMS_IMAGE_LOGO);
		systemSetting.setValue(webItems.getLogoImage().getId());
		getSession().save(systemSetting);

		SystemSetting.setProperty(systemSetting.getId(),
				systemSetting.getValue());

		/*
		 * Update background image
		 */
		systemSetting = (SystemSetting) getSession().load(SystemSetting.class,
				PropertiesConstants.WEB_ITEMS_IMAGE_BACKGROUND);
		systemSetting.setValue(webItems.getBackgroundImage().getId());
		getSession().save(systemSetting);

		SystemSetting.setProperty(systemSetting.getId(),
				systemSetting.getValue());

		/*
		 * Update copyright
		 */
		systemSetting = (SystemSetting) getSession().load(SystemSetting.class,
				PropertiesConstants.WEB_ITEMS_COPYRIGHT);
		systemSetting.setValue(webItems.getCopyright());
		getSession().update(systemSetting);

		SystemSetting.setProperty(systemSetting.getId(),
				systemSetting.getValue());
	}
}
