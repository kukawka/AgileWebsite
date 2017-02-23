<%-- 
    Document   : userAttemptQuiz
    Created on : Feb 23, 2017, 10:13:40 AM
    Author     : Atanas
    --%>

    <%@page import="Beans.QuizDetails"%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/quizScore.css"/>
    </head>
    <body>
        <%
        QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails");
        %>
        <div class="page-header">
            <h1 style="color:skyblue; margin-left: 45%;"><b><%= quizDetails.getTitle()%></b></h1>
            <span style="font-size: 20px; color:skyblue; margin-left: 46%;">Date: <%= quizDetails.getDate()%></span>
        </div>
        <form class="form-horizontal" style="width: 100%;">
            <div class="form-group" style="width: 100%;">
            </div>
            <div class="form-group" style="width: 100%;">
                <div class="quizContent">
                    <!-- If the quiz exists get the data for the user !!!!!!!! -->
                    <% if (!quizDetails.getAvailability()) {%>
                    <input  class="btn btn-lg btn-primary" id='button' onclick="showDiv()" value="Start Quiz" style="margin-left: 40%; margin-top: 15%; width: 300px; height: 100px;" />
                    <!-- If the quiz dosn't exist get the data for the user -->
                    <%} else {%> 

                    <%}%>
                </div>
            </div>
        </form>

        <span id="questionTotal" data-question-total=<%=quizDetails.getQuestions().size()%>></span>
        <div id="showDiv" style="display: none; background-color: skyblue;">

            <% for (int x = 0; x < quizDetails.getQuestions().size(); x++) {%>

            <% 
            String[] answers = quizDetails.getQuestions().get(x).getAnswers();
            String abcd = "";
            String correct = "";
            %>

            <!-- Default panel contents -->
            <div class="quiz">
                <h2 class="quiz-question"><b>Q<%=x + 1%>. <%= quizDetails.getQuestions().get(x).getQuestionText()%></b></h2>
                <p><b><h5>Explanation:</b><%= quizDetails.getQuestions().get(x).getExplanation()%></h5></p>
                <!-- List group -->
                <ul data-quiz-question=<%=x + 1%>>
                    <% for (Integer y = 0; y < 4; y++) {
                    if(y.equals(0)) abcd = "a";
                    if(y.equals(1)) abcd = "b";
                    if(y.equals(2)) abcd = "c";
                    if(y.equals(3)) abcd = "d";
                    %>
                    <li class="quiz-answer" data-quiz-answer=<%=abcd%>><%=abcd%>)<%= answers[y]%>
                        <%if(quizDetails.getQuestions().get(x).getCorrectAnswerID() == y) {%>
                        <span id="questionAnswer" data-question-answer="<%=abcd%>"></span>
                        <%} %>
                    </li>
                    <% } %>
                </ul>
            </div>
            <% }%>
        </div>

        <div class="quiz-result"></div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="<%= request.getContextPath() %>/js/quizScore.js"></script>

    </body>
    </html>
