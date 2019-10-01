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
    <title>Home</title>
</head>
<body>
<h1>Hello World</h1>

<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Action</th>
        <th>Time</th>
    </tr>
    <c:forEach var="user" items="${todolists}">
        <tr>
            <td>${user.id}</td>
            <td>${user.title}</td>
            <td>${user.description}</td>
            <td>${user.action}</td>
            <td>${user.time}</td>
        </tr>
    </c:forEach>
</table>

<form action="/SoftServe_war_exploded/home" method="post">
    <input type="text" name="title" placeholder="Title">
    <input type="text" name="description" placeholder="Description">
    <input type="text" name="action" placeholder="Action">
    <button type="submit">Add</button>

</form>


</body>
</html>
