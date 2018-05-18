<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
    <title>View Bookings</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../lib/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../stylesheets/style.css">
</head>
<body>
<div class="mainContainer">
<nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a id="welcomeUsername" class="navbar-brand" href="#">Welcome </a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active navHead" data-val="clientInformation"><a href="#">List of bookings</a></li>
            </ul>
            <div class="pull-right">
                <a class="navbar-brand logout" href="/app/">Log out</a>
            </div>
        </div>
    </nav>

    <div class="container">  
        <div id = "showAppointment" class="navContent">
            <div class = "showAppointmentClass">
                <h3>My Bookings</h3>
                <table class="table table-dark">
                    <thead>
                    <tr>
	                    <th scope="col">Name</th>
	                    <th scope="col">Address</th>
	                    <th scope="col">Mobile Number</th>
	                    <th scope="col">E Mail</th>
                        <th scope="col">Grooming Option</th>
                        <th scope="col">Date</th>
                        <th scope="col">Time</th>
                        <th scope="col">Dog</th>
                        <th scope="col">Comments</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${appointmentList}" var="appointment">
                        <input type="hidden" name="appointment" value = "${appointment}"/>
                        <tr>
                        <td>${appointment.client.name}</td>
	                        <td>${appointment.client.address}</td>
	                        <td>${appointment.client.mobile}</td>
	                        <td>${appointment.client.email}</td>
                        	<td>${appointment.groomingOption.groomingType}</td>
                        	<td>${appointment.appointmentDate}</td>
                        	<td>${appointment.timeslot.timeStart}</td>
                        	<td>${appointment.availableDog.breed}</td>
                        	<td>${appointment.comment}</td>                 
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="../lib/jquery.js"></script>
<script src="../javascript/homePage.js"></script>
</body>
</html>