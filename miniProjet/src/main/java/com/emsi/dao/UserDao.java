package com.emsi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.emsi.HibernateUtil.HibernateUtil;
import com.emsi.model.User;

public class UserDao {

	public boolean register(User User) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(User);
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

	public User findByName(User query) {
		User results = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			results = (User) session
					.createQuery(
							"from User where login = '" + query.getLogin() + "' and mdp ='" + query.getMdp() + "' ")
					.uniqueResult();

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

}
