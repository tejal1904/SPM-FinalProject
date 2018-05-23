<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="../lib/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../stylesheets/style.css">
</head>
<body>
<div class="bookAppointmentClass mainContainer">

 <form:form method="POST" modelAttribute="appointment" action="/app/appointmentUpdate">
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
                        <label class="col-sm-4 control-label"> ${availableDog.breed} </label>
                        
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
                            <button type="submit" name = "appointmentUpdate" value="appointmentUpdate" id="saveBtn" class="btn btn-primary btn-block">Update Appointment</button>
                        </div>

                    </div>
                </form:form>
                </div>
            </div>

        </div>

</body>
</html>