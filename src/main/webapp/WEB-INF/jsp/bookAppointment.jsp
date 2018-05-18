<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Book an Appointment</title>
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
                <li class="active navHead" data-val="clientInformation"><a href="#">Client Information</a></li>
                <li class="navHead" data-val="bookAppointment"><a href="#">Book Appointments</a></li>
                <li class="navHead" data-val="showAppointment"><a href="#">Show Appointments</a></li>
            </ul>
            <div class="pull-right">
                <a class="navbar-brand logout" href="/app/">Log out</a>
            </div>
        </div>
    </nav>

    <div class="container">
        <div id = "clientInformation" class="navContent">
            <div class="clientDetails">
                <form:form id="client-info-form" method="POST" modelAttribute="client" action = "/app/updateClient">
                    <form:input type="hidden" path="id" id="id"/>
                    <div class="col-sm-6">
                        <div class="control-group">
                            <label for="firstName" class="col-sm-4 control-label">Full Name</label>
                            <div class="col-sm-8 controls">
                                <form:input path="name" type="text" id="firstName" placeholder="Full Name" required="required"/>
                                <form:errors path="name" cssClass="error"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">EMail</label>
                            <div class="col-sm-8 controls">
                                <form:input path="email" type="email" placeholder="email"
                                            class="input-xlarge" required="required"/>
                                <form:errors path="email" cssClass="error"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Password</label>
                            <div class="col-sm-8 controls">
                                <form:password path="password" placeholder="Password"
                                               class="input-xlarge" required="required"/>
                                <form:errors path="password" cssClass="error"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Address</label>
                            <div class="col-sm-8 controls">
                                <form:input path="address" type="text" placeholder="Address"
                                            class="input-xlarge" required="required"/>
                                <form:errors path="address" cssClass="error"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Mobile Number</label>
                            <div class="col-sm-8 controls">
                                <form:input path="mobile" id="mobileNumber" name="mobileNumber" type="number" placeholder="61(number)"
                                            class="input-xlarge" required="required"/>
                                <form:errors path="mobile" cssClass="error"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Home Number</label>
                            <div class="col-sm-8 controls">
                                <form:input path="homePhone" id="homeNumber" name="homeNumber" type="number" placeholder="61(number)"
                                            class="input-xlarge"/>
                                <form:errors path="homePhone" cssClass="error"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Work Phone Number</label>
                            <div class="col-sm-8 controls">
                                <form:input path="workNo" id="workNumber" name="workNumber" type="number" placeholder="61(number)"
                                            class="input-xlarge"/>
                                <form:errors path="workNo" cssClass="error"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="control-group">
                            <label for="noOfDogs" class="col-sm-4 control-label">No of dogs</label>
                            <div class="col-sm-8 controls">
                                <select class="form-control" id="noOfDogs">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>
                        </div>
                    </br>
                    <div id="dog-info-container">
                    
                    </div> 
                    </div>
                  
                    </br> 
                    <div class="form-group control-group">
                   
                        <div class="col-sm-3 col-sm-offset-5">
                            <button type="submit" name="updateClient" path="updateClient" id="updateClient"class="btn btn-primary btn-block">Save</button>
                        </div>
                    </div>

                </form:form>
            </div>

        </div>
        <div id = "bookAppointment" class="navContent" style="display:none;">
            <div class = "bookAppointmentClass">
                <form:form method="POST" modelAttribute="appointment" action="/app/appointmentSave">
                    <form:input type="hidden" path="appointmentId" id="appointmentId"/>
                   <input type="hidden" name="clientId" value = "${client.id}"/>
                    <b>${timeslotList}</b>

                    <div class="control-group">
                        <label class="col-sm-4 control-label">Grooming Option</label>
                        <div class="col-sm-8 controls">
                            <form:select path="groomingOption.groomingId"  class="form-control">
                                <%-- <form:option value="NONE" label="--- Select ---"/> --%>
                                <form:options items="${groomingOptionList}" itemValue = "groomingId" itemLabel = "groomingType" />
                            </form:select>
                        </div>
                    </div>
                    </br>
                    <div class="control-group">
                        <label class="col-sm-4 control-label">Date for Appointment</label>
                        <div class="col-sm-8 controls">
                            <form:input type="date" path="appointmentDate" />
                            <form:errors path="appointmentDate" cssClass="error"/>
                        </div>
                    </div>
                    </br>
                    </br>
                    <div class="control-group">
                        <label class="col-sm-4 control-label">Select time slot</label>
                        <div class="col-sm-8 controls">
                            <form:select path="timeslot.timeSlotId" class="form-control">
                                <%-- <form:option value="NONE" label="--- Select ---"/> --%>
                                <form:options items="${timeSlotList}" itemValue = "timeSlotId" itemLabel = "timeStart" />
                            </form:select>
                            <form:errors path="timeslot" cssClass="error"/>
                        </div>
                    </div>
                    </br>
                    </br>
                    <div class="control-group">
                        <label class="col-sm-4 control-label">Select Dog</label>
                        <div class="col-sm-8 controls">
                            <form:select path="availableDog.clientDogId"  class="form-control">
                                <%-- <form:option value="NONE" label="--- Select ---"/> --%>
                                <form:options items="${availableDogList}" itemValue = "clientDogId" itemLabel = "breed"/>
                            </form:select>
                            <form:errors path="availableDog" cssClass="error"/>
                        </div>
                    </div>
                    </br>
                    <div class="control-group">
                        <label class="col-sm-4 control-label">Additional Comments</label>
                        <div class="col-sm-8 controls">
                            <form:input path="comment" />
                            <form:errors path="comment" cssClass="error"/>
                        </div>
                    </div>
                    </br>
                    </br>
                    <div class="form-group control-group">

                        <div class="col-sm-5 col-sm-offset-4">
                            <button type="submit" name = "appointmentSave" value="appointmentSave" id="saveBtn" class="btn btn-primary btn-block">Save Appointment</button>
                        </div>

                    </div>
                </form:form>
            </div>

        </div>
        
        <div id = "showAppointment" class="navContent" style="display:none;">
            <div class = "showAppointmentClass">
          
            	<h2>My Appointments</h2>
            	<table>
			        <tr>
			            <td>Grooming Option</td><td>Date</td><td>Time</td><td>Dog</td><td>Comments</td><td></td><td></td>
			        </tr>
			        <c:forEach items="${appointmentList}" var="appointment">
			        	<input type="hidden" name="appointment" value = "${appointment}"/>
			            <tr>
			        
			            <td>
	                            <form:select path="appointment.groomingOption.groomingType"  class="form-control">
	                                <form:options items="${groomingOptionList}" itemValue = "groomingId" itemLabel = "groomingType" />
	                                
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
                        <td><a href = "<c:url value='/app/editAppointment' />">Edit</a></td>
                       <td><a href = "<c:url value='/app/deleteAppointment' />">Edit</a></td>
			            </tr>
			        </c:forEach>
		    	</table>
         
            </div>
        </div>
        
    </div>
</div>

<script src="../lib/jquery.js"></script>
<script src="../javascript/homePage.js"></script>
</body>