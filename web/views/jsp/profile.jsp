<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/3/19
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile Page</title>
</head>
<body class="bg-dark text-white">
<div id="header">
    <jsp:include page="menu.jsp"></jsp:include>
</div>

<div class="container h-100">
    <div class="row">
        <div class="col-sm-10 offset-sm-1 text-center">
            <h1>Profile Page</h1>
            <br>
            Name: ${user.user.name}
            <br>
            Email: ${user.username}
            <br>
        </div>

    </div>

</div>

</body>
</html>
