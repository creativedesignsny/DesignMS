<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
<h2 style="font-size: 25px;">Enter Details:</h2>
<form action="process-form" method="post">
<table>

<tr><td>First Name</td><td><input type="text" name="fname" /></td></tr>
<tr><td>Last Name</td><td><input type="text" name="lname" /></td></tr>
<tr><td>User Name</td><td><input type="text" name="uname" /></td></tr>
<tr><td>Gender</td>
	<td><input type="radio" name="gender" value="male"/>Male<br>
	<input type="radio" name="gender" value="female"/>Female</td>
</tr>
<tr><td>Phone Number</td><td><input type="tel" name="contactInfo.phoneNumber" /></td></tr>
<tr><td>Email</td><td><input type="email" name="contactInfo.email" /></td></tr>
<tr><td>LinkedIn URL</td><td><input type="url" name="contactInfo.linkedInUrl" /></td></tr>
<tr><td>Social Security Number</td><td><input type="number" name="privateInfo.ssn" /></td></tr>
<tr><td>Credit Card Number</td><td><input type="number" name="privateInfo.ccn" /></td></tr>
<tr><td>Date of Birth</td><td><input type="date" name="privateInfo.dob" /></td></tr>
<tr>
<td colspan="2"><input type="submit" value="Submit" name="submit"/></td>
</tr>

</table>
</form>

</body>
</html>