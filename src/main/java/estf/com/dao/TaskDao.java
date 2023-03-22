package estf.com.dao;

import java.util.List;

import estf.com.beans.Task;


public interface TaskDao {

	public Task insert(Task task);
	public Task update(Task task);
	public Task delete(Task task);
	public Task get(int id);
	public List<Task> getAll();
}
