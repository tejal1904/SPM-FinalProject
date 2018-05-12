<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Pet Grooming System</h2>
  
    <form:form method="POST" modelAttribute="client">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="email">Email: </label> </td>
                <td><form:input path="email" id="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="password">Password: </label> </td>
                <td><form:password path="password" id="password"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                	<input type="submit" name = "login" value="Login"/>
                </td>
                <td colspan="3">
                	<input type="submit" name = "register" value="Register"/>
                </td>
              
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
</body>
</html>