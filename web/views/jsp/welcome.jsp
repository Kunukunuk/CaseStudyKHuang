<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/2/19
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Screen</title>
</head>
<body>
<div id="header">
    <jsp:include page="menu.jsp"></jsp:include>
</div>
This is the welcome screen
${user.username}

</body>
</html>
