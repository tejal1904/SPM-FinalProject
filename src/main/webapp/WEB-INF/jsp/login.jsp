<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/style.css">
    <title>Pet Grooming System</title>
</head>
<body>

    <h1> Welcome to Pet Grooming System</h1>
    <div class="wrapper">
        <div class="tab">
            <button class="tablinks active" data-val="signup">Sign Up</button>
            <button class="tablinks" data-val="login">login</button>
        </div>
        <div id="signup" class="tabcontent" style="display: block;">
            <form id='register-form'>
                <table>
                    <tr>
                        <td>E-Mail</td>
                        <td >
                            <input id="signup-email" type="email" placeholder="Email" required>
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <input id="signup-password" type="password" placeholder="Password" required>
                        </td>
                    </tr>
                    <!-- <tr>
                        <td>Retype password</td>
                        <td>
                            <input id="signup-retype-password" type="password" placeholder="Re Password" required>
                        </td>
                    </tr> -->
                </table>
                <button type="submit" name = "register" class="button button-block">Sign Up</button>
            </form>
        </div>

        <div id="login" class="tabcontent" style="display: none;">
            <form id="login-form">
                <table>
                    <tr>
                        <td>E mail</td>
                        <td>
                            <input type="email" id="login-email" placeholder="E mail" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <input type="password" id="login-password" value="" placeholder="Password" required/>
                        </td>
                    </tr>
                </table>
                <button type="submit" name = "login" class="button button-block">Log In</button>
            </form>
        </div>
    </div>

<script src="lib/jquery.js"></script>

<script src="lib/bootstrap/js/bootstrap.min.js"></script>

<script src="loginSignup.js"></script>



</body>

</html>