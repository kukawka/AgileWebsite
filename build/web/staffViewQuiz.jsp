<%-- 
    Document   : staffEditQuiz
    Created on : Feb 21, 2017, 10:13:40 AM
    Author     : Dagi
--%>

<%@page import="Beans.Answer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.LoggedIn"%>
<%@page import="Beans.QuizDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mainpage_style.css"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/viewQuiz.css"/>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- Bootstrap Date-Picker Plugin -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

        <!-- Include Date Range Picker -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script>
            function htmlbodyHeightUpdate() {
                var height3 = $(window).height()
                var height1 = $('.nav').height() + 50
                height2 = $('.main').height()
                if (height2 > height3) {
                    $('html').height(Math.max(height1, height3, height2) + 10);
                    $('body').height(Math.max(height1, height3, height2) + 10);
                } else
                {
                    $('html').height(Math.max(height1, height3, height2));
                    $('body').height(Math.max(height1, height3, height2));
                }

            }
            $(document).ready(function () {
                htmlbodyHeightUpdate()
                $(window).resize(function () {
                    htmlbodyHeightUpdate()
                });
                $(window).scroll(function () {
                    height2 = $('.main').height()
                    htmlbodyHeightUpdate()
                });
            });
        </script>
    </head>
    <body>
        <%
            QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails");
            session.setAttribute("Filtered", false);
        %>
        <%
            int ID = (Integer) session.getAttribute("QuizID");
        %>
        <nav class="navbar navbar-inverse sidebar" role="navigation" style="position: fixed;">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">QuizUp</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <% LoggedIn login = (LoggedIn) session.getAttribute("LoggedIn");%>
                        <form method="Post" action="MainPage" id='info'>
                            <p>Information about the user.<i> <br>Username: <%=login.getUsername()%><br>Type: <%=login.getType()%> </i></p>
                        </form>
                        <li class="active"><a href="mainpage.jsp" >Home<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
                        <li id="pos" ><a>

                                <form method="Post" action="MainPage">
                                    <input type="submit" name="type" value="Programme of Study" id="submit">
                                </form>
                                <br>
                                <form method="Post" action="MainPage">
                                    <input type="submit" name="type" value="Favourites" id="submit">
                                </form>
                            </a>
                        <li class="active">
                            <a>
                                <form method="POST"  action="Logout">
                                    <button type="submit" style="float:left; background:none; border:none; margin:0; padding:0;">Log out</button>
                                    <span style="font-size:16px;"  class="pull-right hidden-xs showopacity glyphicon glyphicon-log-out"></span>
                                </form>
                            </a>

                        </li>


                    </ul>
                </div>
            </div>
        </nav>
        <div class="main">
            <div style="margin-left: 3%; margin-top: 0%; padding-top: 0px;">
                <div class="page-header">
                    <h1> Quiz Inspector</h1>
                </div>
                <div class="col-md-5 col-lg-5">
                    <h2 style="color: #fff;"><b>Quiz Title: </b><%= quizDetails.getTitle()%></h2> 
                    <div class="checkbox">
                        <label style="color: #fff;">
                            <% if (quizDetails.getAvailability()) {%>
                            <input type="checkbox" checked disabled>Available to Students
                            <%} else {%> 
                            <input type="checkbox" disabled>Unavailable to Students<%}%> 
                        </label>
                    </div>
                    <h4 style="color: #fff;">Date of Creation: <%= quizDetails.getDate()%></h4>
                    <br>
                </div>
                <div class="col-md-2 col-lg-2"></div>
                <div class="col-md-5 col-lg-5">
                    <div class="list-group" >
                        <button type="button" class="list-group-item list-group-item-info"><a href="Stats" style="" id="edit">See Statistics <span class="glyphicon glyphicon-stats"</span></a></button>
                        <!-- <form method="POST" action="GetResults" style="margin-left: 0%; ">-->
                        <button type="button" class="list-group-item list-group-item-warning"><a href="GetResults" >See All Results <span class="glyphicon glyphicon-sort-by-order" aria-hidden="true"></span></a></button>
                             <!--<input type="hidden" value="<%= ID%>" id="ID" name="ID">
                         </form>-->
                        <button type="button" class="list-group-item-success list-group-item" id="edit"><a href="staffEditQuiz.jsp" style="" id="edit">Edit Quiz &nbsp;<span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></button>
                        <button  class="list-group-item list-group-item-danger" data-toggle="modal" data-target="#myModal">Schedule Availability <span class="glyphicon glyphicon-list-alt"</button>
                        <button  class="list-group-item list-group-item-danger active" id='button' onclick="showDiv()" value="See Questions">See All Questions <span class="glyphicon glyphicon-plus"></button>
        
                    </div>
                </div>
                <!-- Reference: https://formden.com/blog/date-picker-->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Schedule To Publish</h4>
                            </div>
                            <div class="modal-body">
                                <h4> If your quiz is currently unavailable to Students, you can schedule for it to be published at a particular time in the future.</h4>
                                <p> Choose a date below:</p>   
                                <form method="post" action="ScheduleAvailability">
                                    <div class="form-group"> <!-- Date input -->
                                        <label class="control-label" for="date">Date</label>
                                        <input class="form-control" id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
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


                <div id="showDiv" style="display: none; background-color: red;">

                    <% for (int x = 0; x < quizDetails.getQuestions().size(); x++) {%>

                    <% ArrayList<Answer> answers = quizDetails.getQuestions().get(x).getAnswers();%>

                    <div class="col-sm-8">
                        <div class="panel panel-default" style="margin-left: -15px;">
                            <!-- Default panel contents -->

                            <div class="panel-heading"><h4><%=x + 1%>. <%= quizDetails.getQuestions().get(x).getQuestionText()%><button type="button" class="list-group-item list-group-item-warning" data-toggle="modal" data-target="#myModal">See Results <span class="glyphicon glyphicon-sort-by-order" aria-hidden="true"></span></button></h4></div>
                            <div class="panel-body">
                                <p><b><h5>Explanation: </b> <%= quizDetails.getQuestions().get(x).getExplanation()%></h5></p>
                            </div>

                            <% for (int y = 0; y < answers.size(); y++) {%>
                            <!-- List group -->
                            <li class="list-group-item"> - <%=answers.get(y).getText()%> <% if (answers.get(y).getCorrect() == 1) {%> <p style="float:right;">&#10004;</p> <% } %></li>
                            </ul>

                            <% } %>
                        </div>  

                    </div>
                    <% }%>

                </div>
            </div>
        </div>


        <!-- Reference: https://formden.com/blog/date-picker-->
        <script>
            $(document).ready(function () {
                var date_input = $('input[name="date"]'); //our date input has the name "date"
                var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                date_input.datepicker({
                    format: 'mm/dd/yyyy',
                    container: container,
                    todayHighlight: true,
                    autoclose: true,
                })
            })
        </script>
        <script>

            function showDiv() {
                var temp=document.getElementById('button').value ;
                if(temp == "Hide Questions"){
                   document.getElementById('showDiv').style.display = "none"; 
                   document.getElementById('button').innerHTML = "Show All Questions <span class='glyphicon glyphicon-plus'>";
                   document.getElementById('button').value = "See Questions";
                }
                else{
                document.getElementById('button').innerHTML = "Hide Questions <span class='glyphicon glyphicon-minus'>";
                document.getElementById('showDiv').style.display = "block";
                document.getElementById('button').value = "Hide Questions";
                var d = document.getElementById("edit");
                d.className += " active";}
            }

        </script>

    </body>
</html>
