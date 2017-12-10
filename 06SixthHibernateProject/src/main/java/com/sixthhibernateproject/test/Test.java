package com.sixthhibernateproject.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sixthhibernateproject.UserDetails;
import com.sixthhibernateproject.Vehicle;

public class Test {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		user1.setUserName("ramonrune");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car1");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Car2");
		
		user1.getVehicle().add(vehicle1);
		user1.getVehicle().add(vehicle2);
		
		vehicle1.setUser(user1);
		vehicle2.setUser(user1);

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		session.beginTransaction();
		session.save(user1);
		session.save(vehicle1);
		session.save(vehicle2);

		session.getTransaction().commit();
		
		
		Vehicle v = (Vehicle) session.get(Vehicle.class, 2);
		
		System.out.println(v.getUser().getUserName());
		session.close();

	
	}
}
