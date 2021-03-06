package com.seventhhibernateproject.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.seventhhibernateproject.UserDetails;
import com.seventhhibernateproject.Vehicle;

public class Test {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		user1.setUserName("ramonrune");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("user");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car1");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Car2");
		
		user1.getVehicle().add(vehicle1);
		user1.getVehicle().add(vehicle2);
		
		vehicle1.getUserList().add(user1);
		vehicle2.getUserList().add(user1);
		vehicle1.getUserList().add(user2);

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.save(vehicle1);
		session.save(vehicle2);

		session.getTransaction().commit();
		
		
		
		session.close();

	
	}
}
