<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/3/19
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Parking</title>
</head>
<body class="bg-dark text-white">
<div id="header">
    <jsp:include page="menu.jsp"></jsp:include>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-10 offset-sm-1 text-center">
            <form:form id="parkingForm" action="addParkingAction"
                       modelAttribute="parkingFormObj" method="post">
                <h1>Add Parking:</h1>
                ${message}
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" name="name" class="form-control text-center">
                </div>
                <div class="form-group">
                    <label>Street</label>
                    <input type="text" name="street" class="form-control text-center">
                </div>
                <div class="form-group">
                    <label>City</label>
                    <input type="text" name="city" class="form-control text-center">
                </div>
                <div class="form-group">
                    <label>State</label>
                    <input type="text" name="state" class="form-control text-center">
                </div>
                <div class="form-group">
                    <label>Zip Code</label>
                    <input type="text" name="zipcode" class="form-control text-center">
                </div>
                <div class="form-group">
                    <label>Time Start</label>
                    <input type="date" name="timestart" class="form-control text-center">
                </div>
                <div class="form-group">
                    <label>Time End</label>
                    <input type="date" name="timeend" class="form-control text-center">
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input type="number" name="price" class="form-control text-center">
                </div>
                <input type="submit" value="submit" name="submit">
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
