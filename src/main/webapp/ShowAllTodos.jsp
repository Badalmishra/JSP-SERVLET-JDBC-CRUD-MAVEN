<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgColor="cyan">
<form method="get" action="AddTodo">
	<input name="body" placeholder="Enter Todo Body">
	<input type="submit" value="add">
</form> <br>
<h1>All Todos</h1>
	<ul>
		<c:forEach items="${Todos}" var="todo">
		    <li><c:out value="${todo.getBody()}"></c:out> <a href="deleteTodo?id=${todo.getId() }">Delete</a></li>  <br>
		</c:forEach>
	</ul>
</body>
</html>