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
    <title>HRMS | Thêm chủ đề</title>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
    <script src="/js/common.js"></script>
    <link href="/css/style.css" rel="stylesheet"/>

    <script>
        $(document).ready(() => {
            const avatarFile = $("#contentTopicFile");

            avatarFile.change(function (e) {
                const imgURL = URL.createObjectURL(e.target.files[0]);
                $("#contentTopicPreview").attr("src", imgURL);
                $("#contentTopicPreview").css({"display": "block"});
            });
        });
    </script>
</head>
<body>
<div id="body-page">
    <jsp:include page="../layout/nav.jsp"/>
    <div class="body-content project-page project-create-page">
        <div class="header-main">
            <p class="header-title">Thêm chủ đề</p>
            <a href="/project/list" class="button">Trở về</a>
        </div>
        <div class="body-main">
            <form:form method="post" action="/project/list" modelAttribute="newContentTopic"
                       class="form-user form-add-user" enctype="multipart/form-data">
                <div class="detail-div">
                    <div class="detail-box">
                        <div class="">
                            <label for="contentTopicName" class="form-label">Chủ đề</label>
                            <form:input type="text" class="form-control" id="contentTopicName" path="name"/>
                        </div>
                        <div class="">
                            <label for="contentTopicDescription" class="form-label">Mô tả</label>
                            <form:input type="text" class="form-control" id="contentTopicDescription"
                                        path="description"/>
                        </div>
                        <div class="">
                            <label for="contentTopicUrl1" class="form-label">Đường dẫn 1</label>
                            <form:input type="text" class="form-control" id="contentTopicUrl1" path="url_1"/>
                        </div>
                        <div class="">
                            <label for="contentTopicUrl2" class="form-label">Đường dẫn 2</label>
                            <form:input type="text" class="form-control" id="contentTopicUrl2" path="url_2"/>
                        </div>
                        <div class="">
                            <label for="contentTopicUrl3" class="form-label">Đường dẫn 3</label>
                            <form:input type="text" class="form-control" id="contentTopicUrl3" path="url_3"/>
                        </div>
                        <div class="">
                            <label class="form-label">Trạng thái</label>
                            <form:select class="form-select" path="status">
                                <form:option value="1">Hoạt động</form:option>
                                <form:option value="2">Chờ chap</form:option>
                                <form:option value="3">Hết season</form:option>
                                <form:option value="4">Tạm dừng</form:option>
                                <form:option value="0">Kết thúc</form:option>
                            </form:select>
                        </div>
                        <div class="">
                            <label for="contentTopicFile" class="form-label">Image:</label>
                            <input class="form-control" type="file" id="contentTopicFile"
                                   accept=".png, .jpg, .jpeg" name="hrmsFile"/>
                        </div>
                    </div>

                    <div class="image-box">
                        <img style="display: none;" alt="project preview"
                             id="contentTopicPreview" class="avatar-user"/>
                    </div>
                </div>

                <div class="button-box">
                    <button type="submit" class="button button-edit">Tạo mới</button>
                </div>
            </form:form>

        </div>
    </div>
</div>
</body>
</html>