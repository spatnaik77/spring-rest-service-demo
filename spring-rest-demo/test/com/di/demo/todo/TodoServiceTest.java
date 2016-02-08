package com.di.demo.todo;

import java.util.List;

import org.junit.Test;

import com.sidd.demo.todo.entity.Category;
import com.sidd.demo.todo.entity.Task;
import com.sidd.demo.todo.entity.User;
import com.sidd.demo.todo.service.InMemoryTodoService;
import com.sidd.demo.todo.service.TodoService;

public class TodoServiceTest {
	
	TodoService service = new InMemoryTodoService();

	@Test
	public void test() 
	{
		User user = new User();
		String name = "Siddharth"; 
		user.setName(name);
		
		Category catg1 = new Category();
		catg1.setName("personal");
		catg1.setOwner(name);
		
		Task task1_catg1 = new Task();
		task1_catg1.setCategory("personal");
		task1_catg1.setName("pay mobile bill");
		task1_catg1.setOwner(name);
		
		
		Category catg2 = new Category();
		catg2.setName("Movies to watch");
		catg2.setOwner(name);
		
		Task task1_catg2 = new Task();
		task1_catg2.setCategory("Movies to watch");
		task1_catg2.setName("Airlift");
		task1_catg2.setOwner(name);
		
		
		service.createUser(user);
		
		service.createCategory(catg1);
		service.createCategory(catg2);
		
		service.createTask(task1_catg1);
		service.createTask(task1_catg2);
		
		List<Category> categoryList = service.getCategories(name);

		List<Task> taskList = service.getTasks(name, "personal");
		
		System.out.println("TodoServiceTest.test()");
		
	}

}
