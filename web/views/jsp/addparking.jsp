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
<style type=text/css>
    .error {
        color: red;
        font-size: small;
    }
</style>
<body class="bg-dark text-white">
<div id="header">
    <jsp:include page="menu.jsp"></jsp:include>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-10 offset-sm-1 text-center">
            <form:form id="parkingFormObj" action="${pageContext.request.contextPath}/addressParkingAction"
                       modelAttribute="parkingFormObj" method="post">
                <h1>Add Parking:</h1>
                ${message}
                <div class="form-group">
                    <form:label path="address.street">Street</form:label>
                    <form:input type="text" name="street" path="address.street" class="form-control text-center" value="street" />
                    <form:errors path="address.street" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="address.city">City</form:label>
                    <form:input type="text" name="city" path="address.city" class="form-control text-center" value="city" />
                    <form:errors path="address.city" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="address.state">State</form:label>
                    <form:input type="text" name="state" path="address.state" class="form-control text-center" value="ny" />
                    <form:errors path="address.state" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="address.zip">Zip Code</form:label>
                    <form:input type="text" name="zip" path="address.zip" class="form-control text-center" value="10000" />
                    <form:errors path="address.zip" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="availableDate">Time Start</form:label>
                    <form:input type="date" name="availableDate" path="availableDate" class="form-control text-center" value="2019-11-11" />
                    <form:errors path="availableDate" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="endDate">Time End</form:label>
                    <form:input type="date" name="endDate" path="endDate" class="form-control text-center" value="2019-11-12" />
                    <form:errors path="endDate" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="length">Length of space</form:label>
                    <form:input type="number" name="length" path="length" class="form-control text-center" value="12"/>
                    <form:errors path="length" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="width">Width of space</form:label>
                    <form:input type="number" name="width" path="width" class="form-control text-center" value="12" />
                    <form:errors path="width" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="price">Price</form:label>
                    <form:input type="number" name="price" path="price" class="form-control text-center" value="12" />
                    <form:errors path="price" cssClass="error"/>
                </div>

                <button name="addParking" id="addParking">Add</button>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
