<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="POST">
		<input type="hidden" name="id" value="${user.id }"/>
		Name : <input type="text" name="name" value="${user.name }"/><br>
		Age : <input type="text" name="age" value="${user.age }"/><br>
		City : <input type="text" name="city" value="${user.city }"/><br>
		<input type="submit" value="Update"/>
	</form>
</body>
</html>