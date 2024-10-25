<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HRMS | Project Detail</title>

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
    <div class="body-content user-page user-detail-page">
        <div class="header-main">
            <p class="header-title">Thông tin chi tiết</p>
            <a href="/user/list" class="button">Trở về</a>
        </div>
        <div class="body-main">
            <div class="detail-div">
                <div class="detail-box">
                    <p>Nhân sự: ${user.name}</p>
                    <p>Mail: ${user.email}</p>
                    <p>Số điện thoại: ${user.phone}</p>
                    <p>Chức vụ: ${user.role.name}</p>
                    <p>Số dự án: 3</p>
                    <p>Số ngày công: 20/24</p>
                    <p>Số ngày nghỉ phép còn: 5</p>
                </div>

                <div class="image-box">
                    <img src="../images/avatar/${user.avatar}" alt="" class="avatar-user">
                </div>
            </div>
            <div class="button-box">
                <a href="/user/update/${user.id}" class="button button-edit">Chỉnh sửa</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>