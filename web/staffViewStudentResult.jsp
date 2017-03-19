<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Beans.LoggedIn"%>
<!DOCTYPE html>
<html>
    <head>
        <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
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
        <header>
        
        </header>
       
        <article>
            
          <div class="main">
            <form method="POST"  action="StaffStartQuiz">
                <ul>
                    <h2>View Student's Result</h2>
                        <li>Student ID: <input type="text" name="studentID" minlength="4" required="required"></li>
                     <input type="hidden" name="quizID" value=<%=request.getAttribute("quizID")%>>
                    <li>For Quiz: <%=request.getAttribute("quizID")%></li><br>
                    <%-- Show title instead? --%>
                </ul>
                <br/>
                <input type="submit" value="Submit"> 
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
