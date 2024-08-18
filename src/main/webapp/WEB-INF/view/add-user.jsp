<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
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