<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HRMS | Thông tin chủ đề</title>

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
            <a href="/project/${project.id}/content_topic/list" class="button">Trở về</a>
        </div>
        <div class="body-main">
            <div class="detail-div">
                <div class="detail-box">
                    <p>Dự án: DA_${project.name}</p>
                    <p>Chủ đề: ${contentTopic.name}</p>
                    <p>Mô tả: ${contentTopic.description}</p>
                    <p>Trạng thái: ${contentTopic.contentTopicStatus.name}</p>
                    <p>Url 1: ${contentTopic.url_1}</p>
                    <p>Url 2: ${contentTopic.url_2}</p>
                    <p>Url 3: ${contentTopic.url_3}</p>
                    <p>SL nội dung:</p>
                </div>

                <div class="image-box">
                    <img src="/images/content/${contentTopic.image}" alt="" class="avatar-user">
                </div>
            </div>
            <div class="button-box">
                <a href="/project/${project.id}/update" class="button button-edit">Chỉnh sửa</a>
                <a href="/project/${project.id}/add_user" class="button button-edit">Thêm người vào dự án</a>
                <a href="/project/${project.id}/add_content_section" class="button button-edit">Thêm tập</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>