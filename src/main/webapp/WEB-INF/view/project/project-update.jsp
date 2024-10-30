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
    <title>HRMS | Project Update</title>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
    <script src="/js/common.js"></script>
    <link href="/css/style.css" rel="stylesheet"/>

    <script>
        $(document).ready(() => {
            const imageFile = $("#projectFile");
            const orgImage = "${project.image}";
            if (orgImage) {
                const urlImage = "/images/project/" + orgImage;
                $("#projectPreview").attr("src", urlImage);
                $("#projectPreview").css({ "display": "block" });
            }

            imageFile.change(function (e) {
                const imgURL = URL.createObjectURL(e.target.files[0]);
                $("#projectPreview").attr("src", imgURL);
                $("#projectPreview").css({ "display": "block" });
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
            <form:form method="post" action="/project/${id}" modelAttribute="project"  enctype="multipart/form-data">
                <div class="detail-div">
                    <div class="detail-box">
                        <div class="">
                            <p class="form-label">Mã số: DA_${id}</p>
                        </div>
                        <div class="">
                            <label for="projectName" class="form-label">Dự án</label>
                            <form:input type="text" class="form-control" id="projectName" path="name"/>
                        </div>
                        <div class="">
                            <label for="projectDescription" class="form-label">Mô tả</label>
                            <form:input type="text" class="form-control" id="projectDescription" path="description"/>
                        </div>
                        <div class="">
                            <label class="form-label">Loại dự án</label>
                            <form:select class="form-select" path="type">
                                <form:option value="Youtube">Youtube</form:option>
                                <form:option value="Youtube">Youtube</form:option>
                                <form:option value="App">App</form:option>
                            </form:select>
                        </div>
                        <div class="">
                            <label for="projectFile" class="form-label">Image:</label>
                            <input class="form-control" type="file" id="projectFile"
                                   accept=".png, .jpg, .jpeg" name="hrmsFile"/>
                        </div>
                    </div>

                    <div class="image-box">
                        <img style="display: none;" alt="project preview"
                             id="projectPreview" class="avatar-user"/>
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