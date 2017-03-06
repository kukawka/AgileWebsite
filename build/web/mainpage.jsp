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
        <div class="main">
            <center><h1>Please choose a <i>ffff</i> </h1></center><br>
            <div class="grid">
                 
                <%
                    if (request.getAttribute("type") != null) {
                        if (request.getAttribute("type").equals("pos")) {
                            ArrayList<ProgrammeOfStudy> pos = (ArrayList<ProgrammeOfStudy>) request.getAttribute("items");
                            for (int i = 0; i < pos.size(); i++) {
                %>

                <div class="grid-item">
                   
                    <form method="Post" action="MainPage">
                        
                        <input type="hidden" name="id" value="<%=pos.get(i).getID()%>"/>
                        <input type="hidden" name="type" value="module"/>
                        <input type="submit" name="info" id="submit1" value="<%=pos.get(i).getName()%>"/>
                    </form>
                    
                </div>
                    <%
                        }
                    } else if (request.getAttribute("type").equals("module")) 
                    {
                        ArrayList<Module> mod = (ArrayList<Module>) request.getAttribute("items");
                        for (int i = 0; i < mod.size(); i++) {
                    %>

                    <div class="grid-item">
                        <form method="Post" action="MainPage">
                        <input type="hidden" name="id" value="<%=mod.get(i).getID()%>"/>
                        <input type="hidden" name="type" value="quiz"/>
                        <input type="submit" name="info" id="submit1" value="<%=mod.get(i).getName()%>"/>
                    </form>
                </div>
                        <%
                            }

                        } else if (request.getAttribute("type").equals("quiz")) {
                            ArrayList<Quiz> quiz = (ArrayList<Quiz>) request.getAttribute("items");
                            for (int i = 0; i < quiz.size(); i++) {
                        %>

                         <div class="grid-item">
                             <%if((login.getType()).equals("Staff"))
                             {
                                %>
                             <form method="Post" action="GetQuizDetails">
                             <% 
                             }
                             if((login.getType()).equals("Student"))
                            { 
                             %>
                            <form method="Post" action="TakeQuiz">
                                <% 
                             }
                                %>  
                        
                        <input type="hidden" name="quizID" value="<%=quiz.get(i).getID()%>"/>
                        
                        <input type="hidden" name="type" value="GoQuiz"/>
                        <input type="submit" name="info" id="submit2" value="<%=quiz.get(i).getName()%>"/>
                       
                        </form> 
                </div>
                        
                            <%
                                        }
                                        if((login.getType()).equals("Staff"))
                                        {  
                       
                            %>  
                       
                        <div class="grid-item">
                             <form method="Get" action="StaffStartQuiz">
                                 <input type="hidden" name="moduleID" value="<%=request.getParameter("id")%>">
                        <input type="submit" name="info" id="submit1" value="CREATE"/>  
                       
                       
                        </form> 
                        </div>      
                        <%
                                   }
                            } else {

                                    }
                                }
                            %>
                              
                        </div>
          
                    </div>

                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        			<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        			<script>
			            // external js: isotope.pkgd.js

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
