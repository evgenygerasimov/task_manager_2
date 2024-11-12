<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1. shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">

   <title>Registration or sign up</title>

   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"
           integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>

<body class="container-fluid">

<h2>ToDo Manager</h2>
<br>
<form id="frm">
    <input type="button" value="Registration"
           onclick="window.location.href = '${pageContext.request.contextPath}/addNewUser'"/>
    <br>
    <br>
    <input type="button" value="Login"
           onclick="window.location.href = '${pageContext.request.contextPath}/login'"/>
</form>
</body>
</html>