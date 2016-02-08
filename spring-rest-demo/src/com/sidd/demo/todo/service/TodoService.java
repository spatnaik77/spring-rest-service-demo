/**
 * 
 */
package com.sidd.demo.todo.service;

import java.util.List;

import com.sidd.demo.todo.entity.Category;
import com.sidd.demo.todo.entity.Task;
import com.sidd.demo.todo.entity.User;

/**
 * @author sr250345
 *
 */
public interface TodoService {
	
	public void createUser(User user);
	
	public void createCategory(Category category);
	
	public void createTask(Task task);
	
	public List<Category> getCategories(String user);
	
	public List<Task> getTasks(String user, String category);
	
}
