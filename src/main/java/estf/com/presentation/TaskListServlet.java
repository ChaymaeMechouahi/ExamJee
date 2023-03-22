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

@WebServlet("/TaskList")
public class TaskListServlet extends HttpServlet {
	private List<Task> tasks = new ArrayList();

    public TaskListServlet() {
        super();
    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		
		try {
			this.tasks = DefaultServices.getInstance().getAllTasks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Task task : tasks) {
			task.toString();
		}
		request.setAttribute("mylist", tasks);
		request.getRequestDispatcher("TaskList.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("idToDelete") == null) {
			doGet(request, response);
		} else {
			doDelete(request, response);
		}	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			DefaultServices.getInstance().deleteTask(DefaultServices.getInstance().getTask(Integer.parseInt(request.getParameter("idToDelete"))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);

	}
	
}

