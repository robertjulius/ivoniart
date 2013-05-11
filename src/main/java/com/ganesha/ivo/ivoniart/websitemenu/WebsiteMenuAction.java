package com.ganesha.ivo.ivoniart.websitemenu;

import org.hibernate.Session;

import com.ganesha.core.exception.AppException;
import com.ganesha.hibernate.HibernateUtil;
import com.ganesha.struts2.BaseAction;

public abstract class WebsiteMenuAction extends BaseAction {

	private static final long serialVersionUID = -7134221364561010535L;

	public final void beginTransaction() throws AppException {
		try {
			HibernateUtil.beginTransaction();
		} catch (Exception e) {
			throw new AppException(e);
		}
	}

	public final void commit() throws AppException {
		try {
			HibernateUtil.commitTransaction();
		} catch (Exception e) {
			throw new AppException(e);
		}
	}

	public final Session getDBSession() throws AppException {
		try {
			return HibernateUtil.getCurrentSession();
		} catch (Exception e) {
			throw new AppException(e);
		}
	}

	public String getMenuItemActive() {
		return (String) getSession().get("menuItemActive");
	}

	public final void rollback() throws AppException {
		try {
			HibernateUtil.rollbackTransaction();
		} catch (Exception e) {
			throw new AppException(e);
		}
	}

	public void setMenuItemActive(String menuItemActive) {
		getSession().put("menuItemActive", menuItemActive);
	}
}
