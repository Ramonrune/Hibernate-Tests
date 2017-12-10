package com.fifthhibernateproject.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.fifthhibernateproject.UserDetails;
import com.fifthhibernateproject.Vehicle;

public class Test {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		user1.setUserName("ramonrune");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		user1.setVehicle(vehicle);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		session.beginTransaction();
		session.save(user1);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();

	
	}
}
