<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Evgen
  Date: 08.08.2024
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form:form action="/saveTask" modelAttribute="task">

    <form:hidden path="id"/>


    <br>
    <br>
    Name <form:input path="name"/>
    <br>
    <br>
    Description <form:input path="description"/>
    <br>
    <br>
    Status <form:select path="status">
    <form:options items="${task.statuses}"/>
    </form:select >
    <br>
    <br>
    Priority <form:select path="priority">
    <from:options items="${task.priorities}"/>
    </form:select>
    <br>
    <br>
    Author <form:input path="author"/>

    <br>
    <br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
