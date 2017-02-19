<%-- 
    Document   : student_index
    Created on : Feb 18, 2017, 2:18:37 PM
    Author     : Dagi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Student Login</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">QuizUp</a>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="staff_index.jsp">Staff Login</a></li>
                </ul>
            </div>
        </nav>

        <div class="col-sm-6 col-md-4"></div> 
        <div class="col-sm-6 col-md-4" style="padding-top: 10% ;">
            <div class="thumbnail">
                <center>
                    <h3>Quiz Up</h3>
                    <form method="POST"  action="Login">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" name="username" id="username">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" name="password" id="password">
                        </div>
                        <input type="hidden" name="type" value="student">
                        <button type="submit" class="btn btn-default" value="Login">Log in</button>
                    </form>

                </center>
            </div>
        </div>
        <div class="col-sm-6 col-md-4"></div> 
    </body>
</html>
