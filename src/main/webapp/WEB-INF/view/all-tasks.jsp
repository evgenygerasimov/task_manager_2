<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<body>
<h2>ToDo Manager</h2>
<form>
<table style="border-collapse: collapse;">
    <tr>
        <th style="border: 1px solid black;">ID</th>
        <th style="border: 1px solid black;">Name</th>
        <th style="border: 1px solid black;">Description</th>
        <th style="border: 1px solid black;">Status</th>
        <th style="border: 1px solid black;">Priority</th>
        <th style="border: 1px solid black;">Author</th>
        <th style="border: 1px solid black;">Actions</th>
    </tr>

    <c:forEach var="task" items="${tasks}">

        <c:url var="updateButton" value="/updateTask">
            <c:param name="taskId" value="${task.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteTask">
            <c:param name="taskId" value="${task.id}"/>
        </c:url>
        <tr>
            <td style="border: 1px solid black;">${task.id}</td>
            <td style="border: 1px solid black;">${task.name}</td>
            <td style="border: 1px solid black;">${task.description}</td>
            <td style="border: 1px solid black;">${task.status}</td>
            <td style="border: 1px solid black;">${task.priority}</td>
            <td style="border: 1px solid black;">${task.author}</td>
            <td style="border: 1px solid black;"><input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/></td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add task"
       onclick="window.location.href = '/addNewTask'"/>
</form>
</body>
</html>