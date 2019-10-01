<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 28.09.2019
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Hello World</h1>
$END$

<table>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Password</th>
        <th>First Name</th>
        <th>Second Name</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.firstName}</td>
            <td>${user.secondName}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
