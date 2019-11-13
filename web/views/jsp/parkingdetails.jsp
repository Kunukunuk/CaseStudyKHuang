<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/8/19
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parking Details</title>
</head>
<body class="bg-dark text-white">
<div id="header">
    <jsp:include page="menu.jsp" />
</div>
<div class="container h-100">
    <div class="row">
        <div class="col-sm-10 offset-sm-1 text-center">
            <h1>Parking Details</h1>
            <h3>${address.street} ${address.city} ${address.state} ${address.zip}:</h3>
            <table class="table table-dark table-bordered text-center">
                <tbody>
                <c:forEach var="parking" items="${parkings}">
                    <tr>
                        <th scope="row">create time:</th>
                        <td>${parking.creationDate}</td>
                    </tr>
                    <tr>
                        <th scope="row">available from:</th>
                        <td>${parking.availableDate}</td>
                    </tr>
                    <tr>
                        <th scope="row">end date:</th>
                        <td>${parking.endDate}</td>
                    </tr>
                    <tr>
                        <th scope="row">size:</th>
                        <td>${parking.length} x ${parking.width}</td>
                    </tr>
                    <tr>
                        <th scope="row">price:</th>
                        <td>${parking.price}</td>
                    </tr>
                    <tr>
                        <c:if test="${pageContext.request.userPrincipal != null}" >
                        <td colspan="2"><a href="${pageContext.request.contextPath}/reserveform">Reserve</a></td>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal == null}" >
                            <td colspan="2"><a href="${pageContext.request.contextPath}/login">Login</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
