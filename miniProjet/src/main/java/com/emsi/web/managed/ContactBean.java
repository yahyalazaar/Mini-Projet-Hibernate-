package com.emsi.web.managed;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.emsi.dao.ContactDao;
import com.emsi.model.Contact;

@ManagedBean
@RequestScoped
public class ContactBean implements Serializable {

	
	private List<Contact> Contacts;
	@ManagedProperty("#{registerUser}")
	private RegisterUser ru;

	@ManagedProperty("#{contactDao}")
	private ContactDao service;

	@PostConstruct
	public void init() {
		Contacts = service.getAll(ru.getUser());
	}

	public List<Contact> getContacts() {
		return Contacts;
	}

	public void setService(ContactDao service) {
		this.service = service;
	}

	public RegisterUser getRu() {
		return ru;
	}

	public void setRu(RegisterUser ru) {
		this.ru = ru;
	}

	public ContactDao getService() {
		return service;
	}

	public void setContacts(List<Contact> contacts) {
		Contacts = contacts;
	}
	
	

}