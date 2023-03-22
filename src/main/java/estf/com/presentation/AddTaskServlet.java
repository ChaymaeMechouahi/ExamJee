package estf.com.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import estf.com.beans.Task;
import estf.com.business.DefaultServices;



@WebServlet("/Tasks")
public class AddTaskServlet extends HttpServlet {
	private List<Task> tasks = new ArrayList();
    public AddTaskServlet() {
        super();
	     tasks = DefaultServices.getInstance().getAllTasks();

    }
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("addTask.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("i am into Add");
			String taskBody = request.getParameter("taskBody");
		    Boolean valueBl = false;
			if(taskBody != null && taskBody.isEmpty())  valueBl = true;
	        if (!valueBl)
	        {
	        	Task task = DefaultServices.getInstance().addTask(new Task(taskBody));
				request.setAttribute("mylist", tasks);
				request.getRequestDispatcher("/TaskList").forward(request,response);            	
	        }

	        else {
	        	request.setAttribute("message", "all fields are required");
				request.getRequestDispatcher("addTask.jsp").forward(request, response);
	        }
		}
}
