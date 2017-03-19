<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Beans.LoggedIn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit a Quiz</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mainpage_style.css"/>
        
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.js">   
        </script>
        
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
            <script>
            $('.grid').isotope({
                itemSelector: '.grid-item',
                masonry: {
                    columnWidth: 100
                }
            });</script>
    </head>
    <body>
        <header>
        
        </header>
                <body bgcolor="c0d13e">
                <nav class="navbar navbar-inverse sidebar" role="navigation">
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
                                <form method="Post" action="MainPage">
                                    <input type="submit" name="type" value="Favourites" id="submit">
                                </form>
                                </a>
                                <li class="active"><a href="index.jsp" >Log Out<span style="font-size:16px;"  class="pull-right hidden-xs showopacity glyphicon glyphicon-log-out"></span></a></li>
                    </ul>
                </div>
            </div>
        </nav>
       
        <article>
           <div class="main">
           <div class="grid">
            <form method="POST"  action="StaffSubmitQuiz">
                
                <ul>
                    <h2>Submit a Quiz</h2>
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
                            <li>Question Text: <input type="text" name=<%="questiontext"+(i+1)%> maxlength="1024" required></li>
                            <li>Explanation Text: <input type="text" name=<%="explanationtext"+(i+1)%>  maxlength="1024" ></li>   
                            <br>

                            
                            <%
                            //Display per number of questions to be given x4
                            for (int j=0; j<4; j++)
                            {
                                //Answer Info
                                %>
                                   <h5>Answer <%=j+1%>:</h5>
                                   <li>Answer Text: <input type="text" name=<%="answertext"+(i+1)+(j+1)%>  maxlength="255" required></li>
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
           </div>
           </div>

        </article>
        <footer>
            <ul>
                <%--<li class="footer"><a href="/">Home</a></li>--%>
            </ul>
        </footer>
    </body>
</html>