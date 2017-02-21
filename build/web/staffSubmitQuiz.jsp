<%@page import="java.util.UUID"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit a Quiz</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <header>
       
        </header>
        <nav>
            <ul>

            </ul>
        </nav>
       
        <article>
            <h2>Submit a Quiz</h2>
            <form method="POST"  action="staffSubmitQuiz">
                <ul>
                    <%-- Quiz Information - taken once per quiz
                    <h3>Quiz Options:</h3>
                    <li>Quiz Title: <input type="text" name="title" minlength="4" required="required"></li>
                    <li>ModuleID: <input type="text" name="moduleID" minlength="6" maxlength="10"  required ="required"></li>
                    <li>Availability: <input type="checkbox" name="available" value="1"> Yes </li>

                    <li>Number of questions to provide: <input type="number" name="questionsnumber" minlength="1" required="required"></li><br>

                    --%>
                    <%-- Question Information--%>
                    <h3>Question Options:</h3>
                    <br>
                    

                    <%-- Display per number of questions to be given--%>
                    <%
                    //variables from last page
                    int questionsnumber=Integer.parseInt(request.getParameter("questionsnumber"));
                    UUID quizID=UUID.fromString(request.getParameter("quizID"));
                    //Date creationDate=request.getParameter("creationDate");
                    String title=request.getParameter("title");
                    UUID moduleID=UUID.fromString(request.getParameter("moduleID"));


                    String questionTextName="questiontext";
                    String explanationTextName="explanationtext";
                    String validName="valid";

                    String answerTextName="answertext";
                    String correctName="correct";
                        for (int i=0; i<questionsnumber; i++)
                        {

                        %>
                            <br>
                            <h4>Question <%=i+1%></h4>
                            <li>Question Text: <input type="text" name=<%=questionTextName+(i+1)%> maxlength="1024"></li>
                            <li>Explanation Text: <input type="text" name=<%=explanationTextName+(i+1)%>  maxlength="1024"></li>
                            <li>Valid: <input type="checkbox" name=<%=validName+(i+1)%> value="1"> Yes</li>
                            <br>

                            
                            <%
                            //Display per number of questions to be given TIMES FOUR
                            //answer Information

                            for (int j=0; j<4; j++)
                            {
                                %>
                                    <h5>Answer <%=j+1%>:</h5>
                                   <li>Answer Text: <input type="text" name=<%=answerTextName+(i+1)+(j+1)%>  maxlength="255"></li>
                                    <li>Correct: <input type="checkbox" name=<%=correctName+(i+1)+(j+1)%>  value="1"> Yes</li> 
                                    <br>
                                <%
                            }            
                        }

                    %>
                </ul>
                <br/>
                <input type="submit" value="Submit Quiz"> 
            </form>

        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/">Home</a></li>
            </ul>
        </footer>
    </body>
</html>