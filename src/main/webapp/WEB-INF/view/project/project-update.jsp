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
            const avatarFile = $("#avatarFile");
            const orgImage = "${user.avatar}";
            if (orgImage) {
                const urlImage = "/images/avatar/" + orgImage;
                $("#avatarPreview").attr("src", urlImage);
                $("#avatarPreview").css({ "display": "block" });
            }

            avatarFile.change(function (e) {
                const imgURL = URL.createObjectURL(e.target.files[0]);
                $("#avatarPreview").attr("src", imgURL);
                $("#avatarPreview").css({ "display": "block" });
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
            <a href="/user/list" class="button">Trở về</a>
        </div>
        <div class="body-main">
            <form:form method="post" action="/user/${id}" modelAttribute="user"  enctype="multipart/form-data">
                <div class="detail-div">
                    <div class="detail-box">
                        <div class="">
                            <p class="form-label">Mã số: MS_000${id}</p>
                        </div>
                        <div class="">
                            <label for="userName" class="form-label">Người dùng</label>
                            <form:input type="text" class="form-control" id="userName" path="name"/>
                        </div>
                        <div class="">
                            <label for="userMail" class="form-label">Email</label>
                            <form:input type="email" class="form-control" id="userMail" path="email"/>
                        </div>
                        <div class="">
                            <label for="userPhone" class="form-label">Số điện thoại</label>
                            <form:input type="tel" class="form-control" id="userPhone" path="phone"/>
                        </div>
                        <div class="">
                            <label for="userPass" class="form-label">Mật khẩu</label>
                            <form:input type="text" class="form-control" id="userPass" path="password"/>
                        </div>
                        <div class="">
                            <label class="form-label">Trạng thái</label>
                            <form:select class="form-select" path="status">
                                <form:option value="Active">Active</form:option>
                                <form:option value="Block">Block</form:option>
                            </form:select>
                        </div>
                        <div class="">
                            <label class="form-label">Role</label>
                            <form:select class="form-select" path="role.name">
                                <form:option value="Admin">Admin</form:option>
                                <form:option value="Leader">Leader</form:option>
                                <form:option value="Member">Member</form:option>
                            </form:select>
                        </div>
                        <div class="">
                            <label for="avatarFile" class="form-label">Image:</label>
                            <input class="form-control" type="file" id="avatarFile"
                                   accept=".png, .jpg, .jpeg" name="hrmsFile"/>
                        </div>
                    </div>

                    <div class="image-box">
                        <img style="display: none;" alt="avatar preview"
                             id="avatarPreview" class="avatar-user"/>
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