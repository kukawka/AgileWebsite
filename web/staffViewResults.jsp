<%-- 
    Document   : staffViewResults
    Created on : Mar 6, 2017, 11:56:38 AM
    Author     : Dagi
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/results.css"/>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <!-- Bootstrap Date-Picker Plugin -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

        <!-- Include Date Range Picker -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body class="results">
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
        %>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">QuizUp</a>
                </div>
                <ul class="nav navbar-nav">
                    <li role="presentation" class="active"  id="irrel"><a href="#">All Students</a></li>
                    <li role="presentation" id="rel"><a href="RelevantResults">Relevant Students Only</a></li>

                    <form class="navbar-form navbar-left"  method="POST" action="LookUpStudentResult">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="ID of a Student" name="lookupID">
                        </div>
                        <%-- <form class="navbar-form navbar-left" method="POST" action="LookUpStudentResult"> --%>
                        <button type="submit" class="btn btn-default">Look Up</button>
                        </form>
                    <form class="navbar-form navbar-left">
                        <button type="button" class="btn btn-default btn-info filtering" data-toggle="modal" data-target="#myModal">Filter by Date Range</button>
                    </form>
                    <form class="navbar-form navbar-left" method="POST" action="ClearTheFilter">
                        <button type="submit" class="btn btn-default btn-warning filtering">Clear the Filter</button>
                    </form>
                </ul>

            </div><!-- /.container-fluid -->
        </nav>
        <!--<div class="main">-->
        <div style="margin-left: 5%; margin-right: 5%;" >
            <div class="page-header">
                <h1>View Results for: <b><%=quizDetails.getTitle()%></b></h1>
            </div>

            <!-- Reference: https://formden.com/blog/date-picker-->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Specify the date range</h4>
                        </div>
                        <div class="modal-body">
                            <h4> If your quiz is currently unavailable to Students, you can schedule for it to be published at a particular time in the future.</h4>
                            <p> Choose a date below:</p>   
                            <form method="POST" action="FilterByDate">
                                <div class="form-group"> <!-- Date input -->
                                    <label class="control-label" for="date">From</label>
                                    <input class="form-control" id="dateFrom" name="dateFrom" placeholder="yyyy-MM-dd" type="text"/>
                                </div>
                                <div class="form-group"> <!-- Date input -->
                                    <label class="control-label" for="date">To</label>
                                    <input class="form-control" id="dateTo" name="dateTo" placeholder="yyyy-MM-dd" type="text"/>
                                </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Save changes</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <br>
            <!-- ref /*Ref: http://codepen.io/anon/pen/rymEZj*/ -->
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0" class="results">
                    <thead class="results">
                        <tr class="results">
                            <th class="results">Matriculation No</th>
                            <th class="results">Firstname</th>
                            <th class="results">Lastname</th> 
                            <th class="results">No of Attempts</th>
                            <th class="results" style="background-color: #e60000; color: #ffffff;">Score</th>
                            <th class="results">Date</th>
                        </tr>

                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table class="results" cellpadding="0" cellspacing="0" border="0">
                    <tbody class="results">

                        <% if (!(Boolean) session.getAttribute("Filtered")) {
                                for (int i = 0; i < matricNum.size(); i++) {                                    
                                    //if ID to be displayed != ID looking for
                                    System.out.println("lookupID in " + i + ": " + session.getAttribute("lookupID"));
                                    if (session.getAttribute("lookupID")!=null && !((matricNum.get(i)).equals(session.getAttribute("lookupID"))))
                                    {
                                        //do nothing                                                   
                                    }
                                    else
                                    {
                                                                
                        %>
                        <tr>
                            <td class="results"><%= matricNum.get(i)%></td>
                            <td class="results"><%= firstnames.get(i)%></td>
                            <td class="results"><%= surnames.get(i)%></td> 
                            <td class="results"><%= attempts.get(i)%></td>
                            <td class="results" style="background-color: #ffb3b3;"><%= scores.get(i)%></td>
                            <td class="results"><%= dates.get(i)%></td>
                        </tr>
                        <%  } } session.setAttribute("lookupID", null); //reset matriculation number lookup
                        } else {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date dateTo = sdf.parse((String) session.getAttribute("dateTo"));
                            Date dateFrom = sdf.parse((String) session.getAttribute("dateFrom"));

                            for (int i = 0; i < matricNum.size(); i++) {
                                if (dates.get(i) != null) {
                                    System.out.println("null");
                                    Date date = sdf.parse(dates.get(i));

                                    if (date.compareTo(dateFrom) >= 0 && date.compareTo(dateTo) <= 0) {%>
                        <tr class="results">
                            <td class="results"><%= matricNum.get(i)%></td>
                            <td class="results"><%= firstnames.get(i)%></td>
                            <td class="results"><%= surnames.get(i)%></td> 
                            <td class="results"><%= attempts.get(i)%></td>
                            <td class="results" style="background-color: #ffb3b3;"><%= scores.get(i)%></td>
                            <td class="results"><%= dates.get(i)%></td>
                        </tr>
                        <%}
                                    }
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <!-- Reference: https://formden.com/blog/date-picker-->
            <script>
                $(document).ready(function () {
                    var date_input = $('input[name="dateTo"]'); //our date input has the name "date"
                    var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                    date_input.datepicker({
                        format: 'yyyy-mm-dd',
                        container: container,
                        todayHighlight: true,
                        autoclose: true,
                    })
                    var date_input2 = $('input[name="dateFrom"]'); //our date input has the name "date"
                    var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                    date_input2.datepicker({
                        format: 'yyyy-mm-dd',
                        container: container,
                        todayHighlight: true,
                        autoclose: true,
                    })
                })

                $(window).on("load resize ", function () {
                    var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
                    $('.tbl-header').css({'padding-right': scrollWidth});
                }).resize();
            </script>
    </body>
</html>
