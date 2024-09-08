<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring Security Example </title>
</head>
<body>


<form:form action="/login" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form:form>
<input type="button" value="Logout"
       onclick="window.location.href = '/logout'"/>
</body>
</html>