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
        <title>Quiz Inspector</title>
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
    <body >
        <%
            QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails");
            session.setAttribute("Filtered", false);
        %>
        <%
            int ID = (Integer) session.getAttribute("QuizID");
        %>
        <jsp:include page="/navBar.jsp" />
        <div class="main" >
            <div style="margin-left: 3%; margin-top: 0%; padding-top: 0px;">
                <div class="page-header">
                    <h1 style="color: #ffffff; font-family: 'Raleway',sans-serif; font-size: 66px; font-weight: 800; line-height: 72px;;text-transform: uppercase;"> Quiz Inspector</h1>
                </div>
                <div class="col-md-5 col-lg-5">
                    <h2 style="color: #ffffff; font-family: 'Raleway',sans-serif; font-size: 66px; font-weight: 800; line-height: 72px;;text-transform: uppercase;"><b>Quiz Title:<br></b><%= quizDetails.getTitle()%></h2><br>
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
                        <button type="button" class="btn btn-1 btn-1e"><a href="Stats" style="" id="edit">See Statistics <span class="glyphicon glyphicon-stats"</span></a></button>
                        <!-- <form method="POST" action="GetResults" style="margin-left: 0%; ">-->
                        <button type="button" class="btn btn-1 btn-1e"><a href="GetResults" >See All Results <span class="glyphicon glyphicon-sort-by-order" aria-hidden="true"></span></a></button>
                             <!--<input type="hidden" value="<%= ID%>" id="ID" name="ID">
                         </form>-->
                        <button type="button" class="btn btn-1 btn-1e" id="edit"><a href="staffEditQuiz.jsp" style="" id="edit">Edit Quiz &nbsp;<span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></button>
                        <!-- <button class="btn btn-1 btn-1e" data-toggle="modal" data-target="#myModal"> Schedule Availability <span class="glyphicon glyphicon-list-alt"</button> -->
                        <button  class="btn btn-1 btn-1e" id='button' onclick="showDiv()" value="See Questions">See All Questions <span class="glyphicon glyphicon-plus"></button>
                        
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

                            <div class="panel-heading"><h4><%=x + 1%>. <%= quizDetails.getQuestions().get(x).getQuestionText()%></h4></div>
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
