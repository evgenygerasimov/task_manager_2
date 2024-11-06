<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<form:form action="${pageContext.request.contextPath}/saveUser" modelAttribute="user">
    <form:hidden path="id"/>
    <br>
    <br>
    Name <form:input path="username"/>
    <br>
    <br>
    Password <form:input path="password"/>
    <br>
    <br>
    E-mail: <form:input path="email"/>
    <form:errors path="email"/>
    <br>
    <br>
    Phone number: <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
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