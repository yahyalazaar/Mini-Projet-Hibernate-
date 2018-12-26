package com.emsi.web.managed;


import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;

import com.emsi.dao.UserDao;
import com.emsi.model.User;

@ManagedBean
@SessionScoped
public class RegisterUser {

	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void register() throws IOException {
		UserDao dao = new UserDao();
		dao.register(user);
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The User " + this.user.getNomUser() + " Is SignIn Successfully"));
        Faces.redirect("signIn.xhtml");
	}
	public void signIn() throws IOException {
		UserDao dao = new UserDao();
		User u = dao.findByName(user);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The User " + this.user.getNomUser() + " Is SignIn Successfully"));
        Faces.redirect("signIn.xhtml");
		
	}
}
