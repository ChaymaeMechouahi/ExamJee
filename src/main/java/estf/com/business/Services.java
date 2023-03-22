package estf.com.business;

import java.util.List;

import estf.com.beans.Task;


public interface Services {
	public Task addTask(Task task);
	public Task updateTask(Task task);
	public Task deleteTask(Task task);
	public Task getTask(int id);
	public List<Task> getAllTasks();

}
