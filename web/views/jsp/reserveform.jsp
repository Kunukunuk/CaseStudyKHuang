<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/10/19
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reserve Form</title>
</head>
<body class="bg-dark text-white">
<div id="header">
    <jsp:include page="menu.jsp" />
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-10 offset-sm-1 text-center">
            <form:form id="reserveForm" action="${pageContext.request.contextPath}/reserveParkingAction"
                       modelAttribute="reserveFormObj" method="post">
                <h1>Add Parking:</h1>
                <div class="form-group">
                    <label>Street</label>
                    <form:input type="text" name="street" path="address.street" class="form-control text-center" value="street" />
                    <form:errors path="address.street" />
                </div>
                <div class="form-group">
                    <label>City</label>
                    <form:input type="text" name="city" path="address.city" class="form-control text-center" value="city" />
                    <form:errors path="address.city" />
                </div>
                <div class="form-group">
                    <label>State</label>
                    <form:input type="text" name="state" path="address.state" class="form-control text-center" value="ny" />
                    <form:errors path="address.state" />
                </div>
                <div class="form-group">
                    <label>Zip Code</label>
                    <form:input type="text" name="zip" path="address.zip" class="form-control text-center" value="10000" />
                    <form:errors path="address.zip" />
                </div>
                <div class="form-group">
                    <label>Time Start</label>
                    <form:input type="date" name="availableDate" path="availableDate" class="form-control text-center" value="2019-11-11" />
                    <form:errors path="availableDate" />
                </div>
                <div class="form-group">
                    <label>Time End</label>
                    <form:input type="date" name="endDate" path="endDate" class="form-control text-center" value="2019-11-12" />
                    <form:errors path="endDate" />
                </div>
                <div class="form-group">
                    <label>Length of space</label>
                    <form:input type="number" name="length" path="length" class="form-control text-center" value="12"/>
                    <form:errors path="length" />
                </div>
                <div class="form-group">
                    <label>Width of space</label>
                    <form:input type="number" name="width" path="width" class="form-control text-center" value="12" />
                    <form:errors path="width" />
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <form:input type="number" name="price" path="price" class="form-control text-center" value="12" />
                    <form:errors path="price" />
                </div>

                <button name="addParking" id="addParking">Add</button>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
