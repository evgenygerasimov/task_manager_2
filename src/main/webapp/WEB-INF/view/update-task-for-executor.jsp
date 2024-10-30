<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
