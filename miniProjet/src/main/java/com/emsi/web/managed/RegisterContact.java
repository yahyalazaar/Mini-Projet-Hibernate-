package com.emsi.web.managed;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.emsi.dao.ContactDao;
import com.emsi.model.Contact;
import com.emsi.model.User;

@ManagedBean(name = "registerContact")
@RequestScoped
public class RegisterContact {

	private Contact Contact = new Contact();
	
	@ManagedProperty("#{registerUser}")
	private RegisterUser ru;

	public Contact getContact() {
		return Contact;
	}

	public void setContact(Contact Contact) {
		this.Contact = Contact;
	}

	public void register() throws IOException {
		ContactDao dao = new ContactDao();
		Contact.setUser(ru.getUser());
		dao.register(Contact);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The Contact " + this.Contact.getNomContact() + " Is Registered Successfully"));

	}
	public void refresh() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
	}

	public RegisterUser getRu() {
		return ru;
	}

	public void setRu(RegisterUser ru) {
		this.ru = ru;
	}
	

	
}
