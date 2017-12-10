package com.tenthhibernateproject.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.tenthhibernateproject.FourWheeler;
import com.tenthhibernateproject.TwoWheeler;
import com.tenthhibernateproject.Vehicle;

public class Test {

	public static void main(String[] args) {
		
	
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
	
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike steering handle");

		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche steering wheel");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		session.beginTransaction();
		session.save(vehicle1);
		session.save(bike);
		session.save(car);

		session.getTransaction().commit();
		
		session.close();

	
	}
}
