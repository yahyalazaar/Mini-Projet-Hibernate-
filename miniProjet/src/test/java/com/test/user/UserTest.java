package com.test.user;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.emsi.dao.UserDao;
import com.emsi.model.Contact;
import com.emsi.model.User;

public class UserTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<Contact> ls = new ArrayList<Contact>();
		User u = new User("Oussama", "OusLog", "123", ls);
		UserDao ud = new UserDao();
		assertTrue(ud.register(u));
	}

}
