<%-- 
    Document   : staffViewResults
    Created on : Mar 6, 2017, 11:56:38 AM
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


    </head>
    <body>
        <%
            QuizResults quizResults = (QuizResults) session.getAttribute("QuizResults");
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

        <div class="main">
            <div style="margin-left: 3%;">
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

    </body>
</html>
