<%-- 
    Document   : staffViewRelevantResults
    Created on : Mar 7, 2017, 4:18:00 PM
    Author     : Dagi
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.QuizDetails"%>
<%@page import="Beans.QuizResults"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mainpage_style.css"/>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            QuizResults quizResults = (QuizResults) session.getAttribute("RelevantQuizResults");
            ArrayList<Integer> scores = quizResults.getScores();
            ArrayList<String> surnames = quizResults.getSurnames();
            ArrayList<String> firstnames = quizResults.getFirstnames();
            ArrayList<String> matricNum = quizResults.getMatricNum();
            ArrayList<Integer> attempts = quizResults.getAttempts();
            ArrayList<String> dates = quizResults.getDates();
        %>
        <%
            QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails");
            //QuizDetails quizDetails = new QuizDetails();
            //quizDetails.setTitle("Test");
        %>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">QuizUp</a>
                </div>
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="#">All Students</a></li>
                    <li role="presentation"><a href="RelevantResults">Relevant Students Only</a></li>

                    <form class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="ID of a Student">
                        </div>
                        <button type="submit" class="btn btn-default">Look Up</button>
                    </form></ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <!--<div class="main">-->
    <div style="margin-left: 5%; margin-right: 5%;" >
        <div class="page-header">
            <h1>View Results for: <b><%=quizDetails.getTitle()%></b></h1>
        </div>
        <br>
        <table class="table table-striped">
            <tr>
                <th>Matriculation No</th>
                <th>Firstname</th>
                <th>Lastname</th> 
                <th>No of Attempts</th>
                <th style="background-color: red;">Score</th>
                <th>Date</th>
            </tr>


            <%for (int i = 0; i < matricNum.size(); i++) {%>
            <tr>
                <td><%= matricNum.get(i)%></td>
                <td><%= firstnames.get(i)%></td>
                <td><%= surnames.get(i)%></td> 
                <td><%= attempts.get(i)%></td>
                <td><%= scores.get(i)%></td>
                <td><%= dates.get(i)%></td>
            </tr>
            <%}%>
        </table>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Filter <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><button onclick="">Show only relevant students</button></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Separated link</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">One more separated link</a></li>
            </ul>
        </li>
</body>
</html>

