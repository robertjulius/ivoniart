package com.ganesha.ivo.ivoniart.websitemenu;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ganesha.core.exception.AppException;
import com.ganesha.struts2.BaseAction;
import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ModelDriven;

public abstract class WebsiteMenuAction<T> extends BaseAction implements
		ModelDriven<T> {

	private static final long serialVersionUID = -7134221364561010535L;
	private T model;

	public WebsiteMenuAction(Class<T> clazz) throws AppException {
		try {
			this.model = clazz.newInstance();
		} catch (InstantiationException e) {
			throw new AppException(e);
		} catch (IllegalAccessException e) {
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

	public final Transaction getDBTransaction() throws AppException {
		try {
			return HibernateSessionFactory.getSession().getTransaction();
		} catch (HibernateException e) {
			throw new AppException(e);
		}
	}

	@Override
	public final T getModel() {
		return model;
	}

	public final void setModel(T model) {
		this.model = model;
	}
}
