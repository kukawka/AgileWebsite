<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Beans.LoggedIn"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Style for drop-down -->
        <style>
            .dropbtn {
                background-color: #4CAF50;
                color: white;
                padding: 16px;
                font-size: 16px;
                border: none;
                cursor: pointer;
            }

            .dropbtn:hover, .dropbtn:focus {
                background-color: #3e8e41;
            }

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                overflow: auto;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }

            .dropdown a:hover {background-color: #f1f1f1}

            .show {display:block;}
        </style>
        
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
            <form id ="quizForm" method="POST"  action="StaffSubmitQuiz"> 
                
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
                            %>
                            <input type="hidden" id="iValue" name="iValue" value=<%=i+1%>>
                            <%
                            //Question Info
                        %>
                            <br>
                            <h3>Question <%=i+1%></h3>
                            <li>Question Text: <input class="form-control" type="text" name=<%="questiontext"+(i+1)%> maxlength="1024" required></li>
                            <li>Explanation Text: <input class="form-control" type="text" name=<%="explanationtext"+(i+1)%>  maxlength="1024"></li>   
                            <br>
                            <!-- Input for number of answers -->
                            <li> Number of Answers: <select name="<%="numOfAnswers"+(i+1)%>" id="<%="numOfAnswers"+(i+1)%>">
                                <option value=2>2</option>
                                <option value=3>3</option>
                                <option value=4>4</option>
                                <option value=5>5</option>
                                <option value=6>6</option>
                                <option value=7>7</option>
                                <option value=8>8</option>
                                <option value=9>9</option>
                                <option value=10>10</option>
                              </select></li>
              
                            <button class="btn btn-info" id="<%= i+1 %>"  type="button" onclick="myFunction()">Display Answers Desired</button> <br>
                            
                            <div id=<%="answerHolder"+(i+1)%>>
                                </div>
                            <!-- <p id="demo"></p> -->
                            
                            <script>
                            function myFunction() {
                                
                                //get i at button click
                                var e = window.event,
                                btn = e.target || e.srcElement;
                                
                                var i = btn.id;
                                
                                //disable button
                                document.getElementById(i).disabled = true;
                                
                                
                                var index = "numOfAnswers"+i;
                                var x = document.getElementById(index).value;                  
                                
                                //value needed is inside 'text'
                                var displayAnswers = x;
                                
                                if (displayAnswers<2)
                                {
                                    displayAnswers=2;
                                }
                                else if(displayAnswers>10)
                                {
                                    displayAnswers=10;
                                }
                                
                                //print answer forms
                                for (var j=0; j<(displayAnswers) ; j++)
                                {
                                    var jplus= j+1;
                                        
                                        //answer heading
                                        var header = document.createElement ("H4");
                                        var text = document.createTextNode("Answer " + jplus);

                                        header.appendChild(text);
                                        document.getElementById("answerHolder"+i).appendChild(header);
                                        
                                        //answer text
                                        var ansText = document.createElement("INPUT");
                                        ansText.setAttribute("type", "text");
                                        ansText.setAttribute("value", "Answer text here!");
                                        ansText.setAttribute("name", "answertext"+i+jplus);
                                        ansText.setAttribute("maxlength", "255");
                                        ansText.setAttribute("required", "");
                                        ansText.setAttribute("class", "form-control");
                                        document.getElementById("answerHolder"+i).appendChild(ansText);
                                        
                                        var linebreak = document.createElement("br");
                                        document.getElementById("answerHolder"+i).appendChild(linebreak);
                                        
                                        //answer correct checkbox
                                        var checkboxText1 = document.createTextNode("Correct: ");
                                        document.getElementById("answerHolder"+i).appendChild(checkboxText1);
                                        
                                        
                                        var correct = document.createElement("INPUT");
                                        correct.setAttribute("type", "checkbox");
                                        correct.setAttribute("name", "correct"+i+jplus);
                                        correct.setAttribute("value", "1");
                                        document.getElementById("answerHolder"+i).appendChild(correct);
                                        
                                        var checkboxText2 = document.createTextNode("Yes");
                                        document.getElementById("answerHolder"+i).appendChild(checkboxText2);
                                        
                                        //make dropdown invisible   
                                        document.getElementById("numOfAnswers"+i).style.display = "none";
                             }
                                //end of script
                            }
                            </script>                      
                       <%
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