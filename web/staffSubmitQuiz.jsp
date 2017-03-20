<%@page import="Beans.LoggedIn"%>
<html>
    <head>       
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mainpage_style.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>Submit a Quiz</title>
    </head>
    <body>
                <body bgcolor="c0d13e">
 		<jsp:include page="/navBar.jsp" />
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
    </body>
</html>