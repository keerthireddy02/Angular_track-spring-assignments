<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="updatestudent" method="get">
      Id :<input type="number" name="id" required><br><br>
      <h3>Enter branch to update</h3>
      Branch :<input type="text" name="branch" ><br><br>
      <input type="submit" value="Update Student">
   </form>
</body>
</html>