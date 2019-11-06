<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/3/19
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body class="bg-dark text-white">
<div id="header">
    <jsp:include page="menu.jsp"></jsp:include>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-10 offset-sm-1 text-center">
            <form id="userRegistrationForm" action="processCredentials"
                  modelAttribute="userRegistrationObj" method="post" class="justify-content-center">
                <h1>Register An Account</h1>
                ${message}
                <div class="form-group">
                    <label path="user.name">Name:</label>
                    <input type="text" name="user.name" class="form-control" id="user.name">
                </div>
                <div class="form-group">
                    <label path="username">Username:</label>
                    <input type="text" name="username" class="form-control" id="username">
                </div>
                <div class="form-group">
                    <label path="password">Password:</label>
                    <input type="text" name="password" class="form-control" id="password">
                </div>
                <div class="form-group">
                    <label>Repeat Password:</label>
                    <input type="password" name="confirmPassword" class="form-control" id="confirmPassword">
                </div>
                <button name="Login" id="Login">Register</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
