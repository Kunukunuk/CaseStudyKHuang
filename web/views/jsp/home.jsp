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
            <c:if test="${addresses == null}">
                <label>No parking available</label>
            </c:if>
            <c:if test="${addresses.size() != null}" >
                <h3>List of parking available:</h3>
            <table class="table table-dark table-striped table-bordered table-hover text-center">
                <thread>
                    <tr>
                        <th scope="col">Address</th>
                        <th scope="col">Number Of Parking's</th>
                    </tr>
                </thread>
                <tbody>
                <c:forEach var="address" items="${addresses}">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/parkingdetails?aid=${address.AID}">
                                ${address.street} ${address.city} ${address.state} ${address.zip}
                        </a></td>
                        <td>${address.parking.size()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
