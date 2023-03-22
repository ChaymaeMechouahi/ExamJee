package estf.com.beans;

public class Task  {
	private int id;
	private String taskBody ;
	public Task( String taskBody) {
	
		this.taskBody = taskBody;
	} 
	public Task() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskBody() {
		return taskBody;
	}
	public void setTaskBody(String taskBody) {
		this.taskBody = taskBody;
	} 
	
	   
	}
