package com.sixthhibernateproject;


import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/*	@JoinTable(name = "user_vehicle", joinColumns= @JoinColumn(name = "user_id"),
inverseJoinColumns = @JoinColumn(name = "vehicle_id")
JOIN TABLE CRIA TABELA NOVA
)*/
@Entity
@Table(name="Usuario")
public class UserDetails {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@OneToMany(mappedBy = "user")
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name = "usuario")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
	
	
}
