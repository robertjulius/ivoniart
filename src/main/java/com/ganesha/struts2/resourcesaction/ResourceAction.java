package com.ganesha.struts2.resourcesaction;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.ganesha.basicweb.model.systemsetting.SystemSetting;
import com.ganesha.basicweb.utility.PropertiesConstants;
import com.ganesha.core.exception.AppException;
import com.ganesha.struts2.BaseAction;

public class ResourceAction extends BaseAction {

	private static final long serialVersionUID = -4092586222617366019L;
	private String path;

	@Override
	public String execute() throws AppException {
		HttpServletResponse response = getResponse();

		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;

		try {
			String fullImagePath = new StringBuilder(
					SystemSetting
							.getProperty(PropertiesConstants.SYSTEM_DIRECTORY))
					.append(File.separator).append(path).toString();

			File file = new File(fullImagePath);
			if (file.exists()) {
				bufferedInputStream = new BufferedInputStream(
						new FileInputStream(file));
				bufferedOutputStream = new BufferedOutputStream(
						response.getOutputStream());

				byte[] buffer = new byte[1024];
				for (int length; (length = bufferedInputStream.read(buffer)) > -1;) {
					bufferedOutputStream.write(buffer, 0, length);
				}
				bufferedOutputStream.flush();
			}
		} catch (IOException e) {
			throw new AppException(e);
		} finally {
			if (bufferedInputStream != null) {
				try {
					bufferedInputStream.close();
				} catch (IOException e) {
					// Do nothing
				}
			}
			if (bufferedOutputStream != null) {
				try {
					bufferedOutputStream.close();
				} catch (IOException e) {
					// Do nothing
				}
			}
		}

		return NONE;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}