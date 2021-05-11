<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/05/2021
  Time: 3:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<div class="w3-container">

    <table class="w3-table w3-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Brand</th>
            <th>Description</th>
        </tr>
        <c:forEach var="p" items="${requestScope.phones}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.brand}</td>
                <td>${p.description}</td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>
