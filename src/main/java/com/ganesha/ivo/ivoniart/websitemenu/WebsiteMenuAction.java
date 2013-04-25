package com.ganesha.ivo.ivoniart.websitemenu;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ganesha.core.exception.AppException;
import com.ganesha.struts2.BaseAction;
import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

public abstract class WebsiteMenuAction extends BaseAction {

	private static final long serialVersionUID = -7134221364561010535L;

	public final void beginTransaction() throws AppException {
		try {
			HibernateSessionFactory.getSession().getTransaction().begin();
		} catch (HibernateException e) {
			throw new AppException(e);
		}
	}

	public final void commit() throws AppException {
		try {
			HibernateSessionFactory.getSession().getTransaction().commit();
		} catch (HibernateException e) {
			throw new AppException(e);
		}
	}

	public final Session getDBSession() throws AppException {
		try {
			return HibernateSessionFactory.getSession();
		} catch (HibernateException e) {
			throw new AppException(e);
		}
	}

	public final void rollback() throws AppException {
		try {
			HibernateSessionFactory.getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			throw new AppException(e);
		}
	}
}
