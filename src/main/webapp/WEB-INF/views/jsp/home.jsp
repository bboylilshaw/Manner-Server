<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h1>Title: ${title}</h1>
    <h1>Message: ${message}</h1>
    <c:set var="authUser" value="${pageContext.request.userPrincipal}"/>
    <c:if test="${authUser != null}">
        Hi ${authUser.name}<br>
        <form action="${pageContext.request.contextPath}/logout">
            <input type="submit" value="Log out" />
        </form>
    </c:if>

</body>
</html>
