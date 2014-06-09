<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
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

<!--begin container-->
<div class="container">
    <div class="row col-md-4 col-md-offset-4">
        <div id="loginPanel" class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Please Login</h3>
            </div>
            <div class="panel-body">
                <form:form servletRelativeAction="/login" method="post" role="form">
                    <c:if test="${param.error!=null}">
                        <div class="alert alert-danger">
                            Invalid username and password.
                        </div>
                    </c:if>
                    <c:if test="${param.logout!=null}">
                        <div class="alert alert-success">
                            You have been logged out.
                        </div>
                    </c:if>
                    <div class="form-group">
                        <input type="email" name="email" class="form-control" placeholder="Email Address"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Password"/>
                    </div>
                    <div class="checkbox">
                        <label>
                            <input name="remember" type="checkbox" value="Remember Me"/> Remember Me
                            <a href="#" class="pull-right">Forgot Password?</a>
                        </label>
                    </div>
                    <input type="submit" value="Login" class="btn btn-primary btn-block"/>
                </form:form>
            </div>
            <div class="panel-footer text-center">
                <a href="#">Don't have an account? Register</a>
            </div>
        </div>
    </div>
</div><!-- end container -->

</body>
</html>
