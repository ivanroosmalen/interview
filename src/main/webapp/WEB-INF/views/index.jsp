<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login page</title>

        <link href="<c:url value="/css/intelematics.css" />" rel="stylesheet">
        <script src="<c:url value="/js/jquery-2.2.1.min.js" />"></script>
        <script src="<c:url value="/js/intelematics.js" />"></script>

        <script>
            var contextPath = "<%=request.getContextPath()%>";
        </script>
    </head>
 
    <body>
        <div class="pageContainer">

            <h2>Welcome, please log in</h2>

            <div id="message" class="error"></div>

            <div class="loginContainer">
                            <div class="input">
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" maxlength="20" required>
                            </div>
                            <div class="input">
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" maxlength="15" required>
                            </div>

                            <div class="form-actions">
                                <input id="loginButton" type="submit" class="button" value="Log in">
                            </div>
                    </div>

                    <h3>Results here:</h3>
                    <div id="result" >
                    </div>
                </div>

    </body>
</html>