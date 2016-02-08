/**
 * 
 */
package com.sidd.demo.todo.entity;

import java.util.Date;

/**
 * @author Siddharth patnaik
 *
 */
public class Task 
{
	private String name;
	private Date dueOn;
	private String category;
	private String owner;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDueOn() {
		return dueOn;
	}
	public void setDueOn(Date dueOn) {
		this.dueOn = dueOn;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
