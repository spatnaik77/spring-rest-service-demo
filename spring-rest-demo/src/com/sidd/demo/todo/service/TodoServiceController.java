/**
 * 
 */
package com.sidd.demo.todo.service;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sidd.demo.todo.entity.Category;
import com.sidd.demo.todo.entity.Task;
import com.sidd.demo.todo.entity.User;

/**
 * @author Siddharth patnaik
 *
 */
@RestController
public class TodoServiceController 
{
	
	InMemoryTodoService service;
	
	Logger logger = Logger.getLogger(TodoServiceController.class);
	
	public TodoServiceController()
	{
		service = new InMemoryTodoService();
		
		service.populateSampleData();
	}
	
	@RequestMapping(method = RequestMethod.GET, produces="application/json", value = "/")
	public String hello()
	{
		return "Hello world";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users", consumes="application/json")
	public void createUser(@RequestBody User user)
	{
		service.createUser(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users/{user}/categories", consumes="application/json")
	public void createCategory(@RequestBody Category category)
	{
		service.createCategory(category);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users/{user}/categories/{category}/tasks", consumes="application/json")
	public void createTask(Task task)
	{
		service.createTask(task);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces="application/json", value = "/users/{user}/categories")
	public List<Category> getCategories(@PathVariable("user") String user)
	{
		return service.getCategories(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces="application/json", value = "/users/{user}/categories/{category}/tasks")
	public List<Task> getTasks(@PathVariable("user") String user, @PathVariable("category") String category)
	{
		System.out.println("TodoServiceController.getTasks()");
		List<Task> tasks = service.getTasks(user, category);
		return tasks;
	}
	
	

}
