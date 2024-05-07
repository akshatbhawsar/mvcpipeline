
function validateUserForm(){ 
	console.log("gsdfsdfsdf");
var firstpassword=document.userForm.cpassword.value;  
var secondpassword=document.userForm.password.value; 

console.log(firstpassword);
console.log(secondpassword);
  
if(firstpassword==secondpassword){  
return true;  
}  
else{  
	
alert("password must be same!");  
return false;  
}  
return false;
}  