<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<form:form action="${pageContext.request.contextPath}/saveUser" modelAttribute="user">
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
</form:select>
    <br>
    <br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>