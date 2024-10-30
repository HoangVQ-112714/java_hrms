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
    <title>HRMS | Add User For Project</title>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
    <script src="/js/common.js"></script>
    <link href="/css/style.css" rel="stylesheet"/>

    <script>
        $(document).ready(() => {
            const avatarFile = $("#projectFile");

            avatarFile.change(function (e) {
                const imgURL = URL.createObjectURL(e.target.files[0]);
                $("#projectPreview").attr("src", imgURL);
                $("#projectPreview").css({"display": "block"});
            });
        });
    </script>
</head>
<body>
<div id="body-page">
    <jsp:include page="../layout/nav.jsp"/>
    <div class="body-content project-page project-create-page">
        <div class="header-main">
            <p class="header-title">Thêm dự nhân sự án mới</p>
            <a href="/project/list" class="button">Trở về</a>
        </div>
        <div class="body-main">
            <form:form method="post" action="/project/list" modelAttribute="projectAddUser" class="form-user form-add-user">
                <div class="detail-div">
                    <div class="detail-box">
                        <div class="">
                            <p>Kênh phát triển: ${project.type}</p>
                            <p>Dự án: ${project.name}</p>
                            <p>Mô tả: ${project.description}</p>
                        </div>
                        <div class="">
                            <label for="projectDescription" class="form-label">Mô tả</label>
                            <form:input type="text" class="form-control" id="projectDescription" path="description"/>
                        </div>
<%--                        <div class="">--%>
<%--                            <label class="form-label">Loại dự án</label>--%>
<%--                            <form:select class="form-select" path="type">--%>
<%--                                <form:option value="Youtube">Youtube</form:option>--%>
<%--                                <form:option value="Website">Website</form:option>--%>
<%--                                <form:option value="App">App</form:option>--%>
<%--                            </form:select>--%>
<%--                        </div>--%>
                    </div>
                </div>

                <div class="button-box">
                    <button type="submit" class="button button-edit">Thêm người</button>
                </div>
            </form:form>

        </div>
    </div>
</div>
</body>
</html>