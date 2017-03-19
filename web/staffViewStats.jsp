<%-- 
    Document   : staffViewStats
    Created on : Mar 7, 2017, 11:40:09 AM
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
        <title>Statistics</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mainpage_style.css"/>

        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    </head>
    <body>
        <jsp:include page="/navBar.jsp" />
        <%
            QuizResults quizResults = (QuizResults) session.getAttribute("QuizResults");
        %>
        <%
            QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails");
        %>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['bar']});
            google.charts.setOnLoadCallback(drawStuff);
            <%  ArrayList<Integer> scores = quizResults.getScores();
                ArrayList<String> surnames = quizResults.getSurnames();
                ArrayList<String> firstnames = quizResults.getFirstnames();
                ArrayList<String> matricNum = quizResults.getMatricNum();
                ArrayList<Integer> attempts = quizResults.getAttempts();
                ArrayList<String> dates = quizResults.getDates();

                int[] numOfStudents = new int[5];
                for (int i = 0; i < scores.size(); i++) {
                    if (scores.get(i) <= 20) {
                        numOfStudents[0] = numOfStudents[0] + 1;
                    } else if (scores.get(i) > 20 && scores.get(i) <= 40) {
                        numOfStudents[1] = numOfStudents[1] + 1;
                    } else if (scores.get(i) > 40 && scores.get(i) <= 60) {
                        numOfStudents[2] = numOfStudents[2] + 1;
                    } else if (scores.get(i) > 60 && scores.get(i) <= 80) {
                        numOfStudents[3] = numOfStudents[3] + 1;
                    } else {
                        numOfStudents[4] = numOfStudents[4] + 1;
                    }
                }%>

            function drawStuff() {
                var data = new google.visualization.arrayToDataTable([
                    ['Score range', 'Number of Students'],
                    ["0-20", <%=numOfStudents[0]%>],
                    ["20-40", <%=numOfStudents[1]%>],
                    ["40-60", <%=numOfStudents[2]%>],
                    ["60-80", <%=numOfStudents[3]%>],
                    ['80-100',<%=numOfStudents[4]%>]
                ]);

                var options = {
                    title: 'The performance overview',
                    width: 900,
                    legend: {position: 'none'},
                    chart: {subtitle: 'number of students by percentage range'},
                    axes: {
                        x: {
                            0: {side: 'top', label: ''} // Top x-axis.
                        }
                    },
                    bar: {groupWidth: "90%"}
                };

                var chart = new google.charts.Bar(document.getElementById('top_x_div'));
                // Convert the Classic options to Material options.
                chart.draw(data, google.charts.Bar.convertOptions(options));
            }
            ;
        </script>
        <!-- The chart was taken from:
                https://developers.google.com/chart/interactive/docs/gallery/linechart -->
       

        <div class="main">
            <div style="margin-left: 3%;">
                <div class="page-header">
                    <h1>View Stats for: <b><%=quizDetails.getTitle()%></b></h1>
                </div>
                <div id="top_x_div" style="width: 900px; height: 500px;"></div>
                <br>


                <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                <h3><b>Average Score: </b><%=quizResults.getAverage()%></h3>
                <h3><b>Minimum Score: </b><%=quizResults.getMini()%></h3>
                <h3><b>Maximum Score: </b><%=quizResults.getMaxi()%></h3>
                </body>
                </html>