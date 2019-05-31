<%@page import="com.todo.Todo" %>
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
		Todo todo = (Todo)request.getAttribute("todo");
		out.println(todo);
	%>
</body>
</html>