<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/2/19
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<jsp:include page="boostrap.jsp"></jsp:include>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Parking</a>
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/about">About</a>
        </li>
        <c:if test="${pageContext.request.userPrincipal != null}">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/profile">Profile</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/addparking">Add Parking</a>
        </li>
        </c:if>
    </ul>
    <c:if test="${pageContext.request.userPrincipal == null}">
    <a href="${pageContext.request.contextPath}/login">Login</a>
    &nbsp&nbsp
    <a href="${pageContext.request.contextPath}/register">Register</a>
    </c:if>

    <c:if test="${pageContext.request.userPrincipal != null}">
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
        &nbsp&nbsp
        <a href="#">${param.name}</a>
    </c:if>

</nav>

</body>
</html>
