<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/8/19
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
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
<%--            <h3>${address.street} ${address.city} ${address.state} ${address.zip}:</h3>--%>
            <table class="table table-dark table-bordered table-hover text-center">
<%--                <thread>--%>
<%--                    <tr>--%>
<%--                        <th scope="col">Parking Details</th>--%>
<%--                    </tr>--%>
<%--                </thread>--%>
                <tbody>
                <tr>
                    <th scope="row">create time:</th>
                </tr>
                <tr>
                    <th scope="row">available from:</th>
                </tr>
                <tr>
                    <th scope="row">end date:</th>
                </tr>
                <tr>
                    <th scope="row">size:</th>
                </tr>
                <tr>
                    <th scope="row">price:</th>
                </tr>
<%--                <c:forEach var="address" items="${addresses}">--%>
<%--                    <tr>--%>
<%--                        <th scope="row"></th>--%>
<%--                        <td><a href="${pageContext.request.contextPath}/parkingdetails">--%>
<%--                                ${address.street} ${address.city} ${address.state} ${address.zip}--%>
<%--                        </a></td>--%>
<%--                        <td>${address.parking.size()}</td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
