<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HRMS | User List</title>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
    <script src="/js/common.js"></script>
    <link href="/css/style.css" rel="stylesheet"/>
</head>
<body>
<div id="body-page">
    <jsp:include page="../layout/nav.jsp"/>
    <div class="body-content user-page user-list-page">
        <div class="header-main">
            <p class="header-title">Danh sách nhân sự</p>
            <a href="/user/create" class="button">Thêm mới</a>
        </div>
        <div class="body-main">
            <table>
                <tr>
                    <th class="header-title">Mã</th>
                    <th class="header-title">Nhân sự</th>
                    <th class="header-title">Chức vụ</th>
                    <th class="header-title">SL Dự án</th>
                    <th class="header-title">T - Mới</th>
                    <th class="header-title">T - Tiến hành</th>
                    <th class="header-title">T - Hoàn thành</th>
                    <th class="header-title">Ngày công</th>
                    <th class="header-title">Lựa chọn</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>NS_${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.role.name}</td>
                        <td>t1</td>
                        <td>t1</td>
                        <td>t1</td>
                        <td>t1</td>
                        <td>t1</td>
                        <td>
                            <a href="/user/${user.id}"><i class="fa-solid fa-magnifying-glass"></i></a>
                            <a href="/user/${user.id}/update"><i class="fa-solid fa-pen-to-square"></i></a>
                            <a href="/user/${user.id}/delete"><i class="fa-solid fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>