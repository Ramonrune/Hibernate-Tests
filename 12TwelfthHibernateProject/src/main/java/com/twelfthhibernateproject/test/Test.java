package com.twelfthhibernateproject.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.twelfthhibernateproject.UserDetails;

public class Test {

	public static void main(String[] args) {
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		session.beginTransaction();
		
		for(int i = 0; i < 10; i++){
			UserDetails user = new UserDetails();
			user.setUserName("User " + i);
			session.save(user);
		}
		
		UserDetails user1 = (UserDetails) session.get(UserDetails.class, 6);
		UserDetails user2 = (UserDetails) session.get(UserDetails.class, 7);
		
		
		session.delete(user2);
		
		user1.setUserName("ramonrune");
		session.update(user1);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println(user1.getUserName());


	
	}
}
