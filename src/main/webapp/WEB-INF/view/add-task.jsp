<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1. shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">
   <title>Create or edit a task</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"
           integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/tasks/saveTask" modelAttribute="task">
    <h2>Create or edit a task</h2>
    <form:hidden path="id"/>
    <table>
    <tr>
        <td>Title:</td>
        <td><form:input path="title"/><form:errors path="title"/></td
    </tr>
    <tr>
        <td>Description:</td>
        <td><form:input path="description"/><form:errors path="description"/></td>
    </tr>
    <tr>
        <td>Status:</td>
        <td><form:select path="status"><form:options items="${task.statuses}"/></form:select></td>
    </tr>
    <tr>
        <td>Priority:</td>
        <td><form:select path="priority"><from:options items="${task.priorities}"/></form:select></td>
    </tr>
    <tr>
        <td>Executor:</td>
        <td><form:select path="executor"><from:options items="${task.listUsers}"/></form:select></td>
    </tr>
    <tr>
        <td>Comment:</td>
        <td><form:input path="comment"/></td>
    </tr>

    </table>
    <form:hidden path="author"/>
            <form:hidden path="user.username"/>
    <br>
    <input type="submit" value="OK">
    <br>
    <input type="button" value="Logout"
           onclick="window.location.href = '${pageContext.request.contextPath}/logout'"/>
</form:form>
</body>
</html>
