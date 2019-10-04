<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 28.09.2019
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style><%@include file="/WEB-INF/css/styles.css"%></style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="text-center">
<%--    <h1>Login</h1>--%>

<form class="form-signin" action="/SoftServe_war_exploded/registration" method="post">
    <h1 class="h3 mb-3 font-weight-normal">Please sign up</h1>

    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" name="loginname" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
    <label for="inputFirstName" class="sr-only">First Name</label>
    <input type="text" name="firstName" id="inputFirstName" class="form-control" placeholder="First Name" required>
    <label for="inputSecondName" class="sr-only">Second Name</label>
    <input type="text" name="secondName" id="inputSecondName" class="form-control" placeholder="Second Name" required>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
    <p>Have an account? <a href="/SoftServe_war_exploded/login">Sign in</a></p>
    <p style="color: red;">${error}</p>
</form>

</body>
</html>
