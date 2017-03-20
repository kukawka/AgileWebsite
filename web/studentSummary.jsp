<%-- 
    Document   : studentSummary
    Created on : Mar 19, 2017, 9:39:36 PM
    Author     : Krasi
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
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/quizScore_1.css"/>
        
        <TITLE>Quiz Summary</TITLE>
    </head>
    <body>
        <%
        QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails");
        ArrayList<String> givenAnswers = (ArrayList<String>) request.getAttribute("GivenAnswers");
        int score = (Integer) request.getAttribute("Score");
        String date = (String) request.getAttribute("Date");
        %>
        <div class="page-header">
            <h1 style="color:black; margin-left: 5%;"><b><%= quizDetails.getTitle()%></b><small style="font-size: 20px; color:lightgrey; margin-left: 5%;">Date: <%= date%></small></h1>
             <a  class="btn btn-lg btn-info pull-right"   href="main.jsp"  style="margin-left: 38%; margin-right: 3%; margin-top:-5%; width: 150px; height: 50px; line-height: 25px;" >Home</a>
        </div>

        
        <div id="showDiv">

            <% for (int x = 0; x < quizDetails.getQuestions().size(); x++) {
            ArrayList<Answer> answers = quizDetails.getQuestions().get(x).getAnswers();
            String[] abcd = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"}; // 26
            
            %>

            <!-- Default panel contents -->
            <div class="quiz">
                <h2 class="quiz-question"><b>Q<%=x + 1%>. <%= quizDetails.getQuestions().get(x).getQuestionText()%></b></h2>
                <div class="explanation" ><p><b><h5>Explanation:</b><%= quizDetails.getQuestions().get(x).getExplanation()%></h5></p></div>
                <!-- List group -->
                <ul data-quiz-question=<%=x + 1%>>
                    <% 
                    String arrayofanswers = givenAnswers.get(x);
                    //char[] arrayofanswers = givenAnswers.get(x).toCharArray();
                    
                    for (Integer y = 0; y < answers.size() ; y++) {
                    
                    %>
                    <li class="quiz-answer 
                        <%for(int q=0;q<arrayofanswers.length();q++){
                        if((Character.getNumericValue(arrayofanswers.charAt(q)))==y)
                        {%>
                        active
                       <%
                        }
                        }
                        if(answers.get(y).getCorrect()==1)
                         {%> 
                         correct
                         <%}
                         %>
                         " style="background-color: #eaeae1"  ><%=abcd[y]%>)<%= answers.get(y).getText()%>
                    </li>
                    <% }
                        
                     %>
                </ul>
            </div>
            <% }%>

        <p id="demo3"></p>
        </div>
            <%if(score<40)
            {
                
%>
        <div class="quiz-result bad" >
            <%=score%>%
        </div>
<%} 
else if(score<70){ %>

<div class="quiz-result mid" >
            <%=score%>%
        </div>
<% } else if(score>70)
{%>
<div class="quiz-result good">
            <%=score%>%
        </div>
    <%

}%>

              <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    </body>
    </html>
