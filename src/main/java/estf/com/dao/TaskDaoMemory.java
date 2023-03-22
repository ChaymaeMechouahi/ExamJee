package estf.com.dao;

import java.util.List;
import java.util.Vector;

import estf.com.beans.Task;



public class TaskDaoMemory implements TaskDao{
	private List<Task> tasks;
	private int lastIndex = 0;
	public TaskDaoMemory() {
		tasks = new Vector<Task>();
		insert(new Task("rdv dentiste"));
		insert(new Task("rdv docteur"));
		insert(new Task("exam Tmimi"));

	}

	@Override
	public Task insert(Task task) {
		lastIndex++;
		task.setId(lastIndex );
		tasks.add(task);
		return task;
	}

	@Override
	public Task update(Task task) {
		Task twisk = get(task.getId());
		if (twisk == null)
			return null;

		twisk.setId(task.getId());
		twisk.setTaskBody(task.getTaskBody());
		return twisk;
	}

	@Override
	public Task delete(Task task) {
		Task element = get(task.getId());
		if (element == null)
			return null;

		tasks.remove(element);
		return element;		
	}


	@Override
	public Task get(int id) {

		for (Task element : tasks)
			if (element.getId()==id)
				return element;
		return null;		}

	@Override
	public List<Task> getAll() {
		// TODO Auto-generated method stub
		return tasks;
	}
	 

}