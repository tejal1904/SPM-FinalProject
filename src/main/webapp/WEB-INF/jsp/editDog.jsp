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

 <form:form method="POST" modelAttribute="clientDog" action="/app/dogUpdate">
                    <form:input type="hidden" path="clientDogId" id="clientDogtId"/>
                    <input type="hidden" name="clientId" value = "${client.id}"/>
	      				<div class="control-group">
	                        <label class="col-sm-4 control-label">Name</label>
	                        <div class="col-sm-8 controls">
	                            <form:input path="name" />
	                            <form:errors path="name" cssClass="error"/>
	                        </div>
	                    </div>
	                    
	                    <div class="control-group">
	                        <label class="col-sm-4 control-label">Breed</label>
	                        <div class="col-sm-8 controls">
	                            <form:input path="breed" />
	                            <form:errors path="breed" cssClass="error"/>
	                        </div>
	                    </div>
                 
                    <div class="control-group">
                        <label class="col-sm-4 control-label">Date of Birth</label>
                        <div class="col-sm-8 controls">
                            <form:input type="date" path="dateOfBirth" />
                            <form:errors path="dateOfBirth" cssClass="error"/>
                        </div>
                    </div>
                   
               
                    
                    </br>
                    </br>
                    <div class="form-group control-group">

                        <div class="col-sm-5 col-sm-offset-4">
                            <button type="submit" name = "dogUpdate" value="dogUpdate" id="saveBtn" class="btn btn-primary btn-block">Update dog Detail</button>
                        </div>

                    </div>
                </form:form>
                </div>
            </div>

        </div>

</body>
</html>