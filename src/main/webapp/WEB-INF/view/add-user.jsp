<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1. shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">
   <title>Registration form</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"
           integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
<h2>Registration Form</h2>
<form:form action="${pageContext.request.contextPath}/saveUser" modelAttribute="user">
    <table>
    <form:hidden path="id"/>
        <tr>
            <td>Name:</td>
            <td><form:input path="username"/><form:errors path="username"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:input path="password"/><form:errors path="password"/></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><form:input path="email"/><form:errors path="email"/></td>
        </tr>
        <tr>
            <td>Phone number:</td>
            <td><form:input path="phoneNumber"/><form:errors path="phoneNumber"/></td>
        </tr>
        <tr>
            <td>Your role:</td>
            <td><form:select path="role"><form:options items="${user.roles}"/></form:select></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>