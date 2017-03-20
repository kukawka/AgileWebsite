<%-- 
    Document   : mainpage_quiz
    Created on : Mar 8, 2017, 10:20:43 PM
    Author     : Krasi
--%>

<%@page import="Beans.LoggedIn"%>
<%@page import="Beans.Quiz"%>
<%@page import="Beans.Module"%>
<%@page import="Beans.ProgrammeOfStudy"%>
<%@page import="java.util.ArrayList"%>
<HTML>
    <HEAD>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mainpage_style.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


        <TITLE>Your Title Here</TITLE>
    </HEAD>
    <BODY BGCOLOR="fff">
        <% LoggedIn login = (LoggedIn) session.getAttribute("LoggedIn");%>
		<jsp:include page="/navBar.jsp" />
		
        <div class="main">
            <div class="page-header">
			
                <div style="display: inline-block; width:500px;">
                <h1  style="width:20%; display: inline-block;">&nbsp&nbsp&nbsp<%=request.getAttribute("heading")%></h1>
                <h1 style='width:60%; ; float:right; display: inline-block; margin-bottom:-150px;'>
                <form method="Get" action="StaffStartQuiz" >
                        <input type="hidden" name="moduleID" value="<%=request.getParameter("id")%>">
                        <input type="submit" id="submit1" style="font-size:30px;border-style:none;font-family: 'Raleway',sans-serif;"  value="Create a Quiz &#10010;"/>
                </form> </h1>
                </div>
                <% if ((login.getType()).equals("Student")) { %>
                <div class="sort">
                    <label for="favoritefood">Sort quizzes by: </label>
                    <select class="Sorting">
                        <option value="Nothing" >Nothing</option>
                        <option value="Ascending">Ascending</option>
                        <option value="Descending">Descending</option>
                        <option value="Completed">Completed</option>
                    </select>
                </div>
                <% } %>
            </div><br><div class="grid">

                <%

                    ArrayList<Quiz> quiz = (ArrayList<Quiz>) request.getAttribute("items");
                    if ((login.getType()).equals("Staff")) {   // gives the creation option to the Staff member

                %>  
                <%
                    }
                    for (int i = 0; i < quiz.size(); i++) {
                %>
                <div class="grid-item" style="width:400px;">
                    <%if ((login.getType()).equals("Staff")) { // if the person is Staff it will send them to the quiz details
                    %>
                    <form method="Post" action="GetQuizDetails">
                        <%
                            }
                            if ((login.getType()).equals("Student")) {  // if the person is Student it will send them to take the quiz
                        %>
                        <form method="Get" action="TakeQuiz">
                            <%
                                }
                            %>  
                            <input type="hidden" class="quizID" name="quizID" value="<%=quiz.get(i).getID()%>"/>
                            <input type="submit" class="name" name="info" id="submit2" value="<%=quiz.get(i).getName()%>"/>
                            
                                
                                <div class="btnhandler" <% if (!((login.getType()).equals("Student") && quiz.get(i).getCompletion())) { %> style="display: none;"<% } %> >    
                                    
                                <span class="glyphicon glyphicon-ok"></span>
                                </div>
                                     
                                
                            
    
                        </form> 
                </div>
                <%
                    }
                %>
            </div>
        </div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="<%= request.getContextPath() %>/js/quizSorting.js"></script>
        <script>
            
            $('.grid').isotope({
                itemSelector: '.grid-item',
                masonry: {
                    columnWidth: 100
                }
            });
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
    </BODY>
</HTML>
