<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HRMS | Chi tiết dự án</title>

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
            <a href="/project/list" class="button">Trở về</a>
        </div>
        <div class="body-main">
            <div class="detail-div">
                <div class="detail-box">
                    <p>Kênh phát triển: ${project.type}</p>
                    <p>Dự án: ${project.name}</p>
                    <p>Mô tả: ${project.description}</p>
                    <p>Số nhân sự: ${countUser}</p>
                    <p>SL chủ đề nội dung: ${countContentTopic}</p>
                    <p>SL công việc còn:</p>
                </div>

                <div class="image-box">
                    <img src="../images/project/${project.image}" alt="" class="avatar-user">
                </div>
            </div>
            <div class="button-box">
                <a href="/project/${project.id}/update" class="button button-edit">Chỉnh sửa</a>
                <a href="/project/${project.id}/add_user" class="button button-edit">Thêm nhân sự</a>
                <a href="/project/${project.id}/add_content_topic" class="button button-edit">Thêm chủ đề</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>