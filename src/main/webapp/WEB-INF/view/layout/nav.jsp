<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="nav">
    <p class="nav-title">HRMS</p>
    <div class="nav-menu-div">
        <ul class="nav-menu">
            <li class="nav-menu" btn="user-private"><a href="/user/{id}" class="user-private">Cá nhân</a></li>
            <li class="nav-menu" btn="user-list"><a href="/user/list" class="user-list">Nhân sự</a></li>
            <li class="nav-menu" btn="user-private"><a href="/project/list">Dự án</a></li>
            <li class="nav-menu" btn="user-private"><a href="">Công việc</a></li>
            <li class="nav-menu" btn="user-private"><a href="">Lịch</a></li>
        </ul>
    </div>
    <a href="" class="logout">Đăng xuất</a>
</nav>