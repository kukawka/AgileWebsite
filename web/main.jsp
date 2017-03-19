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
        <%
            LoggedIn login = (LoggedIn) session.getAttribute("LoggedIn");
        %> 

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">QuizUp</a>

                <form class="navbar-form navbar-right" method="POST"  action="Logout">
                    <button type="submit" class="btn btn-default">Log out</button>
                </form>
            </div>
        </nav>
        
        <h1>Hello  <%=login.getUsername()%>!</h1>
        <%=login.getType()%>
        </br>
        <a href="staffStartQuiz.jsp">Create Quiz</a>
        <br>
        <form class="navbar-form navbar-right" method="POST"  action="GetQuizDetails">
            <input type="hidden" name="quizID" id="quizID" value="1">
            <button type="submit" class="btn btn-default">Display Quiz</button>
        </form>
        <!--<a href="staffEditQuiz.jsp"></a>-->

    </body>
</html>
