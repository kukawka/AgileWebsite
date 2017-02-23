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
        <h2>Submit a Quiz</h2>
        </header>
        <nav>
            <ul>
                <%-- nav bar --%>
            </ul>
        </nav>
       
        <article>
            
            <form method="POST"  action="StaffSubmitQuiz">
                
                <ul>
                    <h3>Question Options:</h3>
                    <br>            
                    <%
                    //variables from last page
                    int questionsnumber = Integer.parseInt(request.getParameter("questionsnumber"));
                    int quizID = (Integer) request.getAttribute("quizID");
                    %>
                    
                    <input type="hidden" name="quizID" value=<%=quizID%>>
                    <input type="hidden" name="questionsnumber" value=<%=questionsnumber%>>
                    
                    <%-- Display per number of questions to be given--%>
                    <%
                        for (int i=0; i<questionsnumber; i++)
                        {
                            //Question Info
                        %>
                            <br>
                            <h4>Question <%=i+1%></h4>
                            <li>Question Text: <input type="text" name=<%="questiontext"+(i+1)%> maxlength="1024"></li>
                            <li>Explanation Text: <input type="text" name=<%="explanationtext"+(i+1)%>  maxlength="1024"></li>   
                            <br>

                            
                            <%
                            //Display per number of questions to be given x4
                            for (int j=0; j<4; j++)
                            {
                                //Answer Info
                                %>
                                   <h5>Answer <%=j+1%>:</h5>
                                   <li>Answer Text: <input type="text" name=<%="answertext"+(i+1)+(j+1)%>  maxlength="255"></li>
                                   <li>Correct: <input type="checkbox" name=<%="correct"+(i+1)+(j+1)%>  value="1"> Yes</li> 
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