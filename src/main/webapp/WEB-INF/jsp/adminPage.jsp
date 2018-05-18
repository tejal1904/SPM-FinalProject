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
                        <th scope="col">Grooming Option</th>
                        <th scope="col">Date</th>
                        <th scope="col">Time</th>
                        <th scope="col">Dog</th>
                        <th scope="col">Comments</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allAppointments}" var="appointment">
                        <input type="hidden" name="appointment" value = "${appointment}"/>
                        <tr>
                            <td>
                                <form:select path="appointment.groomingOption.groomingType" class="form-control">
                                    <form:options items="${groomingOptionList}" itemValue = "groomingId" itemLabel = "groomingType"/>
                                </form:select>
                            </td>

                            <td>
                                <form:input type="date" path="appointment.appointmentDate" />
                                <form:errors path="appointmentDate" cssClass="error"/>
                            </td>
                            <td>
                                <form:select path="appointment.timeslot.timeSlotId" class="form-control">
                                    <form:options items="${timeSlotList}" itemValue = "timeSlotId" itemLabel = "timeStart" />
                                </form:select>
                                <form:errors path="timeslot" cssClass="error"/>

                            </td>
                            <td>
                                <form:select path="appointment.availableDog.clientDogId"  class="form-control">
                                    <form:options items="${availableDogList}" itemValue = "clientDogId" itemLabel = "breed"/>
                                </form:select>
                                <form:errors path="availableDog" cssClass="error"/>

                            </td>
                            <td> <form:input path="appointment.comment" />
                                <form:errors path="comment" cssClass="error"/>
                            </td>
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