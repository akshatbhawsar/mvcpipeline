function validateEditForm() {
	var name = document.editForm.name.value;
	var location = document.editForm.location.value;
	var x = document.editForm.email.value;
	var atposition = x.indexOf("@");
	var dotposition = x.lastIndexOf(".");
	var dob = document.editForm.birthDate.value;
	if (name.length < 100 || name == "") {
		alert("Name can't be blank And Under 100 Charcters");
		return false;
	}
	if (location.length < 500 || name == "") {
		alert("Location must be not more then 500 characters long. or empty Location");
		return false;
	}

	if (atposition < 1 || dotposition < atposition + 2
			|| dotposition + 2 >= x.length) {
		alert("Please enter a valid e-mail address \n atpostion:" + atposition
				+ "\n dotposition:" + dotposition);
		return false;
	}
	if (dob == "") {
		alert("Please provide valid DOB");
		return false;
	}

}