<%--
    Document   : staffEditQuiz
    Created on : Feb 21, 2017, 10:13:40 AM
    Author     : Musa
--%>

<%@page import="Beans.Answer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.QuizDetails"%>
<%@page import="Beans.LoggedIn"%>
<%-- <%@page import="Beans.EditQuiz"%> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Quiz</title>

        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mainpage_style.css"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/viewQuiz.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

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

                            <% if (login.getType().equals("Student")) { %>
                        <li class="active">
                            <a>
                                <form method="Get" action="Modules">
                                    <input type="submit" value="Modules" id="submit"><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-book"></span>
                                </form>
                            </a>
                        </li>
                        <% }%>

                        <li class="active"><a href="Logout" >Log Out<span style="font-size:16px;"  class="pull-right hidden-xs showopacity glyphicon glyphicon-log-out"></span></a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="main">                
            <%
                QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails");
            %>        

            <div style="margin-left: 3%; margin-top: 0%; padding-top: 0px;">
                <div class="page-header">
                    <h1>Edit Quiz</h1>
                    <form method = "POST" action = "StaffEditQuiz">
                </div>

                <form class="form-horizontal" method="Post" action="StaffEditQuiz">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label"></label>
                        <div class="col-sm-4" style="margin-left: -17%; margin-top: 0%; padding-top: 0px;">
                            <input type="text" class="form-control" name="title" id="inputEmail3" value=" <%= quizDetails.getTitle()%>">
                        </div>
                    </div>

                    <div class="form-group" style="width: 100%;">
                        <div class=" col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <% if (quizDetails.getAvailability()) {%>
                                    <input name="availability" type="checkbox" checked>
                                    <%} else {%> 
                                    <input name="availability" type="checkbox"><%}%> Availability
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="width: 100%;">
                        <div class="col-sm-10">
                            <h4>Date Created: <%= quizDetails.getDate()%></h4>
                        </div>
                    </div>
                    <div class="form-group" style="width: 100%;">
                        <div class="col-sm-10">
                            <input  class="btn btn-lg btn-primary" id='button' onclick="showDiv()" value="See Questions"/>
                            <input type = "submit" class="btn btn-lg btn-primary" id='buttonSubmit' value = "Submit"/>
                        </div>
                    </div>
                        
                    <div id="showDiv" style="display: none;">

                        <% for (int x = 0; x < quizDetails.getQuestions().size(); x++) { %>

                        <% ArrayList<Answer> answers = quizDetails.getQuestions().get(x).getAnswers();%>

                        <div class="col-sm-8">
                            <div class="panel panel-default" style="margin-left: -15px;">
                                <!-- Default panel contents -->

                                <div class="panel-heading"><h4><%=x + 1%>.  
                                        <input type="hidden"  name="id<%=x%>" value="<%= quizDetails.getQuestions().get(x).getQuestionID()%>">
                                        <input name="QuestionText<%=x%>" value="<%= quizDetails.getQuestions().get(x).getQuestionText()%>"> </h4></div>
                                <div class="panel-body">
                                    <p><b><h5>Explanation: </b> <input name="ExplanationText<%=x%>" value="<%=quizDetails.getQuestions().get(x).getExplanation()%>"> </h5></p>
                                </div>
                                <input type="hidden" name="ExplanationText<%=x%>" value="<%=quizDetails.getQuestions().get(x).getExplanation()%>">
                                <% for (int y = 0; y < answers.size(); y++) {%>
                                <!-- List group -->
                                <ul class="list-group">
                                    <li class="list-group-item" > 
                                        <input type="hidden" name="answerid<%=x%><%=y%>" value="<%= answers.get(y).getID()%>"/>
                                        <input name="answertext<%=x%><%=y%>" value="<%= answers.get(y).getText()%>"/> 
                                        <input type="checkbox" name="correct<%=x%><%=y%>" <% if (answers.get(y).getCorrect() == 1) {%> checked<% }%>></li>
                                </ul>
                                <% }%>  
                            </div>
                        </div>
                        <% }%>
                        <input type="hidden" name="QuestionNumber" value="<%= quizDetails.getQuestions().size()%>">
                        
                        <div class="form-group" style="width: 100%;">
                            <div class="col-sm-10">
                                <input style="margin-left: -2%;" type = "submit" class="btn btn-lg btn-primary" id='button' value = "Submit"/>
                            </div>
                        </div>
                    </div>
                </form>
                <script>

                    function showDiv() {
                        document.getElementById('showDiv').style.display = "block";
                        document.getElementById('button').style.display = "none";
                        document.getElementById('buttonSubmit').style.display = "none";
                    }
                </script>
            </div> 
    </body>
</html>
