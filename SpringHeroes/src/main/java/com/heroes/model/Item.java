package com.heroes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "Item")
public class Item 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	private String name;
	@Range(min=1,max=5)
	@NotNull
	private int bodyPart;
	@NotNull
	private int strength;
	@NotNull
	private int speed;
	@NotNull
	private int health;
	@ManyToOne
	@JoinColumn(name="hero_id")
	private Hero hero;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBodyPart() {
		return bodyPart;
	}
	public void setBodyPart(int bodyPart) {
		this.bodyPart = bodyPart;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", bodyPart=" + bodyPart + ", strength=" + strength + ", speed=" + speed
				+ ", health=" + health + "]";
	}
	
	
}
