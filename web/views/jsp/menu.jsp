<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/2/19
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<jsp:include page="boostrap.jsp"></jsp:include>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Case Study</a>
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/about">About</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/profile">Profile</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/addparking">Add Parking</a>
        </li>
    </ul>
    <a href="${pageContext.request.contextPath}/login">Login</a>
    &nbsp&nbsp
    <a href="${pageContext.request.contextPath}/register">Register</a>
</nav>

</body>
</html>
