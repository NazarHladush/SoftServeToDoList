<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 07.10.2019
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#">To Do List</a>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">LogIn</button>
            </form>
        </div>
    </nav>
</header>

<input type="text" id="name">
<input type="text" id="sname">
<button onclick="MyFunc()">Submit</button>
<button onclick="sendRequest()">post</button>
<button onclick="sendRequest2()">put</button>

</body>
</html>
<script>
    function MyFunc() {
        var a = document.getElementById('name').value;
        var b = document.getElementById('sname').value;
        alert("200");
        console.log(b);
    }
    function sendRequest(){
        $.ajax({
                url: '/SoftServe_war_exploded/test',
                data: {name:"nazar", sname:"hladysh"},
                type: 'post',
                cache: false,
                success: function () {
                    alert("ok");
                },
                error: function () {
                    alert('error');
                }
            }
        )
    }

    function sendRequest2(){
        $.ajax({
                url: '/SoftServe_war_exploded/test',
                data: {name:"nazar", sname:"hladysh"},
                type: 'delete',
                cache: false,
                success: function () {
                    alert("ok");
                },
                error: function () {
                    alert('error');
                }
            }
        )
    }

</script>
