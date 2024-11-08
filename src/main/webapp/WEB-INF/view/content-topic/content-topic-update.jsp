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
    <title>HRMS | Cập nhật chủ đề</title>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
    <script src="/js/common.js"></script>
    <link href="/css/style.css" rel="stylesheet"/>

    <script>
        $(document).ready(() => {
            const imageFile = $("#contentTopicFile");
            const orgImage = "${contentTopic.image}";
            if (orgImage) {
                const urlImage = "/images/content/" + orgImage;
                $("#contentTopicPreview").attr("src", urlImage);
                $("#contentTopicPreview").css({"display": "block"});
            }

            imageFile.change(function (e) {
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
    <div class="body-content user-page user-update-page">
        <div class="header-main">
            <p class="header-title">Chỉnh sửa thông tin</p>
            <a href="/project/list" class="button">Trở về</a>
        </div>
        <div class="body-main">
            <form:form method="post" action="/project/${project.id}/content_topic/${contentTopic.id}/update/post"
                       modelAttribute="contentTopic" enctype="multipart/form-data">
                <div class="detail-div">
                    <div class="detail-box">
                        <div class="" style="display:none">
                            <form:input type="text" class="form-control" id="contentTopicName" path="id"/>
                        </div>
                        <div class="">
                            <p class="form-label">Dự án: ${project.name}</p>
                        </div>
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
                            <label for="contentTopicUrl_1" class="form-label">Đường dẫn 1</label>
                            <form:input type="text" class="form-control" id="contentTopicUrl_1" path="url_1"/>
                        </div>
                        <div class="">
                            <label for="contentTopicUrl_2" class="form-label">Đường dẫn 2</label>
                            <form:input type="text" class="form-control" id="contentTopicUrl_2" path="url_2"/>
                        </div>
                        <div class="">
                            <label for="contentTopicUrl_3" class="form-label">Đường dẫn 3</label>
                            <form:input type="text" class="form-control" id="contentTopicUrl_3" path="url_3"/>
                        </div>
                        <div class="">
                            <label class="form-label">Trạng thái</label>
                            <form:select class="form-select status-form" path="contentTopicStatus.name">
                                <form:option value="Hoạt động">Hoạt động</form:option>
                                <form:option value="Chờ chap">Chờ chap</form:option>
                                <form:option value="Hết season">Hết season</form:option>
                                <form:option value="Tạm dừng">Tạm dừng</form:option>
                                <form:option value="Kết thúc">Kết thúc</form:option>
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
                    <button type="submit" class="button button-edit">Cập nhật</button>
                </div>
            </form:form></div>
    </div>
</div>
</div>
</body>
</html>