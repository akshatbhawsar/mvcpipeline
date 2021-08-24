<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
     <link href="css/style.css" rel="stylesheet">
    <title>EmployeeManagement</title>
  </head>
  <body>
  <script type="text/javascript" src="js/signupValidation.js"></script>

  <nav class="navbar fixed-top navbar bg-primary">
		<div class="navbar-brand header">Signup</div>
		
	</nav>
  
     <div class="container">
     
     
     <form action="signup" class="inForm" method="post" onsubmit="return validateUserForm()" name="userForm">
  <div class="mb-3">
    <label for="validationCustom03">UserName</label>
    <br>
      <input type="text" class="form-control" id="validationCustom03" name="username" required>
      <div class="invalid-feedback">
        Please provide a valid Username.
      </div>
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="password" class="form-control" id="password1" name="cpassword" required>
    <div class="invalid-feedback">
        Please provide a valid password.
      </div>
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Confirm Password</label>
    <input type="text" class="form-control" id="password2" name="password" required>
    <div class="invalid-feedback">
        Please provide a valid password.
      </div>
  </div>
 
  <button type="submit" class="btn btn-primary button">Signup</button>
</form>
         
     </div>
  <footer class="footer">
      <div class="container">
        <span class="text-muted">Employee Management.</span>
      </div>
    </footer>
  

   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
  </body>
</html>


 