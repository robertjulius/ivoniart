package com.ganesha.basicweb.utility;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;

import com.ganesha.basicweb.model.systemsetting.SystemSetting;
import com.ganesha.core.exception.AppException;

public class CommonUtils {

	public static void createTempFile(File originalFile, String newFileName)
			throws AppException {
		try {
			File tempFile = new File(
					new StringBuilder(
							SystemSetting
									.getProperty(PropertiesConstants.SYSTEM_DIRECTORY_TEMP))
							.append(File.separator).append(newFileName)
							.toString());
			if (!tempFile.getParentFile().exists()) {
				FileUtils.forceMkdir(tempFile.getParentFile());
			}
			FileUtils.copyFile(originalFile, tempFile);
		} catch (IOException e) {
			throw new AppException(e);
		}
	}

	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
}
