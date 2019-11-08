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
    <jsp:include page="menu.jsp">
        <jsp:param name="name" value="${user.name}"/>
    </jsp:include>
</div>

<div class="container h-100">
    <div class="row">
        <div class="col-sm-10 offset-sm-1 text-center">
            <h1>Welcome to the app</h1>
            ${message}
            <h3>List of parking available:</h3>
            ${noparking}
            <c:if test="${parkings} == null">
                <label>No parking available</label>
            </c:if>
            <c:forEach var="address" items="${addresses}">
                <label>${address.street} ${address.city} ${address.state} ${address.zip}</label>
            </c:forEach>
            <c:forEach var="parking" items="${parkings}">
                <label>${parking.price} ${parking.length} ${parking.width} ${parking.availableDate} ${parking.endDate} ${parking.creationDate}</label>
            </c:forEach>
            <div class="border border-danger">
                mapppp
            </div>
        </div>
    </div>
</div>

</body>
</html>
