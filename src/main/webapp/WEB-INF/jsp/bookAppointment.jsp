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
            </ul>
            <div class="pull-right">
                <a class="navbar-brand logout" href="/app/">Log out</a>
            </div>
        </div>
    </nav>

    <div class="container">
        <div id = "clientInformation" class="navContent">
            <div class="clientDetails">
                <form role="form">
                    <div class="col-sm-6">
                        <div class="control-group">
                            <label for="firstName" class="col-sm-4 control-label">Full Name</label>
                            <div class="col-sm-8 controls">
                                <input type="text" id="firstName" placeholder="Full Name" autofocus>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Address Line 1</label>
                            <div class="col-sm-8 controls">
                                <input id="address-line1" name="address-line1" type="text" placeholder="Street address, P.O. box, company name, c/o"
                                       class="input-xlarge">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Address Line 2</label>
                            <div class="col-sm-8 controls">
                                <input id="address-line2" name="address-line2" type="text" placeholder="Apartment, suite , unit, building, floor, etc."
                                       class="input-xlarge">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Suburb</label>
                            <div class="col-sm-8 controls">
                                <input id="suburb" name="suburb" type="text" placeholder="Suburb" class="input-xlarge">
                                <p class="help-block"></p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">State / Province / Region</label>
                            <div class="col-sm-8 controls">
                                <input id="region" name="region" type="text" placeholder="state / province / region"
                                       class="input-xlarge">
                                <p class="help-block"></p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Zip / Postal Code</label>
                            <div class="col-sm-8 controls">
                                <input id="postal-code" name="postal-code" type="number" placeholder="zip or postal code"
                                       class="input-xlarge">
                                <p class="help-block"></p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Mobile Number</label>
                            <div class="col-sm-8 controls">
                                <input id="mobileNumber" name="mobileNumber" type="number" placeholder="61(number)"
                                       class="input-xlarge">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Home Number</label>
                            <div class="col-sm-8 controls">
                                <input id="homeNumber" name="homeNumber" type="number" placeholder="61(number)"
                                       class="input-xlarge">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="col-sm-4 control-label">Work Phone Number</label>
                            <div class="col-sm-8 controls">
                                <input id="workNumber" name="workNumber" type="number" placeholder="61(number)"
                                       class="input-xlarge">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="noOfDogs" class="col-sm-4 control-label">No of dogs</label>
                            <div class="col-sm- controls">
                                <select class="form-control" id="noOfDogs">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group control-group">
                        <div class="col-sm-3 col-sm-offset-5">
                            <button type="submit" id="saveBtn" class="btn btn-primary btn-block">Save</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
        <div id = "bookAppointment" class="navContent" style="display:none;">
            <div class = "bookAppointmentClass">
                <form:form method="POST" modelAttribute="appointment" action="/app/appointmentSave">
                    <form:input type="hidden" path="appointmentId" id="appointmentId"/>
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
                          <form:select path="availableDog.DogId"  class="form-control">
                                <%-- <form:option value="NONE" label="--- Select ---"/> --%>
                                <form:options items="${availableDogList}" itemValue = "DogId" itemLabel = "breed"/>
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
    </div>
</div>

<script src="../lib/jquery.js"></script>
<script src="../javascript/homePage.js"></script>
</body>