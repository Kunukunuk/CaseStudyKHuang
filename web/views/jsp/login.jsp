<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/2/19
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="boostrap.jsp"></jsp:include>
</head>
<body class="bg-dark text-white">

<div class="container">
    <div class="row">
        <div class="col-sm-10 offset-sm-1 text-center">
            <form:form action="${pageContext.request.contextPath}/loginAction" method="post" class="justify-content-center">
                    <h1>Login:</h1>
                <div class="form-group">
                    ${message}
                    <label>Username:</label>
                    <input type="text" name="username" class="form-control">
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input type="password" name="password" class="form-control">
                </div>
                <input type="submit" value="submit" name="submit">
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
