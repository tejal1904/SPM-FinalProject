<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="../lib/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../stylesheets/style.css">

    <style>

        .error {
            color: #ff0000;
        }
    </style>

</head>

<body>
<h1> Welcome to Pet Grooming System</h1>
<div class="wrapper">
    <div class="tab">
        <button class="tablinks active" data-val="signup">Sign Up</button>
        <button class="tablinks" data-val="login">login</button>
    </div>

    <div id="signup" class="tabcontent" style="display: block;">
        <form:form method="POST" modelAttribute="client" id='register-form'>
            <form:input type="hidden" path="id" id="id"/>
            <table>
                <tr>
                    <td>E-Mail</td>
                    <td >
                        <form:input path="email" id="signup-email" type="email" placeholder="Email"/>
                    </td>
                    <td><form:errors path="email" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>
                        <form:password path="password" id="signup-password" placeholder="Password"/>
                    </td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>
            </table>
            <button type="submit" name = "register" class="button button-block" value="Register"> Register </button>
            </form:form>
    
    </div>

    <div id="login" class="tabcontent" style="display: none;">
        <form:form method="POST" modelAttribute="client" id="login-form">
            <form:input type="hidden" path="id" id="id"/>
            <table>
                <tr>
                    <td>E-Mail</td>
                    <td >
                        <form:input path="email" id="login-email" type="email" placeholder="Email"/>
                    </td>
                    <td><form:errors path="email" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>
                        <form:password path="password" id="login-password" placeholder="Password"/>
                    </td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>
            </table>
            <button type="submit" class="button button-block" name = "login" value="Login"> Login </button>
            </form:form>
    </div>
</div>


<script src="../lib/jquery.js"></script>
<script src="../javascript/loginSignup.js"></script>
</body>
</html>