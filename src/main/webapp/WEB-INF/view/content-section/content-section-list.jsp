<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HRMS | Danh sách chủ đề</title>

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
            <p class="header-title">Danh sách dự án</p>
            <a href="/project/create" class="button">Thêm mới</a>
        </div>
        <div class="body-main">
            <table>
                <tr>
                    <th class="header-title">Chủ đề</th>
                    <th class="header-title">Mô tả</th>
                    <th class="header-title">Trạng thái</th>
                    <th class="header-title">Url 1</th>
                    <th class="header-title">Url 2</th>
                    <th class="header-title">Url 3</th>
                    <th class="header-title">SL nội dung</th>
                    <th class="header-title">Lựa chọn</th>
                </tr>
                <c:forEach items="${contentTopics}" var="contentTopic">
                    <tr>
                        <td>CT_${contentTopic.name}</td>
                        <td>${contentTopic.description}</td>
                        <td>${contentTopic.status}</td>
                        <td>${contentTopic.url_1}</td>
                        <td>${contentTopic.url_2}</td>
                        <td>${contentTopic.url_3}</td>
                        <td>6</td>
                        <td>
                            <a href="/project/${contentTopic.id}"><i class="fa-solid fa-magnifying-glass"></i></a>
                            <a href="/project/${project.id}/content_topic/${contentTopic.id}/update"><i class="fa-solid fa-pen-to-square"></i></a>
                            <a href="/project/${project.id}/content_topic/${contentTopic.id}/delete"><i class="fa-solid fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>