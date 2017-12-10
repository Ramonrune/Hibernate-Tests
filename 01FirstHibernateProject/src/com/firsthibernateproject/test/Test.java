package com.firsthibernateproject.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.firsthibernateproject.Address;
import com.firsthibernateproject.UserDetails;

public class Test {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		//user.setUserId(1);
		user1.setUserName("ramonrune");

		user1.setJoinedDate(new Date());
		user1.setDescription("Descrição");
		
		
		UserDetails user2 = new UserDetails();
		//user.setUserId(1);
		user2.setUserName("user");
		user2.setJoinedDate(new Date());
		user2.setDescription("Descrição2");
		
		
		Address addr1 = new Address();
		addr1.setCity("SBO");
		addr1.setPincode("13450-144");
		addr1.setState("SP");
		addr1.setStreet("Rua");
		
		

		
		Address addr2 = new Address();
		addr2.setCity("AM");
		addr2.setPincode("13450-145");
		addr2.setState("SP1");
		addr2.setStreet("Rua1");
		
		
		user1.setHomeAddress(addr1);
		user1.setOfficeAddress(addr2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user1 = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user1 = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("Nome do usuário: " + user1.getUserName());
		
	}
}
