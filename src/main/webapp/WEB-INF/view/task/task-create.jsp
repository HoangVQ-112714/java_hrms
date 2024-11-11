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
    <script src="/js/task.js"></script>
    <link href="/css/style.css" rel="stylesheet"/>
</head>
<body>
<div id="body-page">
    <jsp:include page="../layout/nav.jsp"/>
    <div class="body-content task-page task-create-page">
        <div class="header-main">
            <p class="header-title">Thêm chủ đề</p>
            <a href="/task/list" class="button">Trở về</a>
        </div>
        <div class="body-main">
            <form:form method="post" action="/task/create/post" modelAttribute="newTask"
                       class="form-user form-add-user">
                <div class="detail-div">
                    <div class="detail-box">
                        <div class="detail-box-1">
                            <div class="">
                                <label for="taskTitle" class="form-label">Chủ đề</label>
                                <form:input type="text" class="form-control" id="taskTitle" path="title"/>
                            </div>
                            <div class="">
                                <label for="taskDescription" class="form-label">Mô tả</label>
                                <form:input type="text" class="form-control" id="taskDescription" path="description"/>
                            </div>
                            <div class="">
                                <label class="form-label">Trạng thái</label>
                                <form:select class="form-select" path="taskStatus.status">
                                    <c:forEach items="${arrTaskStatus}" var="taskStatus">
                                        <form:option value="${taskStatus.id}">${taskStatus.status}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="">
                                <label class="form-label">Người tạo</label>
                                <form:select class="form-select" path="created_user_id" id="created_user_id">
                                    <c:forEach items="${arrUser}" var="user">
                                        <form:option value="${user.id}">${user.name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="">
                                <label class="form-label">Người làm</label>
                                <form:select class="form-select" path="assigned_user_id" id="assigned_user_id">
                                    <c:forEach items="${arrUser}" var="user">
                                        <form:option value="${user.id}">${user.name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="">
                                <label class="form-label">Mức độ ưu tiên</label>
                                <form:select class="form-select" path="taskPriority.priority" id="taskPriority">
                                    <c:forEach items="${arrTaskPriority}" var="taskPriority">
                                        <form:option value="${taskPriority.id}">${taskPriority.priority}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="detail-box-2">
                            <div class="">
                                <label for="taskStartDate" class="form-label">Ngày bắt đầu</label>
                                <form:input type="date" class="form-control" id="taskStartDate" path="start_date"/>
                            </div>
                            <div class="">
                                <label for="taskDueDate" class="form-label">Hạn hoàn thành</label>
                                <form:input type="date" class="form-control" id="taskDueDate" path="due_date"/>
                            </div>
                            <div class="">
                                <label class="form-label">Loại nhiệm vụ</label>
                                <form:select class="form-select" path="taskType.type" id="taskType">
                                    <c:forEach items="${arrTaskType}" var="taskType">
                                        <form:option value="${taskType.id}">${taskType.type}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="box-parent" style="display:none">
                                <label class="form-label">Nhiệm vụ chính</label>
                                <form:select class="form-select" path="parent" id="parent">
                                    <c:forEach items="${arrTask}" var="task">
                                        <form:option value="${task.id}">${task.title}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
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