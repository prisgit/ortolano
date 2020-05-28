package com.sinervis.webapp.ortolano;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Vegetable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idVeg;
	
	private String name;
	
	private String description;
	
	@ManyToMany
	@JoinTable(
			name="SOWING",
			joinColumns=@JoinColumn(name="VEGETABLES", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="MESE", referencedColumnName="ID_MESE"))
	private List<Mese> sowing;
	
	@ManyToMany
	@JoinTable(
			name="HARVEST",
			joinColumns=@JoinColumn(name="VEGETABLES", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="MESE", referencedColumnName="ID_MESE"))
	private List<Mese> harvest;
	
	private int sun;
	
	private int water;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSun() {
		return sun;
	}
	public void setSun(int sun) {
		this.sun = sun;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public int getIdVeg() {
		return idVeg;
	}
	public void setIdVeg(int idVeg) {
		this.idVeg = idVeg;
	}
	public List<Mese> getSowing() {
		return sowing;
	}
	public void setSowing(List<Mese> sowing) {
		this.sowing = sowing;
	}
	public List<Mese> getHarvest() {
		return harvest;
	}
	public void setHarvest(List<Mese> harvest) {
		this.harvest = harvest;
	}
	
}
