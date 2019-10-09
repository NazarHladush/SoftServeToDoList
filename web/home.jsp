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
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<a href="/SoftServe_war_exploded/logout"><input class="btn" type="button" value="LogOut"></a>
<form action="/SoftServe_war_exploded/home" method="post" class="d-flex justify-content-center">
    <input type="text" name="title" placeholder="Title" required>
    <input type="text" name="description" placeholder="Description" required>
    <input type="datetime-local" name="datetime" required>
    <button type="submit" class="btn btn-light">Add</button>
</form>
<div class="d-flex justify-content-center">
    <table class="table table-striped">
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Action</th>
            <th scope="col">Time</th>
            <th scope="col"></th>
        </tr>
        <c:forEach var="user" items="${todolists}">
            <tr>
                <td scope="row">${user.title}</td>
                <td scope="row">${user.description}</td>
                <td scope="row">${user.action}</td>
                <td scope="row">${user.time}</td>
                <td scope="row"><input class="btn btn-danger" type="button" onclick="deleteTodo(${user.id})"
                                       value="Delete"></td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
<script>
    // function deleteItem(id) {
    //     var url = "http://localhost:8090/SoftServe_war_exploded/home/delete/";
    //     var xhr = new XMLHttpRequest();
    //     xhr.open("DELETE", url + id);
    //     xhr.onload = function () {
    //         if (xhr.readyState == 4 && xhr.status == "200") {
    //             // alert("200");
    //             document.location.reload();
    //         } else {
    //             console.error("error");
    //         }
    //     }
    //     xhr.send(null);
    // }

    function deleteTodo(id) {
        $.ajax({
                url: '/SoftServe_war_exploded/home/delete'+id,
                // data: {name:"id"},
                type: 'delete',
                cache: false,
                success: function () {
                    document.location.reload();
                },
                error: function () {
                    alert('error');
                }
            }
        )
    }
</script>

