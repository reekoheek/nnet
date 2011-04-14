package com.xinixtech.nnet.dao;

import org.hibernate.Session;

import com.xinixtech.nnet.hibernate.HibernateUtil;

public class AbstractDao {
	@SuppressWarnings("unused")
	private Session session;

	protected AbstractDao() {
		getSession();
	}

	public Session getSession() {
		if (session == null) {
			session = HibernateUtil.getSession();
		}
		return session;
	}

	public double correctDouble(double value) throws Exception {
		java.text.DecimalFormat df = new java.text.DecimalFormat("###.########");
		return df.parse(df.format(value)).doubleValue();
	}

	public void setSession(Session session) {
		if (session == null) {
			this.session.close();
		}
		this.session = session;
	}
}
