<%@page import="Beans.LoggedIn"%>
<html>
    <head>        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mainpage_style.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>Submit a Quiz</title>
    </head>
    <body>
         <jsp:include page="/navBar.jsp" />
            
          <div class="main">
            <form method="POST"  action="StaffStartQuiz">                   
                    <%-- Quiz Information --%>
                    <center><h2>Submit a Quiz</h2></center>
                    <br>
                    <form>
                       <div class="panel panel-default" style="width:75%;">
                       <div class="panel-heading">Quiz Options:</div>
                       <div class="panel-body">
                          
                        <input class="form-control" placeholder="Quiz Title:" style="width:30%;" type="text" name="title" minlength="4" required="required"><br>
                    
                     <input type="hidden" name="moduleID" value=<%=request.getAttribute("moduleID")%>>
                     <label>ModuleID: <%=request.getAttribute("moduleID")%><br></label>
                    
                    <%--<li>ModuleID: <input type="text" name="moduleID" minlength="1" maxlength="10"  required ="required"></li>--%>
                    <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="available" value="1" style="">Availability
                                    </label>
                                </div>
                   
                     <input class="form-control" placeholder="Number of questions to provide:" style="width:30%;" type="number" name="questionsnumber" minlength="1" required="required">   <br>
               
                <br/>
                <input class="btn btn-sm btn-success" style="border-style:solid;" type="submit" value="Start Quiz"> 
                    </form>
                        
                        </div>
              </div>
            </form>                   
          </div>
    </body>
</html>