<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1. shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">
   <title>All users</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"
           integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
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
           onclick="window.location.href = '${pageContext.request.contextPath}/logout'"/>
</form>
</body>
</html>
