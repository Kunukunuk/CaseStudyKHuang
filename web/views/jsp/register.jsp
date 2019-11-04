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
<body>
    <div>
        <form:form id="userRegistrationForm" modelAttribute="userRegistrationObj"
                   action="processCredentials" method="post">
            <p> ${message} </p>
            <table>
                <tr>
                    <td><form:label path="user.name" />Name: </td>
                    <td><form:input path="user.name" name= "user.name" id="user.name"/></td>
                    <td><form:errors path="user.name" cssClass="error"/></td>

                </tr>
                <tr>
                    <td><form:label path="username" />Email: </td>
                    <td><form:input path="username" name= "username" id="username"/></td>
                    <td><form:errors path="username" cssClass="error"/></td>

                </tr>
                <tr>
                    <td><form:label path="password" />Password: </td>
                    <td><form:password path="password" name= "password" id="password" placeholder="You Password"/></td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Repeat Password: </label></td>
                    <td><input type="password" name= "confirmPassword" id="password" placeholder="Confirm Password"/></td>
                </tr>
                <tr>
                    <td><form:button name="Login" id="Login">Register</form:button></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
