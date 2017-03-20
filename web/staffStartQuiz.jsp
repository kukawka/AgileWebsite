<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Beans.LoggedIn"%>
<!DOCTYPE html>
<html>
    <head>
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
    <body bgcolor="c0d13e">
         <jsp:include page="/navBar.jsp" />
        <article>       
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
        </article>
		 <footer>
            <ul>
                <%--<li class="footer"><a href="/">Home</a></li>--%>
            </ul>
        </footer>
    </body>
</html>