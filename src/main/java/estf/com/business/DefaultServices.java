package estf.com.business;

import java.util.List;

import estf.com.beans.Task;
import estf.com.dao.TaskDao;
import estf.com.dao.TaskDaoMemory;



public class DefaultServices implements Services{

	private static DefaultServices instance = null;
	public static DefaultServices getInstance() {
		if(instance==null)
			instance=new DefaultServices(new TaskDaoMemory());
		return instance;
	}
	
	private TaskDao taskDao;
	private DefaultServices(TaskDao todoDao) {
		this.taskDao=todoDao;
	}
	@Override
	public Task addTask(Task task) {
		return taskDao.insert(task);
	}

	@Override
	public Task updateTask(Task task) {
		return taskDao.update(task);
	}

	@Override
	public Task deleteTask(Task task) {
		return taskDao.delete(task);
	}

	@Override
	public Task getTask(int id) {
		return taskDao.get(id);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskDao.getAll();
	}
}
