<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HRMS | NS của dự án</title>

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
    <div class="body-content project-page project-list-page">
        <div class="header-main">
            <p class="header-title">${project.type} - Nhân sự dự án ${project.name}</p>
            <a href="/project/${project.id}/add_user" class="button">Thêm nhân sự</a>
        </div>
        <div class="body-main">
            <table>
                <tr>
                    <th class="header-title">Mã</th>
                    <th class="header-title">Nhân sự</th>
                    <th class="header-title">Lựa chọn</th>
                </tr>
                <c:forEach items="${usersByProject}" var="userByProject">
                    <tr>
                        <td>NS_${userByProject.id}</td>
                        <td>${userByProject.name}</td>
                        <td>
                            <a href="/project/${project.id}"><i class="fa-solid fa-magnifying-glass"></i></a>
                            <a href="/project/${project.id}/delete_user/${userByProject.id}"><i class="fa-solid fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>