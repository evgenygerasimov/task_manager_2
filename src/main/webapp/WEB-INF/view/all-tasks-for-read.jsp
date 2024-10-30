<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
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
            </tr>
        </c:forEach>
    </table>
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