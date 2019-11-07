<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/1/19
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<%--p-3 mb-2--%>
<body class="bg-dark text-white">
<div id="header">
    <jsp:include page="menu.jsp"></jsp:include>
</div>

<div class="container h-100">
    <div class="row">
        <div class="col-sm-10 offset-sm-1 text-center">
            <h1>Welcome to the app</h1>

            <h3>List of parking available:</h3>
            <c:if test="${parkings} == null">
                <label>No parking available</label>
            </c:if>
            <c:forEach var="parking" items="${parkings}">
                <label>${parking}</label>
            </c:forEach>
            <div class="border border-danger">
                mapppp
            </div>
        </div>
    </div>
</div>

</body>
</html>
