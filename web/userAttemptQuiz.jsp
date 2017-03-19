<%-- 
Document   : userAttemptQuiz
Created on : Feb 23, 2017, 10:13:40 AM
Author     : Atanas
--%>

    <%@page import="Beans.Answer"%>
<%@page import="java.util.ArrayList"%>
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

    <p id="demo"></p>
    <p id="demo2"></p>
    
        <%
        QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails");
        int taken = (Integer) session.getAttribute("taken");
        String correctAnswers = ""; 
        String questAnswers = "";
        String questCorrAnswers = "";
        %>
        <div class="page-header">
            <h1 style="color:black; margin-left: 5%;"><b><%= quizDetails.getTitle()%></b><small style="font-size: 20px; color:lightgrey; margin-left: 5%;">Date: <%= quizDetails.getDate()%></small></h1>
        </div>
        <form class="form-horizontal" style="width: 100%;">
            <div class="form-group" style="width: 100%;">
            </div>
            <div class="form-group" style="width: 100%;">
                <div class="quizContent">
                    <!-- If the quiz exists get the data for the user !!!!!!!! -->
                    <% if (quizDetails.getAvailability()) {%>
                    <input  class="btn btn-lg btn-primary" id='button' onclick="showDiv()" value="Start Quiz" style="margin-left: 40%; margin-top: 15%; width: 300px; height: 100px;" />
                    <%if(taken != -1){%>
                    <input  class="btn btn-lg btn-info" id='buttonSummary' onclick="showSummary()" value="Show Summary" style="margin-left: 40%; margin-top: 2%; width: 300px; height: 100px;" />
                    <!-- If the quiz dosn't exist get the data for the user -->
                    <%}} else {%> 

                    <%}%>
                </div>
            </div>
        </form>

        
        <div id="showDiv" style="display: none;">

            <% for (int x = 0; x < quizDetails.getQuestions().size(); x++) {
            questAnswers = questAnswers + quizDetails.getQuestions().get(x).getAnswers().size();
            ArrayList<Answer> answers = quizDetails.getQuestions().get(x).getAnswers();
            String[] abcd = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"}; // 26
            
            %>

            <!-- Default panel contents -->
            <div class="quiz">
            <form id= "target" action="TakeQuiz" method="POST">
                <h2 class="quiz-question"><b>Q<%=x + 1%>. <%= quizDetails.getQuestions().get(x).getQuestionText()%></b></h2>
                <div class="explanation" style="display: none"><p><b><h5>Explanation:</b><%= quizDetails.getQuestions().get(x).getExplanation()%></h5></p></div>
                <!-- List group -->
                <ul data-quiz-question=<%=x + 1%>>
                <input type="" id="SavedQuestion<%=x%>" name="SavedQuestion<%=x+1%>" value="">

                    <% 
                    
                    int number=0;
                    for (Integer y = 0; y < answers.size() ; y++) {
                    
                    %>
                    <li class="quiz-answer" style="background-color: #eaeae1" data-quiz-answer=<%=abcd[y]%>><%=abcd[y]%>)<%= answers.get(y).getText()%>
                        <%
                                if(answers.get(y).getCorrect()== 1) {
                                     number++;
                                     correctAnswers = correctAnswers + abcd[y];
                                } 
                            
                        %> 
                    </li>
                    <% }
                        questCorrAnswers = questCorrAnswers + number;
                     %>
                </ul>
            </div>
            <% }%>

        <p id="demo3"></p>
        
        <input  id="scored" name="score" value="" />
        <input  class="btn btn-lg btn-primary" id='submitButton' onclick="submitQuiz()" value="Submit" style="margin-left: 42%" />
        </form>
        </div><div class="quiz-result"></div>

        <div id="showSummaryDiv" style="display: none;">
            <p>THIS IS WORKING</p>
        </div>

        <span id="questionTotal" data-question-total=<%=quizDetails.getQuestions().size()%>></span>
        <span id="questionAnswer" data-question-answer="<%=correctAnswers%>"></span> <!-- Sending the correct answers -->
        <span id="questAnswers" data-quest-answers="<%=questAnswers%>"></span> <!-- Sending the answers for each question -->
        <span id="questCorrAnswers" data-quest-corr-answers="<%=questCorrAnswers%>"></span> <!-- Sending correct answers index -->
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="<%= request.getContextPath() %>/js/quizScore.js"></script>

    </body>
    </html>
