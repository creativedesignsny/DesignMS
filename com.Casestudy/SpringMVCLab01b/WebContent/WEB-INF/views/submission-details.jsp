<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thanks!</title>
</head>
<body>

<h1>Your Input:</h1>

<table>
<tr><td>First Name</td><td>${user.getFname()}</td></tr>
<tr><td>Last Name</td><td>${user.getLname()}</td></tr>
<tr><td>User Name</td><td>${user.getUname()}</td></tr>
<tr><td>Gender</td><td>${user.getGender()}</td></tr>
<tr><td>Phone Number</td><td>${user.getContactInfo().getPhone()}</td></tr>
<tr><td>Email</td><td>${user.getContactInfo().getEmail()}</td></tr>
<tr><td>LinkedIn URL</td><td>${user.getContactInfo().getLinkedIn()}</td></tr>
<tr><td>Social Security Number</td><td>${user.getPrivateInfo().getSSN()}</td></tr>
<tr><td>Credit Card Number</td><td>${user.getPrivateInfo().getCCN()}</td></tr>
<tr><td>Date of Birth</td><td>${user.getPrivateInfo().getDOB()}</td></tr>
</table>

<a href="">Home</a>

</body>
</html>