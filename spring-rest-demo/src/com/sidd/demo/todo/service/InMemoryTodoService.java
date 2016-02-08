/**
 * 
 */
package com.sidd.demo.todo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sidd.demo.todo.entity.Category;
import com.sidd.demo.todo.entity.Task;
import com.sidd.demo.todo.entity.User;

/**
 * @author sr250345
 *
 */
public class InMemoryTodoService implements TodoService
{
	private Map<String, User> userMap;
	private Map<String, List<Category>> user2CategoryMap;
	private Map<String, List<Task>> category2TaskMap;
	
	public InMemoryTodoService()
	{
		userMap = new HashMap<String, User>();
		user2CategoryMap = new HashMap<String, List<Category>>();
		category2TaskMap = new HashMap<String, List<Task>>();
	}
	
	@Override
	public void createUser(User user) 
	{
		userMap.put(user.getName(), user);
		
	}
	
	@Override
	public void createCategory(Category category) 
	{
		List<Category> categoryList = user2CategoryMap.get(category.getOwner());
		if(categoryList == null)
		{
			categoryList = new ArrayList<Category>();
			categoryList.add(category);
			user2CategoryMap.put(category.getOwner(), categoryList);
		}
		else
		{
			categoryList.add(category);
		}
	}

	@Override
	public void createTask(Task task) 
	{
		List<Task> taskList = category2TaskMap.get(task.getCategory());
		if(taskList == null)
		{
			taskList = new ArrayList<Task>();
			taskList.add(task);
			category2TaskMap.put(task.getCategory(), taskList);
		}
		else
		{
			taskList.add(task);
		}
	}

	@Override
	public List<Category> getCategories(String user) 
	{
		return user2CategoryMap.get(user);
	}

	@Override
	public List<Task> getTasks(String user, String category) 
	{
		return category2TaskMap.get(category);
	}
	
	public void populateSampleData() 
	{
		User user = new User();
		user.setName("siddharth");
		
		Category catg1 = new Category();
		catg1.setName("personal");
		catg1.setOwner("siddharth");
		
		Task task1_catg1 = new Task();
		task1_catg1.setCategory("personal");
		task1_catg1.setName("pay mobile bill");
		task1_catg1.setOwner("siddharth");
		
		
		Category catg2 = new Category();
		catg2.setName("Movies to watch");
		catg2.setOwner("siddharth");
		
		Task task1_catg2 = new Task();
		task1_catg2.setCategory("Movies to watch");
		task1_catg2.setName("Airlift");
		task1_catg2.setOwner("siddharth");
		
		
		createUser(user);
		
		createCategory(catg1);
		createCategory(catg2);
		
		createTask(task1_catg1);
		createTask(task1_catg2);
		
		
		
	}
	
}
