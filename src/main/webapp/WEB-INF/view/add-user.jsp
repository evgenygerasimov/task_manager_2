<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
Created by IntelliJ IDEA.
User: Evgen
Date: 08.08.2024
Time: 17:04
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:form="http://www.w3.org/1999/xhtml">
<body>
<form:form action="/saveUser" modelAttribute="user">

    <form:hidden path="id"/>


    <br>
    <br>
    Name <form:input path="username"/>
    <br>
    <br>
    Password <form:input path="password"/>
    <br>
    <br>
    Role <form:select path="role">
    <form:options items="${user.roles}"/>
</form:select >
    <br>
    <br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>