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
<script src="js/editEmpValidation.js"></script>

<title>Edit Employees</title>
</head>
<body>
	<%
	System.out.println(session.getAttribute("username"));
	if(session.getAttribute("username")==null)
	{
		System.out.println("i am called in null");
		response.sendRedirect("index.jsp");	
	}

	
		Employee emp = (Employee) request.getAttribute("emp");
	%>


	<nav class="navbar fixed-top navbar bg-primary">
		<div class="navbar-brand header">Add</div>
	</nav>
	<div class="container">


		<div class="container">




			<form action="editEmp?id=<%=emp.getEmployeeCode()%>"
				 class="Form" method="post" onsubmit="return validateEditForm()" name="editForm">
				 
				<div class="form-group fields">

					<label for="validationCustom03">EmployeeName</label><br> <input
						name="name" type="text" class="form-control"
						id="validationCustom03" value=<%=emp.getName()%> required>
					<div class="invalid-feedback">Please provide a valid Name.</div>
				</div>

				<div class="form-group fields">
					<label for="validationCustom03">Location</label><br> <input
						name="location" type="text" class="form-control"
						id="validationCustom03" value=<%=emp.getLocation()%> required>
					<div class="invalid-feedback">Please provide a valid location
						.</div>
				</div>

				<div class="form-group fields">
					<label for="validationCustom03">Email</label><br> <input
						name="email" type="text" class="form-control"
						id="validationCustom03" value=<%=emp.getEmail()%> required>
					<div class="invalid-feedback">Please provide a valid Email.</div>
				</div>
				<div class="form-group fields">
					<label for="validationCustom03">BirthDate</label><br> <input
						name="birthDate" type="text" class="form-control"
						id="validationCustom03" value=<%=emp.getbirthDate()%> required>
					<div class="invalid-feedback">Please provide a valid DOB.</div>
				</div>
				<br>

				<button type="submit" class="btn btn-primary ">Add</button>

			</form>







		</div>


 <footer class="footer">
      <div class="container">
        <span class="text-muted">Employee Management.</span>
      </div>
    </footer>


		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
			crossorigin="anonymous"></script>
</body>
</html>