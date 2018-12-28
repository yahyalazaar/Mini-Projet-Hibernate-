package com.emsi.web.managed;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.emsi.dao.UserDao;
import com.emsi.model.User;

@ManagedBean(name = "registerUser")
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

		FacesContext.getCurrentInstance().getExternalContext().redirect("signIn.xhtml");
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The User " + this.user.getNomUser() + " Is SignIn Successfully"));

	}

	public void signIn() throws IOException {
		UserDao dao = new UserDao();
		User u = dao.findByName(user);

		if (u != null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("The User " + this.user.getNomUser() + " Is SignIn Successfully"));
			user = u;
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("The User " + this.user.getNomUser() + " Is not SignIn Successfully"));
		}

	}

	public void signOut() throws IOException {
		user = new User();
		FacesContext.getCurrentInstance().getExternalContext().redirect("signUp.xhtml");
	}
}
