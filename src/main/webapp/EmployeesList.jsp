<%@ page import="java.util.*,com.nagarro.employeemanagement.model.*"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link href="css/style.css" rel="stylesheet">
<title>Employees</title>
</head>
<body>

	<nav class="navbar fixed-top navbar bg-primary">
		<div class="navbar-brand header">
			Welcome
			<%=session.getAttribute("username")%>
		</div>
		<a href="logout"class="btn btn-success">logout</a>

	</nav>


	<div class="container">

		<%
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			if (session.getAttribute("username") == null)
				response.sendRedirect("index.jsp");
			List<Employee> empList = (List<Employee>) request.getAttribute("empList");
			if (null != request.getAttribute("Status")) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('" + request.getAttribute("Status") + "');");
				out.println("</script>");
			}
		%>

		<div class="alert alert-success Alert" role="alert">List Of
			Employees</div>


		<a href="requestAddEmp">Add More Employees</a> <br> <a
			href="http://localhost:8081/emp/downlode">Downlode List</a> 


		<table class="table table-success table-striped Table">
			<thead>
				<tr>
					<th scope="col">EmployeeCode</th>
					<th scope="col">Name</th>
					<th scope="col">Location</th>
					<th scope="col">Email</th>
					<th scope="col">DOB</th>
					<th scope=""col">Actions</th>
				</tr>
			</thead>
			<tbody>

				<%
					for (Employee e : empList) {
				%>
				<tr>
					<th scope="row"><%=e.getEmployeeCode()%></th>
					<td><%=e.getName()%></td>
					<td><%=e.getLocation()%></td>
					<td><%=e.getEmail()%></td>
					<td><%=e.getbirthDate()%></td>
					<td><a href="requestEditEmp?id=<%=e.getEmployeeCode()%>">Edit</a>
						<br> <a href="deleteEmp?id=<%=e.getEmployeeCode()%>">Delete
							List</a></td>
				</tr>
				<%
					}
				%>


			</tbody>
		</table>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>