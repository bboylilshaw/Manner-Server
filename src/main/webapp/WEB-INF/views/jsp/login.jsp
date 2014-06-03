<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="POST">
    Username:<input type="text" name="username" placeholder="Username"/>
    Password:<input type="password" name="password" placeholder="Password"/>
    <input type="submit" value="Login"/>
</form>

</body>
</html>
