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
</head>
<body>
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
