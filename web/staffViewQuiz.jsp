<%-- 
    Document   : staffEditQuiz
    Created on : Feb 21, 2017, 10:13:40 AM
    Author     : Dagi
--%>

<%@page import="Beans.QuizDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="page-header col-sm-offset-2">
            <h1>Edit Quiz</h1>
        </div>

     <%
            QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails");
     %> 

        <form class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Title</label>
                <div class="col-sm-10 col-md-4">
                    <input type="text" class="form-control" id="inputEmail3" value="<%= quizDetails.getTitle()%>" disabled>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <% if (quizDetails.getAvailability()){%>
                            <input type="checkbox" checked disabled>
                            <%}else{%> 
                            <input type="checkbox" disabled><%}%> Availability
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button  class="btn btn-lg btn-primary">See Questions</button>
                </div>
            </div>
        </form>

                        

     <% if (quizDetails!=null){%>
     
     
     <%= quizDetails.getAvailability()%>
     <%= quizDetails.getDate()%>
     <%= quizDetails.getQuestions().get(0).getQuestion()%>
     <%= quizDetails.getQuestions().get(0).getQuestion()%>
     <%= quizDetails.getQuestions().get(0).getCorrectAnswerID()%>
        <%} else {
%> <p>fuck this shit</p> 
<%
}
%>
    </body>
</html>
