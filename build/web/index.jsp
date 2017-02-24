<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Quiz Up</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles_index.css"/>
    </head>


    <body>


        <nav class="navbar navbar-default" style="border-bottom-left-radius: 0; border-bottom-right-radius: 0;">
            <div class="container-fluid">
                <a class="navbar-brand" href="#" style="padding:0%; "><img src='<%= request.getContextPath() %>/css/img/quizlogo.png'  height="60" width="80"></a>
            </div>
        </nav>

        <%
            if ((Boolean) request.getAttribute("check") != null) {
        %>
        
        <style>
            .alert {
                width: 20%;
                float: right;
                margin-right: 1%;
                font-size: 16px;
            }
        </style>


        <div class="alert alert-warning" role="alert">
            <span class="close" onclick="this.parentElement.style.display = 'none';">&times;</span>
            <strong>Incorrect</strong> username/password.

        </div>

        <%
            }
        %>

        <div class="login-page">
            <div class="form">
                <h3>QuizUp</h3>
                <form method="POST"  action="Login">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" name="username" id="username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" name="password" id="password">
                    </div>
                    <button type="submit" class="btn btn-default">Login</button>
                </form>
            </div>
        </div>



    </body>
</html>
