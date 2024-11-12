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
   <title>Update Task For Executor</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"
           integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/tasks/saveTask" modelAttribute="task">

    Status <form:select path="status">
    <form:options items="${task.statuses}"/>
    </form:select >
    <br>
    <br>
    Comment <form:input path="comment"/>
    <br>
    <br>
    <form:hidden readonly="true" path="id"/>
    <form:hidden readonly="true" path="description"/>
    <form:hidden readonly="true" path="title"/>
    <form:hidden readonly="true" path="priority"/>
    <form:hidden readonly="true" path="executor"/>
    <form:hidden readonly="true" path="author"/>
    <form:hidden readonly="true" path="user.username"/>
    <input type="submit" value="OK">
    <br>
    <br>
    <input type="button" value="Logout"
           onclick="window.location.href = '${pageContext.request.contextPath}/logout'"/>
</form:form>
</body>
</html>
