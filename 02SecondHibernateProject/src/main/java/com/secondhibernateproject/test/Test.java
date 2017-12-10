package com.secondhibernateproject.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.secondhibernateproject.Address;
import com.secondhibernateproject.UserDetails;

public class Test {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		user1.setUserName("ramonrune");
		
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
		
		user1.getListofAddresses().add(addr1);
		user1.getListofAddresses().add(addr2);

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		session.beginTransaction();
		session.save(user1);
	
		session.getTransaction().commit();
		session.close();
		
		user1 = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user1 = (UserDetails) session.get(UserDetails.class, 1);
		
	}
}
