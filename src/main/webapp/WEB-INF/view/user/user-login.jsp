<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HRMS | Add User</title>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
    <script src="/js/common.js"></script>
    <link href="/css/style.css" rel="stylesheet"/>
</head>
<body>
<div id="body-page">
    <div class="body-content user-page user-login-page">
        <div class="body-main">
            <div class="login-div">
                <p class="login-title">Human Resource Management System</p>
                <div class="login-box">
                    <form>
                        <div class="">
                            <input class="form-control" id="inputEmail" type="email" placeholder="name@example.com" />
                        </div>
                        <div class="">
                            <input class="form-control" id="inputPassword" type="password" placeholder="Password" />
                        </div>
                        <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                            <a class="button button-login" href="index.html">Đăng nhập</a>
                        </div>
                    </form>
                </div>
            </div>
            <img src="../images/common/background_1.webp" alt="">
        </div>
    </div>
</div>
</body>
</html>