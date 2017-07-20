package com.heroes.model;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Htable")
public class Hero 
{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		
		@NotBlank
		@Size(min=3,max=10)
		private String name;
		@NotNull
		@Range(min=1,max=10)
		private Integer strength;
		@NotNull
		@Range(min=1,max=10)
		private Integer speed;
		@NotNull
		@Range(min=1,max=10)
		private Integer health;
		private String fileName;
		@OneToMany(mappedBy="hero")
		private List<Item> items = new ArrayList<>();
		public String getShort()
		{
			return id + ". " + name; 
		}
		public String toString() {
			return "ID: " + id + " \nName: " + name + "\nStrength: " + strength + "\nSpeed: " + speed + "\nHealth: " + health;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getStrength() {
			return strength;
		}
		public void setStrength(Integer strength) {
			this.strength = strength;
		}
		public Integer getSpeed() {
			return speed;
		}
		public void setSpeed(Integer speed) {
			this.speed = speed;
		}
		public Integer getHealth() {
			return health;
		}
		public void setHealth(Integer health) {
			this.health = health;
		}
		public List<Item> getItems() {
			return items;
		}
		public void setItems(List<Item> items) {
			this.items = items;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		
}
