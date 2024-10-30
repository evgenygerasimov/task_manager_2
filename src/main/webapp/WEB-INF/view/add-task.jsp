<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form:form action="${pageContext.request.contextPath}/tasks/saveTask" modelAttribute="task">

    <form:hidden path="id"/>
    <br>
    <br>
    Title <form:input path="title"/>
    <br>
    <br>
    Description <form:input path="description"/>
    <br>
    <br>
    Status <form:select path="status">
    <form:options items="${task.statuses}"/>
</form:select>
    <br>
    <br>
    Priority <form:select path="priority">
    <from:options items="${task.priorities}"/>
</form:select>
    <br>
    <br>
    Executor <form:select path="executor">
    <from:options items="${task.listUsers}"/>
</form:select>
    <br>
    <br>
    Comment <form:input path="comment"/>
    <br>
    <br>
    <form:hidden path="author"/>
    <form:hidden path="user.username"/>
    <input type="submit" value="OK">
    <br>
    <br>
    <input type="button" value="Logout"
           onclick="window.location.href = '${pageContext.request.contextPath}/logout'"/>
</form:form>
</body>
</html>
