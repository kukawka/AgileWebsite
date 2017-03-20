<%-- 
    Document   : main
    Created on : Feb 19, 2017, 12:26:11 PM
    Author     : Dagi
--%>

<%@page import="Beans.LoggedIn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Main Page</title>
    </head>
    <body>
        <jsp:include page="/navBar.jsp" />
        <div class="main">
            <img style="margin-left:10%;margin-top:5%;" src="<%=request.getContextPath()%>/css/img/logo.png">
        </DIV>
    </body>
</html>
