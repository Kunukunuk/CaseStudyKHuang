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
<style type=text/css>
    .error {
        color: red;
        font-size: small;
    }
</style>
<body class="bg-dark text-white">
<div id="header">
    <jsp:include page="menu.jsp"></jsp:include>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-10 offset-sm-1 text-center">
            <form:form id="userRegistrationForm" action="processCredentials"
                  modelAttribute="userRegistrationObj" method="post" class="justify-content-center">
                <h1>Register An Account</h1>
                ${message}
                <div class="form-group">
                    <form:label path="user.name">First and Last Name:</form:label>
                    <form:input type="text" name="user.name" path="user.name" class="form-control text-center" id="user.name" />
                    <form:errors path="user.name" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="username">Username(email):</form:label>
                    <form:input type="text" name="username" path="username" class="form-control text-center" id="username" />
                    <form:errors path="username" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="password">Password:</form:label>
                    <form:input type="password" name="password" path="password" class="form-control text-center" id="password" />
                    <form:errors path="password" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label>Repeat Password:</label>
                    <input type="password" name="confirmPassword" class="form-control text-center" id="confirmPassword">
                </div>
                <button name="Login" id="Login">Register</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
