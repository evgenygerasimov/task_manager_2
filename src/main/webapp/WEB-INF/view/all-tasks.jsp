<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1. shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">
   <title>all tasks</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"
           integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
<h2>ToDo Manager</h2>
<form>
    <table style="border-collapse: collapse;">
        <tr>
            <th style="border: 1px solid black;">ID</th>
            <th style="border: 1px solid black;">Title</th>
            <th style="border: 1px solid black;">Description</th>
            <th style="border: 1px solid black;">Status</th>
            <th style="border: 1px solid black;">Priority</th>
            <th style="border: 1px solid black;">Author</th>
            <th style="border: 1px solid black;">Executor</th>
            <th style="border: 1px solid black;">Comment</th>
            <th style="border: 1px solid black;">Actions</th>
        </tr>

        <c:forEach var="task" items="${tasks}">

            <c:url var="updateButton" value="/tasks/updateTask">
                <c:param name="taskId" value="${task.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/tasks/deleteTask">
                <c:param name="taskId" value="${task.id}"/>
            </c:url>
            <tr>
                <td style="border: 1px solid black;">${task.id}</td>
                <td style="border: 1px solid black;">${task.title}</td>
                <td style="border: 1px solid black;">${task.description}</td>
                <td style="border: 1px solid black;">${task.status}</td>
                <td style="border: 1px solid black;">${task.priority}</td>
                <td style="border: 1px solid black;">${task.author}</td>
                <td style="border: 1px solid black;">${task.executor}</td>
                <td style="border: 1px solid black;">${task.comment}</td>
                <td style="border: 1px solid black;"><input type="button" value="Update"
                                                            onclick="window.location.href = '${updateButton}'"/>
                    <security:authorize access="hasRole('CUSTOMER')">
                        <input type="button" value="Delete"
                               onclick="window.location.href = '${deleteButton}'"/>
                    </security:authorize>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <security:authorize access="hasRole('CUSTOMER')">
        <input type="button" value="Add task"
               onclick="window.location.href = '${pageContext.request.contextPath}/tasks/addNewTask'"/>
    </security:authorize>
    <br>
    <br>
    <input type="button" value="Logout"
           onclick="window.location.href = '${pageContext.request.contextPath}/logout'"/>
    <br>
    <br>
    <input type="button" value="All Users"
           onclick="window.location.href = '${pageContext.request.contextPath}/allUsers'"/>
</form>
</body>
</html>