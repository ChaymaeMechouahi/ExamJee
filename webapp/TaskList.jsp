<%@page import="estf.com.beans.Task"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		List<Task> myList = (List<Task>) request.getAttribute("mylist");
		for (Task task : myList) {
		%>
		<ul>		
        <li>
        <%=task.getId()%> <%=task.getTaskBody()%>
        <form method="post" >
				<input type="hidden" name="idToDelete" value=<%=task.getId()%>>
				<button type="submit">X</button>
				<button type="submit">Up</button>
				<button type="submit">Down</button>				
			</form>    
        
        </li>      
      </ul>      
		
   <%
		}
		%>
</body>
</html>