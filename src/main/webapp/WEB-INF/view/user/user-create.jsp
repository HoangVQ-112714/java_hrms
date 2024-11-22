<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HRMS | Add User</title>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
    <script src="/js/common.js"></script>
    <link href="/css/style.css" rel="stylesheet"/>
</head>
<body>
<div id="body-page">
    <jsp:include page="../layout/nav.jsp"/>
    <div class="body-content user-page user-create-page">
        <div class="header-main">
            <p class="header-title">Thêm nhân sự mới</p>
            <a href="/user/list" class="button">Trở về</a>
        </div>
        <div class="body-main">
            <form:form method="post" action="/user/list" modelAttribute="newUser" class="form-user form-add-user">
                <div class="">
                    <label for="userName" class="form-label">Người dùng</label>
                    <form:input type="text" class="form-control" id="userName" path="name"/>
                </div>
                <div class="">
                    <label for="userMail" class="form-label">Email</label>
                    <form:input type="email" class="form-control" id="userMail" path="email"/>
                </div>
                <div class="">
                    <label for="userPhone" class="form-label">Số điện thoại</label>
                    <form:input type="tel" class="form-control" id="userPhone" path="phone"/>
                </div>

                <div class="">
                    <label class="form-label">Role</label>
                    <form:select class="form-select" path="role.name">
                        <c:forEach items="${roles}" var="role">
                            <form:option value="${role.name}">${role.name}</form:option>
                        </c:forEach>
                    </form:select>
                </div>

                <div class="">
                    <label for="userPass" class="form-label">Password</label>
                    <form:input type="text" class="form-control" id="userPass" path="password"/>
                </div>

                <div class="submit-div">
                    <button type="submit" class="button">Tạo mới</button>
                </div>
            </form:form>

        </div>
    </div>
</div>
</body>
</html>