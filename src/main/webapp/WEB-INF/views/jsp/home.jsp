<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <c:url var="bootstrapCss" value="/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${bootstrapCss}" />
    <c:url var="appCss" value="/resources/css/app.css" />
    <link rel="stylesheet" href="${appCss}" />
    <c:url var="jquery" value="/resources/js/jquery.min.1.11.0.js" />
    <script type="javascript" src="${jquery}"></script>
    <c:url var="bootstrapJs" value="/resources/js/bootstrap.min.js" />
    <script type="javascript" src="${bootstrapJs}"></script>
</head>
<body>

    <!-- begin fixed navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <form:form servletRelativeAction="/logout" method="post" cssClass="navbar-form navbar-right" role="form">
                <div class="form-group">
                    <c:set var="authUser" value="${pageContext.request.userPrincipal}"/>
                    <c:if test="${authUser!=null}">
                        <div class="text-color-white">${authUser.name}</div>
                    </c:if>
                </div>
                <button type="submit" class="btn btn-link">Logout</button>
            </form:form>
        </div>
    </div><!--end fixed navbar-->

</body>
</html>
