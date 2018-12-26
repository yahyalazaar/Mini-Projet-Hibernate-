package com.emsi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.emsi.HibernateUtil.HibernateUtil;
import com.emsi.model.Contact;

public class ContactDao {

	public boolean register(Contact Contact) {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(Contact);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

}
