<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: Evgen
  Date: 28.08.2024
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<form>
    <table style="border-collapse: collapse;">
        <tr>
            <th style="border: 1px solid black;">Name</th>
            <th style="border: 1px solid black;">Role</th>
            <th style="border: 1px solid black;">Actions</th>
        </tr>

        <c:forEach var="user" items="${allUsers}">

            <c:url var="viewTasks" value="/tasks/userTasks">
                <c:param name="userName" value="${user.username}"/>
            </c:url>

            <c:set var="role" scope="request" value="${user.role}">

            </c:set>


            <tr>
                <td style="border: 1px solid black;">${user.username}</td>
                <td style="border: 1px solid black;">
                    <c:if test="${role == 'ROLE_EXECUTOR'}"><p>Executor</p></c:if>
                    <c:if test="${role == 'ROLE_CUSTOMER'}"><p>Customer</p></c:if>
                </td>
                <td style="border: 1px solid black;"><input type="button" value="View tasks"
                           onclick="window.location.href = '${viewTasks}'"/></td>
            </tr>

        </c:forEach>
    </table>
    <br>
    <br>
    <input type="button" value="Logout"
           onclick="window.location.href = '/logout'"/>
</form>
</body>
</html>
