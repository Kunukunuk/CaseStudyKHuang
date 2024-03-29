<%--
  Created by IntelliJ IDEA.
  User: kunhuang
  Date: 11/10/19
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <h1>Reserve Parking:</h1>
                ${message}
                <div class="form-group">
                    <form:select path="payment.cardType">
                        <form:option value="visa">Visa</form:option>
                        <form:option value="discover">Discover</form:option>
                        <form:option value="mastercard">MasterCard</form:option>
                        <form:option value="americanexpress">American Express</form:option>
                    </form:select>
                </div>
                <div class="form-group">
                    <form:label path="payment.nameOnCard">Name</form:label>
                    <form:input type="text" name="name" path="payment.nameOnCard" class="form-control text-center" value="city" />
                    <form:errors path="payment.nameOnCard" />
                </div>
                <div class="form-group">
                    <form:label path="payment.cardNumber">Credit Card Number</form:label>
                    <form:input type="text" name="cardnumber" path="payment.cardNumber" class="form-control text-center" value="ny" />
                    <form:errors path="payment.cardNumber" />
                </div>
                <div class="form-group">
                    <form:label path="payment.price">Price: ${parking.price}</form:label>
                    <form:input type="hidden" name="price" path="payment.price" class="form-control text-center" value="${parking.price}" />
                </div>

                <button name="reserveParking" id="reserveParking" disabled>Reserve(Coming Soon)</button>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
