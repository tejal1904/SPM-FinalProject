<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book an Appointment</title>
</head>
<body>

<form:form method="POST" modelAttribute="appointment" action="/app/appointmentSave">
        <form:input type="hidden" path="appointmentId" id="appointmentId"/>
        <b>${timeslotList}</b>
        <table>
            <tr>
            	<td><label for=groomingOption>Select Grooming Option: </label> </td>
                <td><form:select path="groomingOption.groomingId">
				   <%-- <form:option value="NONE" label="--- Select ---"/> --%>
				   <form:options items="${groomingOptionList}" itemValue = "groomingId" itemLabel = "groomingType" />
				</form:select></td>

                <td><form:errors path="groomingOption" cssClass="error"/></td>
            </tr>
         
            <tr>
           
                <td><label for="appointmentDate">Date for Appointment: </label> </td>
                <td><form:input type="date" path="appointmentDate" /></td>
                <td><form:errors path="appointmentDate" cssClass="error"/></td>
            </tr>
            
            <tr>
            	<td><label for="timeslot">Select Time Slot: </label> </td>
                <td><form:select path="timeslot.timeSlotId">
				   <%-- <form:option value="NONE" label="--- Select ---"/> --%>
				   <form:options items="${timeSlotList}" itemValue = "timeSlotId" itemLabel = "timeStart" />
				</form:select>
				</td>
                <td><form:errors path="timeslot" cssClass="error"/></td>
            </tr>
            
            <tr>
            	<td><label for="availableDog">Select Dog: </label> </td>
                <td><form:select path="availableDog.DogId">
				   <%-- <form:option value="NONE" label="--- Select ---"/> --%>
				   <form:options items="${availableDogList}" itemValue = "DogId" itemLabel = "breed"/>
				</form:select>
				</td>
                <td><form:errors path="availableDog" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="comment">Additional Comments: </label> </td>
                <td><form:input path="comment" /></td>
                <td><form:errors path="comment" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                	<button type="submit" name = "appointmentSave" value="appointmentSave">save appointment</button>
                </td>
               
            </tr>
        </table>
    </form:form>

</body>
</html>