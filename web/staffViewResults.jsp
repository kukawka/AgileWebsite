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

        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    </head>
    <body>
        <%
            QuizResults quizResults = (QuizResults) session.getAttribute("QuizResults");
            //QuizResults quizResults = new QuizResults();
            //quizResults.setT
        %>
        <%
            QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails");
            //QuizDetails quizDetails = new QuizDetails();
            //quizDetails.setTitle("Test");
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
                        //y: {
                            //0: {side: 'left', label: 'Percantage range'} // Top x-axis.
                        //}
                    },
                    bar: {groupWidth: "90%"}
                };

                var chart = new google.charts.Bar(document.getElementById('top_x_div'));
                // Convert the Classic options to Material options.
                chart.draw(data, google.charts.Bar.convertOptions(options));
            }
            ;
        </script>

        <div class="main">
            <div style="margin-left: 3%;">
                <div class="page-header">
                    <h1>View Results for: <b><%=quizDetails.getTitle()%></b></h1>
                </div>
                <div id="top_x_div" style="width: 900px; height: 500px;"></div>
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

                <!-- taken from:
                https://developers.google.com/chart/interactive/docs/gallery/linechart -->

                <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

                <!-- Chart according to dates-->
                <!--<script type="text/javascript">
                    google.charts.load('current', {'packages':['corechart']});
                    google.charts.setOnLoadCallback(drawChart);
                    function drawChart() {
                    var data = google.visualization.arrayToDataTable([
                    ['Date', 'Score'],
                    ['2017-02-05', 77 ],
                    ['2017-02-11', 45 ],
                    ['2017-02-18', 55 ],
                    ['2017-02-23', 44 ],
                    ['2017-03-02', 22 ]
                <%for (int i = 0; i < matricNum.size(); i++) {%>
                if ((i + 1) == matricNum.size()){
                ['<%= dates.get(i)%>', <%= scores.get(i)%> ]
                }
                else{
                ['<%= dates.get(i)%>', <%= scores.get(i)%> ], }
                <%}%>
                ]);
                var options = {
                title: 'Scores',
                        curveType: 'function',
                        legend: { position: 'bottom' }
                };
                var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
                chart.draw(data, options);
                }
            </script>

            <div id="curve_chart" style="width: 900px; height: 500px"></div>-->

                <!--Chart according to no of attempts-->
                <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                ['Date', 'Score'],
                    <%
                        //find the maximum value ; 
                        int maxi = 0;
                        for (int i = 0; i < attempts.size(); i++) {
                            if (attempts.get(i) > maxi) {
                                maxi = attempts.get(i);
                            }

                        }
                        double[] avg = new double[maxi];
                        double[] sum = new double[maxi];
                        double[] num = new double[maxi];
                        for (int j = 1; j <= maxi; j++) {
                            for (int i = 0; i < matricNum.size(); i++) {
                                if (attempts.get(i) == j) {
                                    sum[j - 1] = sum[j - 1] + scores.get(i);
                                    num[j - 1] = num[j - 1] + 1;
                                }
                            }
                            avg[j - 1] = sum[j - 1] / num[j - 1];
                        }
                    %>


                    <%for (int j = 1; j <= maxi; j++) {
                            if (j == maxi) {%>

                ['<%=j%>', <%= avg[j - 1]%>]
                    <%} else {%>
                ['<%=j%>', <%= avg[j - 1]%>], <%}
                    }%>
                ]);
                        var options = {
                            title: 'Scores Avg (Depending on No of Attempts)',
                            curveType: 'function',
                            legend: {position: 'bottom'},
                            // Allow multiple
                            // simultaneous selections.
                            aggregationTarget: 'auto'
                        };
                var chart = new google.visualization.LineChart(document.getElementById('noOfAttempts'));
                chart.draw(data, options);
            }
                </script>



                <div id="noOfAttempts" style="width: 900px; height: 500px"></div>
            </div>
        </div>

        <!--
        <script type="text/javascript">
        window.onload = function () {
                var chart = new CanvasJS.Chart("chartContainer",{
                        title:{
                                text: "Pareto Chart of Fast Food Chains"
                        },
                        axisY: {
                                title: "Number of Locations",                   
                        },
                        axisY2: {
                                title: "Percent",
                                valueFormatString: "0'%'"
                        },
                        data: [
                        {
                        type: "column",
                                dataPoints: [
                                        { label: "Subways", y: 44853 },
                                        { label: "McDonald", y: 36525 },
                                        { label: "Starbucks", y: 23768 },
                                        { label: "KFC", y: 19420 },
                                        { label: "Pizza Hut", y: 13528 },                      
                                        { label: "Dunkin-Donuts", y: 11906 },
                                ]
                        }
                        ]
                });
        
                chart.render();
                createPareto(chart);	
        
                function createPareto(chart){
                        var dps = [];
                        var yValue, yTotal = 0, yPercent = 0;
        
                        for(var i = 0; i < chart.data[0].dataPoints.length; i++)
                                yTotal += chart.data[0].dataPoints[i].y;
        
                        for(var i = 0; i < chart.data[0].dataPoints.length; i++){
                                yValue = chart.data[0].dataPoints[i].y;
                                yPercent += (yValue / yTotal * 100);
                                dps.push({label: chart.data[0].dataPoints[i].label, y: yPercent});
                        }
                        chart.addTo("data",{type:"line", yValueFormatString: "0'%'", dataPoints: dps});
                        chart.data[1].set("axisYType", "secondary");
                        chart.axisY[0].set("maximum", yTotal);
                        chart.axisY2[0].set("maximum", 100);
                }
        }
        </script>
        <script type="text/javascript" src="/assets/script/canvasjs.min.js"></script>
        <div id="chartContainer" style="height: 300px; width: 100%;"></div>
        -->
    </body>
</html>
