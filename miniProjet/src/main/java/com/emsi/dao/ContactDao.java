package com.emsi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.emsi.HibernateUtil.HibernateUtil;
import com.emsi.model.Contact;
import com.emsi.model.User;

@ManagedBean(name = "contactDao")
@ApplicationScoped
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
	public List<Contact> getAll(User user) {
		List<Contact> results = new ArrayList<Contact>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			results = session.createQuery("from Contact where idUser='" + user.getIdUser() + "'").list();

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
